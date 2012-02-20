package com.example.android.apis;


import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class AssignmentScreen extends Activity {
	Button  backButton, add_gradeButton;
	public void onCreate(Bundle savedInstanceState) {
		getWindow().setFormat(PixelFormat.RGBA_8888);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_assignment_screen);

		backButton = (Button) findViewById(R.id.cancel);
		
		add_gradeButton = (Button) findViewById(R.id.add_grade);

		
		backButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClassName("com.example.android.apis",
						"com.example.android.apis.TestMenu");
				startActivity(i);
			}
		});
		add_gradeButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClassName("com.example.android.apis",
						"com.example.android.apis.TestMenuOneTestAdded");
				startActivity(i);
			}
		});
	}
}
