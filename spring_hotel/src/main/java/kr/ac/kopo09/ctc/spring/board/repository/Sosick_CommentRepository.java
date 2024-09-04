package kr.ac.kopo09.ctc.spring.board.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kr.ac.kopo09.ctc.spring.board.domain.Sosick_Comment;

@Repository
public interface Sosick_CommentRepository extends JpaRepository<Sosick_Comment, Integer> {
    
    List<Sosick_Comment> findBySosick_IdOrderByRelevelAscRecntAsc(int sosickId);
}
