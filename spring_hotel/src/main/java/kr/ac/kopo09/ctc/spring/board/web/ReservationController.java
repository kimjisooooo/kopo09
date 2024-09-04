package kr.ac.kopo09.ctc.spring.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationController {
	@RequestMapping("/d_01")
	public String main(Model model) {
		return "/reservation/reservationPage";
	}
}
