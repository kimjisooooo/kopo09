package kr.ac.kopo09.ctc.spring.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Sosick_Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "sosick_id", nullable = false)
    private Sosick sosick;

    private String content;
    private String author;
    private Date date;
    private int relevel;
    private int recnt;

    public Sosick_Comment(String content, Sosick sosick) {
        this.content = content;
        this.sosick = sosick;
        this.date = new Date();  // 기본적으로 현재 날짜와 시간을 설정합니다.
        this.relevel = 0;  // 기본값으로 설정할 수 있습니다.
        this.recnt = 0;    // 기본값으로 설정할 수 있습니다.
    }
}
