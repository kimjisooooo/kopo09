package kr.ac.kopo09.ctc.spring.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Sosick_Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "sosick_id", nullable = false)
    private Sosick sosick;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column
    private String content;
    
    // 부모 댓글 참조
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_id", nullable = true)
    private Sosick_Comment parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sosick_Comment> childComments = new ArrayList<>();

    
	 // 댓글 깊이 계산 메서드
	    public int getDepth() {
	        int depth = 0;
	        Sosick_Comment current = this;
	        while (current.getParentComment() != null) {
	            depth++;
	            current = current.getParentComment();
	        }
	        return depth;
	    }
}
