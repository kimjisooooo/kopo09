package kr.ac.kopo09.ctc.spring.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo09.ctc.spring.board.domain.Hotel;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
	Hotel findByType(int type);
}
