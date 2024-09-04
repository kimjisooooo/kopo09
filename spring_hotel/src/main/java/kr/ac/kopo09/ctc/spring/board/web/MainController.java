package kr.ac.kopo09.ctc.spring.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String main(Model model) {
		return "/main/main";
	}
	
	@RequestMapping("/hotel")
	public String hotel(Model model) {
		return "/main/main";
	}
	
	@RequestMapping("/main")
	public String main2(Model model) {
		return "/main/main";
	}
	@RequestMapping("/a_01")
	public String a_01(Model model) {
		return "/main/a_01";
	}
	
	@RequestMapping("/hoogi")
	public String hoogi(Model model) {
		return "/e_02";
	}

}
