package idusw.soccerworld.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDTO {

    private int category_id;

    private int post_id;

    private int member_id;

    private String  title;

    private String  content;

    private int up_count = 0;

    private int down_count = 0;

    private int view_count = 0;

    private String  regdate ;

    private String  picture;

}
