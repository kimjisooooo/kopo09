package kr.ac.kopo09.ctc.spring.board.service;

import kr.ac.kopo09.ctc.spring.board.domain.Sosick;
import kr.ac.kopo09.ctc.spring.board.domain.Sosick_Comment;
import kr.ac.kopo09.ctc.spring.board.repository.SosickRepository;
import kr.ac.kopo09.ctc.spring.board.repository.Sosick_CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SosickServiceImpl implements SosickService {

	@Autowired
	private SosickRepository sosickRepository;

	@Autowired
	private Sosick_CommentRepository sosickCommentRepository;

	@Override
	public List<Sosick> search(String searchType, String keyword, int page, int sizePerPage) {
		PageRequest pageRequest = PageRequest.of(page - 1, sizePerPage);
		Page<Sosick> sosickPage = sosickRepository.search(searchType, keyword, pageRequest);
		return sosickPage.getContent();
	}

	@Override
	public List<Sosick> getPagination(int page, int sizePerPage, String searchType, String keyword) {
		PageRequest pageRequest = PageRequest.of(page - 1, sizePerPage);
		Page<Sosick> sosickPage = sosickRepository.search(searchType, keyword, pageRequest);
		return sosickPage.getContent();
	}

	@Override
	public List<Sosick> selectAll() {
		return sosickRepository.findAll();
	}

	@Override
	public Sosick create(String title, String content, Date date) {
		Sosick sosick = new Sosick();
		sosick.setTitle(title);
		sosick.setContent(content);
		sosick.setDate(date);
		return sosickRepository.save(sosick);
	}

	@Override
	public Sosick selectOne(int id) {
		return sosickRepository.findById(id).orElse(null);
	}

	@Override
	public Sosick update(int id, String title, String content, Date date) {
		Sosick sosick = sosickRepository.findById(id).orElse(null);
		if (sosick != null) {
			sosick.setTitle(title);
			sosick.setContent(content);
			sosick.setDate(date);
			return sosickRepository.save(sosick);
		}
		return null;
	}

	@Override
	public void delete(int id) {
		sosickRepository.deleteById(id);
	}


	@Override
	public void deleteComment(int commentId) {
		sosickCommentRepository.deleteById(commentId);
	}

	@Override
	public int count(String searchType, String keyword) {
		PageRequest pageRequest = PageRequest.of(0, Integer.MAX_VALUE);
		Page<Sosick> sosickPage = sosickRepository.search(searchType, keyword, pageRequest);
		return (int) sosickPage.getTotalElements();
	}

	@Override
	public List<Sosick_Comment> getComments(int rootId) {
		// TODO Auto-generated method stub
		return sosickCommentRepository.findBySosick_IdOrderByRelevelAscRecntAsc(rootId);
	}

	@Override
	public Sosick_Comment addComment(int rootId, String content) {
		Sosick sosick = sosickRepository.findById(rootId).orElse(null);
		if (sosick != null) {
			Sosick_Comment comment = new Sosick_Comment(content, sosick);
			return sosickCommentRepository.save(comment);
		}
		return null;
	}
}
