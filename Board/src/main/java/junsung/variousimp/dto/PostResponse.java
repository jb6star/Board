package junsung.variousimp.dto;

import junsung.variousimp.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Getter
public class PostResponse {
    private long id;
    private String title;
    private String author;
    private List<CommentRequest> comments;

    @Builder
    public PostResponse(long id, String title, String author, List<CommentRequest> comments) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.comments = comments;
    }

    public static PostResponse from(Post post) {
        List<CommentRequest> commentDtoList = post.getComments()
                .stream()
                .map(CommentRequest::new)
                .toList();

        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .author(post.getAuthor())
                .comments(commentDtoList)
                .build();
    }
}
