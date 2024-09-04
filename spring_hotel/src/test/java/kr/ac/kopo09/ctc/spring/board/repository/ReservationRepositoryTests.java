package kr.ac.kopo09.ctc.spring.board.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import kr.ac.kopo09.ctc.spring.board.domain.Hotel;
import kr.ac.kopo09.ctc.spring.board.domain.ReservationForm;
import kr.ac.kopo09.ctc.spring.board.domain.User;
@SpringBootTest
class ReservationRepositoryTests {
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	HotelRepository hotelRepository;
	
	@BeforeEach
	void testUser() {
		userRepository.deleteAll();
		User user = new User();
		user.setUserid("kopo");
		user.setPassword("qwer");
		user.setType("1");
		user.setName("user1");
		userRepository.save(user);
		
		hotelRepository.deleteAll();
		Hotel hotel = new Hotel();
		hotel.setType(0);
		hotelRepository.save(hotel);
		Hotel hotel2 = new Hotel();
		hotel2.setType(1);
		hotelRepository.save(hotel2);
		Hotel hotel3 = new Hotel();
		hotel3.setType(2);
		hotelRepository.save(hotel3);
		
		ReservationForm reForm = new ReservationForm();
		reForm.setUser(user);
		reForm.setHotel(hotel);
		reForm.setReservation_date(new Date());
		reForm.setCheck_in_date(new Date());
		reForm.setCheck_out_date(new Date());
		reForm.setComment("테스트 하는중");
		reservationRepository.save(reForm);
	}
	
	@Test
	void testing() {
		List<ReservationForm> reserv = reservationRepository.findAll();
			System.out.println(reserv.get(0).getUser().getName());
	}

}
