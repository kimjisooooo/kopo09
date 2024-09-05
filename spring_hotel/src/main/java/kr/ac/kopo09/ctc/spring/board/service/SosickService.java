package kr.ac.kopo09.ctc.spring.board.service;

import kr.ac.kopo09.ctc.spring.board.domain.Sosick;
import kr.ac.kopo09.ctc.spring.board.domain.Sosick_Comment;
import kr.ac.kopo09.ctc.spring.board.dto.SosickCommentDto;

import java.util.Date;
import java.util.List;

public interface SosickService {
    List<Sosick> search(String searchType, String keyword, int page, int sizePerPage);
    List<Sosick> getPagination(int page, int sizePerPage, String searchType, String keyword);
    List<Sosick> selectAll();
    Sosick create(String title, String content, Date date);
    Sosick selectOne(int id);
    Sosick update(int id, String title, String content, Date date);
    void delete(int id);
    void deleteComment(int commentId);
    int count(String searchType, String keyword);
    List<SosickCommentDto> getSosickCommentDtosBySosickId(Long sosickId);
}
