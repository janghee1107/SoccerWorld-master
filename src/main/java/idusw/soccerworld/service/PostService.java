package idusw.soccerworld.service;

import idusw.soccerworld.domain.entity.PostDTO;
import idusw.soccerworld.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostDTO> selectedCategory(int categoryId) {
        return postRepository.selectedCategory(categoryId);
    }

    public void create(PostDTO postDTO) {
        postRepository.create(postDTO);
    }

    public void updateViewCount(int postId) {
        postRepository.updateViewCount(postId);
    }

    public PostDTO findById(int postId) {
        return postRepository.findById(postId);
    }

    public void updatePost(PostDTO postDTO, int postId) {
        postRepository.updatePost(postDTO, postId);
    }

    public void deletePost(int postId) {
        postRepository.deletePost(postId);
    }
}
