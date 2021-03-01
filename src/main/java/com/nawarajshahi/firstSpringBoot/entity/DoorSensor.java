package com.nawarajshahi.firstSpringBoot.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DoorSensor implements Serializable{

	/**
	 * serialVersionUID = 5268777718676954820L
	 */
	private static final long serialVersionUID = 5268777718676954820L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "read_id")
	private Integer readId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restroom_id")
	private Restroom restroom;
	
	@Column(name = "door_id")
	private String doorId;
	
	@Column(name = "door_open_time")
	private LocalDateTime doorOpenTime;
	
	@Column(name = "door_close_time")
	private LocalDateTime doorCloseTime;
	
	@Column(name = "message")
	private String message;

	
}
