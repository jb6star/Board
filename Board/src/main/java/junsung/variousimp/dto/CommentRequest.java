package junsung.variousimp.dto;

import junsung.variousimp.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentRequest {
    private String comment;
    private String author;

    public CommentRequest(Comment comment) {
        this.comment = comment.getComment();
        this.author = comment.getAuthor();


    }
}
