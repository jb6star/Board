package junsung.variousimp.controller;


import io.swagger.v3.oas.annotations.Operation;
import junsung.variousimp.dto.CommentRequest;
import junsung.variousimp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @Operation(
            summary = "댓글 생성",
            description = "게시글 ID를 찾고, 그 게시글에 댓글을 작성합니다."
    )
    @PostMapping("/{id}")
    public ResponseEntity WriteComment(@RequestBody CommentRequest req ,@PathVariable long id) {
        commentService.save(req,id);
        return ResponseEntity.ok().build();
    }
}
