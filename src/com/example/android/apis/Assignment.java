package com.example.android.apis;

import java.text.DecimalFormat;

import android.app.Activity;

public class Assignment extends Activity{

	private double pAvailable;
	private double pEarned;
	private double score;
	private double weight;
	private String type;
	private String name;

	public Assignment() {

	}

	public Assignment(double pAvailable, double pEarned, String type,
			String name) {
		this.pAvailable = pAvailable;
		this.pEarned = pEarned;
		this.type = type;
		this.name = name;
	}

	public double getpAvailable() {
		return pAvailable;
	}

	public void setpAvailable(double pAvailable) {
		this.pAvailable = pAvailable;
	}

	public double getpEarned() {
		return pEarned;
	}

	public void setpEarned(double pEarned) {
		this.pEarned = pEarned;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		double d = (pEarned / pAvailable) * 100;
		return Double.valueOf(twoDForm.format(d));
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
