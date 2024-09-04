package kr.ac.kopo09.ctc.spring.board.service;
import java.util.Date;
import java.util.Map;
public interface ReservationService {
	Map<Date, Map<Integer, String>> getReservationStatus();
}
