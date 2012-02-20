package com.example.android.apis;

import java.util.ArrayList;


import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class ApiDemos extends Activity {
	/** Called when the activity is first created. */
	GlobalClass gs = (GlobalClass) getApplication();
	private ArrayList<GlobalClass> courseArray = new ArrayList<GlobalClass>();
	private ArrayList<Course> courses = new ArrayList<Course>();
	private Button createClassButton;
	
	@Override
	
	public void onCreate(Bundle savedInstanceState) {
		getWindow().setFormat(PixelFormat.RGBA_8888);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//showAllClasses();
		createClassButton = (Button) findViewById(R.id.create_class);
		
		createClassButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClassName("com.example.android.apis",
						"com.example.android.apis.AddClass");
				startActivity(i);
			}
		});
	
		
	}
	public void showAllClasses() {
		for (int i = 0; i < courses.size(); i++) {
			String name = courses.get(i).getName();
			double grade = courses.get(i).calculateGrade();
			LinearLayout ll = (LinearLayout) findViewById(R.id.rlayout);
			ll.setOrientation(LinearLayout.VERTICAL);
			Button bt = new Button(this);
			bt.setId(i);
			bt.setText(name + " Grade: " + grade);
			ll.addView(bt);
			bt.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// accessClass(bt); goto the class screen
				}
			});

		}
	}
}