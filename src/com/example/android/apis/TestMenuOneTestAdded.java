package com.example.android.apis;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class TestMenuOneTestAdded extends Activity{
	
	Button backButton, addAssignment, testButton;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFormat(PixelFormat.RGBA_8888);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
		setContentView(R.layout.one_assignment_added);
		backButton = (Button) this.findViewById(R.id.cancel);
		addAssignment = (Button) findViewById(R.id.add_grade);
		testButton = (Button) findViewById(R.id.test1);
		
		backButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClassName("com.example.android.apis",
						"com.example.android.apis.GradesMenu");
				startActivity(i);
			}
		});
		addAssignment.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClassName("com.example.android.apis",
						"com.example.android.apis.AssignmentScreen");
				startActivity(i);
			}
		});
		testButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClassName("com.example.android.apis",
						"com.example.android.apis.AssignmentAdded");
				startActivity(i);
			}
		});
}
}
