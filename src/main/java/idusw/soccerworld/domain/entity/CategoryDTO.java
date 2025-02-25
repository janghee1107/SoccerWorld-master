package idusw.soccerworld.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {

    private int category_id;

    private String name;

}
