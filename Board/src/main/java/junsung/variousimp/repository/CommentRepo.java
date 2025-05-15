package junsung.variousimp.repository;

import junsung.variousimp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

}
