package com.nawarajshahi.firstSpringBoot.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Solar implements Serializable {

	/**
	 * serialVersionUID = -6237620671977622286L
	 */
	private static final long serialVersionUID = -6237620671977622286L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "read_id")
	private Integer readId;
	
	@Column(name = "panel_id")
	private String panelId;
	
	@Column(name = "generated_qty")
	private Double generatedQty;
	
	@Column(name = "message")
	private String message;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "solar_restroom", 
			joinColumns = @JoinColumn(name = "solar_read_id", referencedColumnName = "read_id"),
			inverseJoinColumns = @JoinColumn(name = "restroom_id", referencedColumnName = "restroom_id"))
	private List<Restroom> restrooms = new ArrayList<Restroom>();
	
}
