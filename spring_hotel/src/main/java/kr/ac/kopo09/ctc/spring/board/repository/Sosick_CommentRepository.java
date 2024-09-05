package kr.ac.kopo09.ctc.spring.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import kr.ac.kopo09.ctc.spring.board.domain.Sosick_Comment;

@Repository
public interface Sosick_CommentRepository extends JpaRepository<Sosick_Comment, Integer>, JpaSpecificationExecutor<Sosick_Comment> {
    @Query("SELECT bc FROM Sosick_Comment bc LEFT JOIN FETCH bc.childComments WHERE bc.sosick.id = :sosick_id")
    List<Sosick_Comment> findBySosickId(@Param("sosick_id") Long sosickId);

    List<Sosick_Comment> findAllBySosickId(Long sosickId);
	
	Optional<Sosick_Comment> findById(Long sosickId);
	
}
