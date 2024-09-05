package kr.ac.kopo09.ctc.spring.board.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ac.kopo09.ctc.spring.board.domain.Hotel;
import kr.ac.kopo09.ctc.spring.board.domain.ReservationForm;
import kr.ac.kopo09.ctc.spring.board.domain.User;
import kr.ac.kopo09.ctc.spring.board.repository.HotelRepository;
import kr.ac.kopo09.ctc.spring.board.repository.ReservationRepository;
import kr.ac.kopo09.ctc.spring.board.repository.UserRepository;
import kr.ac.kopo09.ctc.spring.board.service.ReservationService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	HotelRepository hotelRepository;
	@Autowired
	ReservationRepository reservationRepository;
	@RequestMapping("/d_01")
	public String main(Model model) {
		Map<Date, Map<Integer, String>> reservationStatus = reservationService.getReservationStatus();
		model.addAttribute("reservationStatus", reservationStatus);
		return "/reservation/reservationPage";
	}
	
	@RequestMapping("/reservationPage")
	public String ReservationPage(@RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
								  @RequestParam(value = "roomType", required = false) int roomType,
			Model model) {
				model.addAttribute("date",date);
				model.addAttribute("roomType", roomType);
		return "/reservation/reservation";
	}
	
	@RequestMapping("/try_reservation")
	public String try_reservation(@RequestParam(value = "check_in_date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam(value = "room_type", required = false) int roomType,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "user_name", required = false) String user_name,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "who", required = false) String who,
			@RequestParam(value = "content", required = false) String content,
			RedirectAttributes rttr,
			Model model) {
		System.out.println(user_name);
		System.out.println(date);
		System.out.println(roomType);
		ReservationForm reservationForm = reservationRepository.findByCheckInDateAndHotelType(date, roomType);
	    if (reservationForm == null) {
	    	User user = userRepository.findByName(user_name);
			if(user == null || user.equals(0)) {
				rttr.addFlashAttribute("Message", "해당 사용자는 존재하지 않습니다");
				return "redirect:/d_01";
			}
			Hotel hotel = hotelRepository.findByType(roomType);
			if(hotel == null || hotel.equals(0)) {
				rttr.addFlashAttribute("Message", "해당 방은 존재하지 않습니다");
				return "redirect:/d_01";
			}
			ReservationForm reForm = new ReservationForm();
			reForm.setUser(user);
			reForm.setHotel(hotel);
			reForm.setReservationDate(new Date());
			reForm.setCheckInDate(date);
			reForm.setCheckOutDate(date);
			reForm.setComment(content);
			reservationRepository.save(reForm);
			return "redirect:/d_01";
	    } else {
	    	rttr.addFlashAttribute("Message", "이미 예약된 방입니다 다른곳을 알아봐주세요");
	        return "redirect:/d_01";
	    }
		
	}
	
}
