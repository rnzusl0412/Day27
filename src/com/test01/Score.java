package com.test01;

public class Score {
	private String name;
	private int kor;
	private int eng;
	private int math;

	public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return kor + eng + math;
	}

	public double getAvg() {
		return getSum() / 3.0;
	}

	public String getGrade() {
		if (getAvg() >= 90.0) {
			return "A";
		} else if (getAvg() >= 70.0) {
			return "B";
		} else if (getAvg() >= 50.0) {
			return "C";
		} else if (getAvg() >= 30.0) {
			return "D";
		}
		return "F";
	}
}
