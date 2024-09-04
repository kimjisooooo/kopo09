package kr.ac.kopo09.ctc.spring.board.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Sosick {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private Date date;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_item_id")
	@JsonBackReference
	private User userItem;

    @OneToMany(mappedBy = "sosick", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sosick_Comment> comments;  // 정확한 타입 사용
}
