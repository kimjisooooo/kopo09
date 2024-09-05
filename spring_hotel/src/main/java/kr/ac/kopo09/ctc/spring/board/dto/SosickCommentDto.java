package kr.ac.kopo09.ctc.spring.board.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SosickCommentDto {
	private Long id;
	private String content;
	private String name;
	private Long user_id;
	private List<SosickCommentDto> childComment;
	private int depth;
}
