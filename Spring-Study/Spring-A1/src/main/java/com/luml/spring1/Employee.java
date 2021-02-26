package com.luml.spring1;


/**
 * @author luml
 */
public class Employee {
	private Car car;

	public void setCar(Car car) {
		System.out.println("正在调用setCar方法。。。");
		this.car = car;
	}

	public Car getCar() {
		return car;
	}
}
