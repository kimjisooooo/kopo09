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
public class User {
   @Id
   @GeneratedValue
   private Long id;
   
   @Column
   private String userid;
   
   @Column
   private String password;
   
   @Column
   private String name;
   
   @Column
   private String type;
   
   public boolean isAdmin() {
	   return this.type.equals("ROLE_ADMIN");
   }
}
