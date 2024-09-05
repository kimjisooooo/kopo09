package kr.ac.kopo09.ctc.spring.board.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ac.kopo09.ctc.spring.board.domain.Sosick;
import kr.ac.kopo09.ctc.spring.board.domain.User;

@SpringBootTest
class SosickRepositoryTests {
	@Autowired
	SosickRepository sosickRepository;
	@Autowired
	UserRepository userRepository;

	@Test
	void test() {

		for (int i = 0; i < 100; i++) {
			Optional<User> userOptional = userRepository.findById(2L);

			if (userOptional.isPresent()) { // Optional 안에 User가 존재하는지 확인
				User user = userOptional.get(); // Optional에서 User 객체를 추출
				Sosick sosick = new Sosick();
				sosick.setTitle("테스트");
				sosick.setUserItem(user); // User 객체를 설정
				sosick.setDate(new Date());
				sosick.setContent("내용");
				sosickRepository.save(sosick); // null 대신 sosick 객체 저장
			} else {
				// 유저가 없을 경우에 대한 처리
				System.out.println("User not found");
			}
		}

	}

}
