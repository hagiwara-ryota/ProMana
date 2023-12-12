package com.example.ProMana.form;

import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProducedCaseCountForm {
	
	private int lineId;
	
	@NumberFormat(style = NumberFormat.Style.NUMBER)
	@NotNull(message = "空白は許可されていません")
	@Min(value = 1, message = "正数を入力してください")
	private int count;

}
