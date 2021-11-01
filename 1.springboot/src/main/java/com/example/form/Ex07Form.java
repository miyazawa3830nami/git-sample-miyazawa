package com.example.form;

public class Ex07Form {
	/** num1 */
	private String num1;
	/** num2 */
	private String num2;
	
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	public void setNum2(String num2) {
		this.num2 = num2;
	}
	public String getNum1() {
		return num1;
	}
	public String getNum2() {
		return num2;
	}
	/** intに変換 */
	public int getIntNum1() {
		return Integer.parseInt(num1);
	}
	public int getIntNum2() {
		return Integer.parseInt(num2);
	}
	
	@Override
	public String toString() {
		return "Ex07Form [num1=" + num1 + ", num2=" + num2 + "]";
	}
	
}
