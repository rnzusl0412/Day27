package com.test00;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MTest03 implements Serializable {
	private int num1;
	private int num2;
	private String operator;

	public MTest03(int num1, int num2, String operator) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.operator = operator;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}
