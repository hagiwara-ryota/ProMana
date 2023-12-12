package com.example.ProMana.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LinesForm {

	@NotBlank
	private String name;

	@NotBlank
	private String product_name;

	@NotNull(message = "空白は許可されていません")
	@Min(value = 1, message = "正数を入力してください")
	private Integer case_count_per_hour;

}