package idusw.soccerworld.domain.entity;

import lombok.Data;

@Data
public class CommentDTO {

    private int comment_id;

    private int team_id;

    private int player_id;

    private int post_id;

    private int reply_id;

    private String content;

    private int up_count = 0;

    private int down_count = 0;

    private String regdate;

}
