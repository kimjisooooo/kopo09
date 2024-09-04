package kr.ac.kopo09.ctc.spring.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.ac.kopo09.ctc.spring.board.domain.ReservationForm;

public interface ReservationRepository extends JpaRepository<ReservationForm, Long>{

}
