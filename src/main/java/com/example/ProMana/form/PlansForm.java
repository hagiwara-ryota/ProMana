package com.example.ProMana.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PlansForm {

	private int lineId;

	@NotNull(message = "空白は許可されていません")
	@Min(value = 1, message = "正数を入力してください")
	private Integer plannedCaseCount;
}
