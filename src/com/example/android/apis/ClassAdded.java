package com.example.android.apis;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ClassAdded extends Activity {
	Button cancelButton, enterClass, testButton, hwsButton, quizButton;
	
	
	public void onCreate(Bundle savedInstanceState) {
		getWindow().setFormat(PixelFormat.RGBA_8888);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.with_one_class);
		
		enterClass = (Button) findViewById(R.id.cs162);
			
		enterClass.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClassName("com.example.android.apis",
						"com.example.android.apis.GradesMenu");
				startActivity(i);
			}
		});
		
		

	}
	
}
