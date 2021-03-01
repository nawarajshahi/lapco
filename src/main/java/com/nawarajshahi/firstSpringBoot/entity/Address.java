package com.nawarajshahi.firstSpringBoot.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Address implements Serializable{
	
	/**
	 * serialVersionUID = 8321217857646992790L
	 */
	private static final long serialVersionUID = 8321217857646992790L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer address_id;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zipcode")
	private String zipcode;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	private List<Restroom> restrooms;

	
}
