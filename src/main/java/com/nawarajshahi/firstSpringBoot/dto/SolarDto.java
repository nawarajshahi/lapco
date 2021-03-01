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
public class SolarDto {
	
	private Integer restroom_id;
	private String model_no;
	private String serial_no;
	private Date date_installed;
	private Double total_cost_of_installation;
	private Double total_cost_of_production;
	
	private Integer readId;
	private String panelId;
	private double generatedQty;
	private double message;

}
