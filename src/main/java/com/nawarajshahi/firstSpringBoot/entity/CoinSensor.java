package com.nawarajshahi.firstSpringBoot.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
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

public class CoinSensor implements java.io.Serializable {

	/**
	 * serialVersionUID = 8136635256361091471L
	 */
	private static final long serialVersionUID = 8136635256361091471L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "read_id")
	private Integer readId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restroom_id")
	private Restroom restroom;
	
	@Column(name = "sensor_id")
	private String sensorId;
	
	@Column(name = "read_datetime")
	private LocalDateTime readDatetime;
	
	@Column(name = "no_of_quarters")
	private Integer noOfQuarters;
	
	@Column(name = "message")
	private String message;

	

}
