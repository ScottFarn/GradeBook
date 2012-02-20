package com.example.android.apis;

import java.util.ArrayList;

import android.app.Application;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

public class GlobalClass extends Application{

	private ArrayList<Double> weights = new ArrayList<Double>();
	private ArrayList<String> types = new ArrayList<String>();
	private ArrayList<Course> courses = new ArrayList<Course>();
	private ArrayList<Assignment> grades = new ArrayList<Assignment>();
	private Course course = new Course();
	
	private String working = "WOKRING";
	public GlobalClass() {
		Course course = new Course();
	}
	
	public void setCourseArray(ArrayList<Course> courseArray) {
		this.courses = courseArray;
	}

	public ArrayList<Course> getCourseArray() {
		return courses;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Course getCourse() {
		return course;
	}
	
	public void showKeyBoard() {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
	}
	
	public String working(){
		return working;
	}

	
	
		

}
