package kr.ac.kopo09.ctc.spring.board.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Hotel {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private int type;
}
