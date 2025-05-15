package junsung.variousimp.service;

import junsung.variousimp.dto.PostRequest;
import junsung.variousimp.entity.Post;
import junsung.variousimp.repository.CommentRepo;
import junsung.variousimp.repository.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final CommentRepo commentRepo;
    private final PostRepo postRepo;

    public Post save( PostRequest postRequest) {
        Post post = new Post(postRequest.getTitle(),postRequest.getContent(),postRequest.getAuthor());
        return postRepo.save(post);
    }
    public Post findPost(Long id){
        return postRepo.findPostWithComments(id).orElseThrow(() -> new IllegalArgumentException("게시물 없음"));
    }

    public Page<Post> findPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size , Sort.by("id").descending());
        return postRepo.findAll(pageable);
    }

    public void delete(Long id) {
         postRepo.deleteById(id);
    }

    public Page<Post> search( String keword ,int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size , Sort.by("id").descending());
        return postRepo.findByTitleContaining(keword, pageable);
    }
}
