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

import kr.ac.kopo09.ctc.spring.board.repository.ReservationRepository;
import kr.ac.kopo09.ctc.spring.board.service.ReservationService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
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
	
}
