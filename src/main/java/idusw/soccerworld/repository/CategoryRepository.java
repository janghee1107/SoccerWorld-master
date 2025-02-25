package idusw.soccerworld.repository;

import idusw.soccerworld.domain.entity.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {
    private  final SqlSessionTemplate sql;

    public  List<CategoryDTO> findAll() {
        return sql.selectList("categoryMapper.findAll");
    }
}
