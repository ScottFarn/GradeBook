package com.example.android.apis;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class TestMenu extends Activity{
	
	Button backButton, addAssignment;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFormat(PixelFormat.RGBA_8888);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
		setContentView(R.layout.test_main_screen);
		backButton = (Button) this.findViewById(R.id.back);
		addAssignment = (Button) findViewById(R.id.add);
		
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
}
}
