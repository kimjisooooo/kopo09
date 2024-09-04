package kr.ac.kopo09.ctc.spring.board.service;

import kr.ac.kopo09.ctc.spring.board.domain.Sosick;
import kr.ac.kopo09.ctc.spring.board.domain.Sosick_Comment;
import java.util.Date;
import java.util.List;

public interface SosickService {
    List<Sosick> search(String searchType, String keyword, int page, int sizePerPage);
    List<Sosick> getPagination(int page, int sizePerPage, String searchType, String keyword);
    List<Sosick> selectAll();
    List<Sosick_Comment> getComments(int rootId);
    Sosick create(String title, String content, Date date);
    Sosick selectOne(int id);
    Sosick update(int id, String title, String content, Date date);
    Sosick_Comment addComment(int rootId, String content);
    void delete(int id);
    void deleteComment(int commentId);
    int count(String searchType, String keyword);
}
