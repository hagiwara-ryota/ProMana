package com.example.ProMana.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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