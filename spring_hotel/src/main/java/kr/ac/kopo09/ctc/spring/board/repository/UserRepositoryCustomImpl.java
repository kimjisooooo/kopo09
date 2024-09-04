package kr.ac.kopo09.ctc.spring.board.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.querydsl.jpa.impl.JPAQueryFactory;
import static kr.ac.kopo09.ctc.spring.board.domain.QUser.user;
import kr.ac.kopo09.ctc.spring.board.domain.User;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {
	@Autowired
    private JPAQueryFactory jpaQueryFactory;
	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return jpaQueryFactory
                .selectFrom(user)
                .fetch();
	}

}
