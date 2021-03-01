package com.nawarajshahi.firstSpringBoot.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestroomDto {
	private Integer restroom_id;
	private String model_no;
	private String serial_no;
	private Date date_installed;
	private Double total_cost_of_installation;
	private Double total_cost_of_production;
	
	private Integer address_id;
	private String street;
	private String city;
	private String state;
	private String zipcode;

}
