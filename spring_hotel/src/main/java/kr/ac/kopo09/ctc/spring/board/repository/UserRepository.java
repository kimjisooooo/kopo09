package kr.ac.kopo09.ctc.spring.board.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo09.ctc.spring.board.domain.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>, UserRepositoryCustom{
	Optional<User> findById(Long id);
}
