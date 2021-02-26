package com.lumlb.spring.fromNet.springAop.byPojo;


public class SleepHelper{
	
	public void beforeSleep(){
		System.out.println("通常情况下睡觉之前要脱衣服！");
	}
	
	public void afterSleep(){
		 System.out.println("起床后要先穿衣服！");
	}

}
