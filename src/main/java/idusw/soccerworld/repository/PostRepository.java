package idusw.soccerworld.repository;

import idusw.soccerworld.domain.entity.PostDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {
    private  final SqlSessionTemplate sql;

    public List<PostDTO> selectedCategory(int categoryId) {
        return sql.selectList("postMapper.selectedCategory", categoryId);
    }

    public void create(PostDTO postDTO) {
        sql.insert("postMapper.create", postDTO);
    }

    public void updateViewCount(int postId) {
        sql.update("postMapper.updateViewCount", postId);
    }

    public PostDTO findById(int postId) {
        return sql.selectOne("postMapper.findById", postId);
    }

    public void updatePost(PostDTO postDTO, int postId) {
        postDTO.setPost_id(postId);
        sql.update("postMapper.updatePost", postDTO);
    }

    public void deletePost(int postId) {
        sql.delete("postMapper.deletePost", postId);
    }
}
