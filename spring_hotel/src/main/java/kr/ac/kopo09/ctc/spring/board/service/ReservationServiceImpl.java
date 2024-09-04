package kr.ac.kopo09.ctc.spring.board.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo09.ctc.spring.board.domain.ReservationForm;
import kr.ac.kopo09.ctc.spring.board.repository.ReservationRepository;
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    
    @Override
    public Map<Date, Map<Integer, String>> getReservationStatus() {
        // 날짜 형식과 날짜 범위 설정
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
        Map<Date, Map<Integer, String>> reservationMap = new LinkedHashMap<>(); // LinkedHashMap으로 변경

        for (int i = 0; i < 30; i++) {
            Date currentDate = cal.getTime();
            
            // 방 유형별 예약 상태를 저장할 Map
            Map<Integer, String> roomStatus = new HashMap<>();
            
            // 모든 방 유형에 대해 기본값 "예약가능"으로 설정
            roomStatus.put(1, "예약가능");
            roomStatus.put(2, "예약가능");
            roomStatus.put(3, "예약가능");
            // 특정 날짜의 예약 정보 조회
            List<ReservationForm> reservations = reservationRepository.findByReservationDate(currentDate);
            for (ReservationForm reservation : reservations) {
                // User의 이름을 가져옴
                String userName = reservation.getUser().getName();
                roomStatus.put(reservation.getHotel().getType(), userName);
            }
            
            reservationMap.put(currentDate, roomStatus);
            cal.add(Calendar.DATE, 1); // 다음 날짜로 이동
        }

        return reservationMap;
    }
}
