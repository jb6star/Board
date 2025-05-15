package junsung.variousimp.repository;

import junsung.variousimp.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    Page<Post> findByTitleContaining(String keyword, Pageable pageable);
    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.comments where p.id = :id")
    Optional<Post> findPostWithComments(@Param("id") long id);
}
