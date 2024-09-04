package kr.ac.kopo09.ctc.spring.board.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.ac.kopo09.ctc.spring.board.domain.ReservationForm;
@Repository
public interface ReservationRepository extends JpaRepository<ReservationForm, Long> {
	// 특정 날짜의 예약 정보를 조회하는 메서드
	@Query("SELECT r FROM ReservationForm r " + "LEFT JOIN FETCH r.user " + "LEFT JOIN FETCH r.hotel hr "
	         + "WHERE :targetDate BETWEEN r.checkInDate AND r.checkOutDate " + "ORDER BY r.checkInDate DESC")
	List<ReservationForm> findByReservationDate(@Param("targetDate") Date targetDate);
}
