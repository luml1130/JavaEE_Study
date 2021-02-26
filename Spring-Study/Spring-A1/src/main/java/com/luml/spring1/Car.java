package com.luml.spring1;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Car {
	private String name;
	private Double price;
	
	private List<String> list;
	private String[] strs;
	private Set<String> sets;
	private Map<String, String> map;
	private Properties pros;
	
	public Car() {}
	
	/**
	 * 通过构造方法注入属性
	 * @param name
	 * @param price
	 */
	public Car(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public List<String> getList() {
		return list;
	}

	public void setStrs(String[] strs) {
		this.strs = strs;
	}

	public String[] getStrs() {
		return strs;
	}

	public void setSets(Set<String> sets) {
		this.sets = sets;
	}

	public Set<String> getSets() {
		return sets;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setPros(Properties pros) {
		this.pros = pros;
	}

	public Properties getPros() {
		return pros;
	}
}
