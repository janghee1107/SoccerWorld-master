package idusw.soccerworld.controller;


import idusw.soccerworld.domain.entity.CategoryDTO;
import idusw.soccerworld.domain.entity.PostDTO;
import idusw.soccerworld.service.CategoryService;
import idusw.soccerworld.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommunityController {

    private final CategoryService categoryService;
    private final PostService postService;

    @RequestMapping(method = RequestMethod.GET,value = "/")
    public String goIndex(){
        return "/main/index";
    }

    //  카테고리 불러오기 및 해당 카테고리의 post 불러오기
    @GetMapping("/category/list")
    public String findAll(@RequestParam(value= "id", defaultValue = "1") int categoryId, Model model){
        List<CategoryDTO> categoryDTOList = categoryService.findAll();
        model.addAttribute("categoryList", categoryDTOList);

        model.addAttribute("currentCategory", categoryId);

        List<PostDTO> postDTOList = postService.selectedCategory(categoryId);
        model.addAttribute("postList", postDTOList);
        return "/community/list";

    }

    @GetMapping("/category/{id}")
    public String selectedCategory(@PathVariable("id") int categoryId, Model model){
        List<CategoryDTO> categoryDTOList = categoryService.findAll();
        model.addAttribute("categoryList", categoryDTOList);

        model.addAttribute("currentCategory", categoryId);

        List<PostDTO> postDTOList = postService.selectedCategory(categoryId);
        model.addAttribute("postList", postDTOList);
        return "/community/list";
    }

    //  post 생성
    @GetMapping("/post/create")
    public String create(Model model){
        List<CategoryDTO> categoryDTOList = categoryService.findAll();
        model.addAttribute("categoryList", categoryDTOList);
        return "community/create";
    }

    @PostMapping("/post/create")
    public String create(Model model, PostDTO postDTO){
        List<CategoryDTO> categoryDTOList = categoryService.findAll();
        model.addAttribute("categoryList", categoryDTOList);

        postService.create(postDTO);
        return "redirect:/category/list";
    }

    //  post detail
    @GetMapping("/post/{id}/{categoryId}")
    public String findById(@PathVariable("id") int postId, @PathVariable("categoryId") int categoryId, Model model) {
        List<CategoryDTO> categoryDTOList = categoryService.findAll();
        model.addAttribute("categoryList", categoryDTOList);

        model.addAttribute("currentCategory", categoryId);

        postService.updateViewCount(postId);    //  조회수 처리

        PostDTO postDTO = postService.findById(postId); // 게시글 내용
        model.addAttribute("post", postDTO);
        System.out.println("postId = " + postId + ", categoryId = " + categoryId + ", model = " + model);
        return "/community/detail";
    }

    //  post update
    @GetMapping("post/update/{id}")
    public String updatePost(@PathVariable("id") int postId, Model model) {
        PostDTO postDTO = postService.findById(postId);
        model.addAttribute("post", postDTO);

        List<CategoryDTO> categoryDTOList = categoryService.findAll();
        model.addAttribute("categoryList", categoryDTOList);
        return "community/update";
    }

    @PostMapping("post/update/{id}")
    public String updatePost(@PathVariable("id") int postId, PostDTO postDTO, Model model, RedirectAttributes redirectAttributes) {
        postService.updatePost(postDTO,postId);
        redirectAttributes.addFlashAttribute("message", "게시물이 성공적으로 수정되었습니다.");
        return "redirect:/post/" + postId + "/" + postDTO.getCategory_id();
    }

    //  post delete
    @GetMapping("post/delete/{id}")
    public String deletePost(@PathVariable("id") int postId) {
        postService.deletePost(postId);
        return "redirect:/category/list";
    }
}

