package junsung.variousimp.service;

import jakarta.transaction.Transactional;
import junsung.variousimp.dto.CommentRequest;
import junsung.variousimp.entity.Comment;
import junsung.variousimp.repository.CommentRepo;
import junsung.variousimp.repository.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepo commentRepo;
    private final PostService postService;

    public Comment save(CommentRequest req,long id) {
        Comment comment = new Comment(req.getComment(),req.getAuthor(),postService.findPost(id));

        return  commentRepo.save(comment);
    }


}
