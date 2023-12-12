package com.example.ProMana.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

import lombok.Data;

@Data
public class ProducedCaseCountForm {
	
	private int lineId;
	
	@NumberFormat(style = NumberFormat.Style.NUMBER)
	@NotNull(message = "空白は許可されていません")
	@Min(value = 1, message = "正数を入力してください")
	private int count;

}
