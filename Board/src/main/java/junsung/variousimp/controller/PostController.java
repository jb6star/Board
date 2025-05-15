package junsung.variousimp.controller;

import junsung.variousimp.dto.PostRequest;
import junsung.variousimp.dto.PostResponse;
import junsung.variousimp.dto.SearchResponse;
import junsung.variousimp.entity.Post;
import junsung.variousimp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Operation(
            summary = "게시글 작성",
            description = "제목, 내용, 작성자를 포함한 게시글을 작성합니다."
    )
    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest postRequest) {
        Post post = postService.save(postRequest);
        return ResponseEntity.ok(PostResponse.from(post));
    }

    @Operation(
            summary = "게시글 수정",
            description = "ID에 해당하는 게시글을 수정합니다. 제목과 내용 정보를 수정할 수 있습니다."
    )
    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> updatePostById(@PathVariable Long id, @RequestBody PostRequest postRequest) {
        Post post = postService.findPost(id);
        post.update(postRequest.getTitle(), postRequest.getContent());
        return ResponseEntity.ok(PostResponse.from(post));
    }

    @Operation(
            summary = "게시글 삭제",
            description = "ID에 해당하는 게시글을 삭제합니다."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "게시글 단건 조회",
            description = "ID 값을 기준으로 게시글 상세 정보를 조회합니다."
    )
    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable Long id) {
        Post post = postService.findPost(id);
        return ResponseEntity.ok(PostResponse.from(post));
    }

    @Operation(
            summary = "게시글 목록 조회 (페이징)",
            description = "page와 size 값을 기준으로 게시글 목록을 페이징 조회합니다. 기본값은 page=1, size=5 입니다."
    )
    @GetMapping
    public ResponseEntity<Page<PostResponse>> getPosts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<Post> postPage = postService.findPosts(page, size);
        Page<PostResponse> dtoPage = postPage.map(PostResponse::from);
        return ResponseEntity.ok(dtoPage);
    }

        @Operation(
                summary = "게시글 제목 검색",
                description = "입력된 키워드가 포함 된 제목의 게시글을 페이징 조회"
        )
        @GetMapping("/search")
        public ResponseEntity<SearchResponse> searchPosts(
                @RequestParam String keyword,
                @RequestParam(defaultValue = "1") int page,
                @RequestParam(defaultValue = "5") int size
        ){
            Page<Post> postPage = postService.search(keyword, page, size);

            List<String> titles = postPage.getContent()
                                            .stream()
                                            .map(Post :: getTitle)
                                            .toList();

            SearchResponse response = SearchResponse.builder()
                    .currentPage(postPage.getNumber() + 1) // 페이지는 0부터 시작하니까 +1
                    .totalPages(postPage.getTotalPages())
                    .isFirst(postPage.isFirst())
                    .isLast(postPage.isLast())
                    .titles(titles)
                    .build();

    return ResponseEntity.ok(response);
    }}