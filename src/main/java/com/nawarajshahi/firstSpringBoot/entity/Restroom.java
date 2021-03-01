package com.nawarajshahi.firstSpringBoot.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restroom implements Serializable{

	/**
	 * serialVersionUID = -777558383827281890L
	 */
	private static final long serialVersionUID = -777558383827281890L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restroom_id;
	
	
	@Column(name = "model_no")
	private String model_no;
	
	@Column(name = "serial_no")
	private String serial_no;
	
	@Column(name = "date_installed")
	private Date date_installed;
	
	@Column(name = "total_cost_of_installation")
	private Double total_cost_of_installation;
	
	@Column(name = "total_cost_of_production")
	private Double total_cost_of_production;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "restrooms")
	private List<Solar> solars = new ArrayList<Solar>();
	
	
	

}
