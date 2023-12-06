package com.example.ProMana.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlansForm {

	private Long lines_Id;

	@NotNull(message = "空白は許可されていません")
	@Min(value = 1, message = "正数を入力してください")
	private Integer planned_case_count;
}
