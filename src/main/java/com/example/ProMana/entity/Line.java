package com.example.ProMana.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name = "lines")
@Data
public class Line extends AbstractEntity {
	
	 @Transient
	    private LocalDateTime calculatedValue;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String product_name;

	@Column(nullable = false)
	private int case_count_per_hour;

	@OneToOne(mappedBy = "lines")
	private Plan plan;

	@OneToOne(mappedBy = "lines")
	private ProducedCaseCount producedCaseCount;

	@Override
	public String toString() {
		return "オブジェクト生成";

	}

	public int getPlannedCaseCount() {
		// ここで計画されたケースの取得ロジックを実装する
		if (plan != null) {
			return plan.getPlannedCaseCount();
		} else {
			return 0; // もしくはデフォルトの値を返すなど
		}
	}

	public int getCount() {
		// ここで実際の件数の取得ロジックを実装する
		if (producedCaseCount != null) {
			return producedCaseCount.getCount();
		} else {
			return 0; // もしくはデフォルトの値を返すなど
		}
	}
	
    public LocalDateTime getCalculatedValue() {
        return calculatedValue;
    }

    public void setCalculatedValue(LocalDateTime calculatedValue) {
        this.calculatedValue = calculatedValue;
    }
}
