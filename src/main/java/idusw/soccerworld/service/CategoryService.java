package idusw.soccerworld.service;

import idusw.soccerworld.domain.entity.CategoryDTO;
import idusw.soccerworld.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public  List<CategoryDTO> findAll() {
        return categoryRepository.findAll();
    }
}
