package junsung.variousimp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor // ← Jackson 역직렬화용 생성자
public class PostRequest {
    private String title;
    private String content;
    private String author;
}

