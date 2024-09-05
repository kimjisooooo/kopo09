package kr.ac.kopo09.ctc.spring.board.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kr.ac.kopo09.ctc.spring.board.domain.Sosick;


@Repository
public interface SosickRepository extends JpaRepository<Sosick, Integer> {
	
	Optional<Sosick> findById(Long articleId);
	
	 @Query("SELECT g FROM Sosick g WHERE (:searchType IS NULL OR g.title LIKE %:keyword% OR g.content LIKE %:keyword%)")
	 Page<Sosick> search(String searchType, String keyword, Pageable pageable);
}
