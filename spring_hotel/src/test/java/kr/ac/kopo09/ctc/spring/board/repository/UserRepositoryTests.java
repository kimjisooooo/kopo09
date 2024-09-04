package kr.ac.kopo09.ctc.spring.board.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.Column;
import kr.ac.kopo09.ctc.spring.board.domain.User;
@SpringBootTest
class UserRepositoryTests {
	@Autowired
	UserRepository userRepository;
	@BeforeEach
	void testUser() {
		userRepository.deleteAll();
		User user = new User();
		user.setUserid("kopo");
		user.setPassword("qwer");
		user.setType("1");
		user.setName("user1");
		userRepository.save(user);
	}
	
	@Test
	void testing() {
		List<User> user = userRepository.selectAll();
			System.out.println(user.get(0).getName());
	}
	

}
