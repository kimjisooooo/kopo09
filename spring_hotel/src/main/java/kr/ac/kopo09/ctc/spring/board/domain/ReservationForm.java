package kr.ac.kopo09.ctc.spring.board.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ReservationForm {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@JsonBackReference
	private User user;

	@ManyToOne
	@JoinColumn(name = "hotel_id", nullable = false)
	@JsonBackReference
	private Hotel hotel;

	@Column(name = "reservation_date")
	@Temporal(TemporalType.DATE)
	private Date reservationDate;

	@Column(name = "check_in_date")
	@Temporal(TemporalType.DATE)
	private Date checkInDate;

	@Column(name = "check_out_date")
	@Temporal(TemporalType.DATE)
	private Date checkOutDate;

	@Column
	private String comment;
}
