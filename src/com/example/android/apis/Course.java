package com.example.android.apis;

import java.util.ArrayList;

import android.app.Activity;

public class Course extends Activity{
	private String courseName;
	private double credits;
	private double gpa;
	private int numWeights, numCourses;
	
	private ArrayList<Double> weights = new ArrayList<Double>();
	private ArrayList<String> types = new ArrayList<String>();
	
	private ArrayList<Assignment> grades = new ArrayList<Assignment>();
	
	public Course(String courseName,double credits){
		this.courseName = courseName;
		this.credits = credits;
	}
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

		public String getName(){
		return courseName;
	}
	
	public void addGrade(Assignment assignment){
		grades.add(assignment);
	}
	
	public Assignment getGrade(int index){
		return grades.get(index);
	}
	
	public void addAWeight(double weight){
		weights.add(weight);
	}
	
	public void addAType(String type){
		types.add(type);
	}
	
		
	public double getWeightPercentage(int index){
		return this.weights.get(index);
	}
	
	public String getTypeName(int index){
		return this.types.get(index);
	}
	
	public double calculateGrade(){
		double temp = 0;
			for(int j = 0; j < grades.size(); j++){
				temp += (grades.get(j).getScore() * grades.get(j).getWeight());
			}
			gpa += temp;
		
		return gpa;
	}
	// follows a standard letter grading scale
	public char getLetterGrade(){
		return 'a';
	}

	public void setNumWeights(int numWeights) {
		this.numWeights = numWeights;
	}

	public int getNumWeights() {
		return numWeights;
	}

	public void setNumCourses(int numCourses) {
		this.numCourses = numCourses;
	}

	public int getNumCourses() {
		return numCourses;
	}
	
		

}
