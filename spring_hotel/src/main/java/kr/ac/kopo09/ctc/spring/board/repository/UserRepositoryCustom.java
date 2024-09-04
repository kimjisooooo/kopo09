package kr.ac.kopo09.ctc.spring.board.repository;

import java.util.List;

import kr.ac.kopo09.ctc.spring.board.domain.User;

public interface UserRepositoryCustom {
	List<User> selectAll();
}
