package com.example.android.apis;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class GradesMenu extends Activity {

	private Button backButton, testButton,quizButton,hwsButton,deleteButton, editButton;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFormat(PixelFormat.RGBA_8888);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
		setContentView(R.layout.grades_menu);
		
		 backButton = (Button) findViewById(R.id.back);
		 testButton = (Button) findViewById(R.id.test);
		 quizButton = (Button) findViewById(R.id.quiz);
		 hwsButton = (Button) findViewById(R.id.hws);
		 deleteButton = (Button) findViewById(R.id.delete);
		 editButton = (Button) findViewById(R.id.edit);
		 
		 	final AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
			dlgAlert.setMessage("Are you sure you want to delete CS162?");
			dlgAlert.setTitle("Class Deletion!");
			
			dlgAlert.setNegativeButton("No!", null);
			dlgAlert.setCancelable(true);
			dlgAlert.create();
			
			dlgAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					Intent i = new Intent();
								
					i.setClassName("com.example.android.apis",
							"com.example.android.apis.ApiDemos");
					startActivity(i);
				}
				});
			dlgAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					//do nothing
					
				}
				});
			
		
		 deleteButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					Intent i = new Intent();
					dlgAlert.show();
										
				}
			});
		 editButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					Intent i = new Intent();
					i.setClassName("com.example.android.apis",
							"com.example.android.apis.CreateWeights");
					startActivity(i);
										
				}
			});
		testButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClassName("com.example.android.apis",
						"com.example.android.apis.TestMenu");
				startActivity(i);
			}
		});
		quizButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClassName("com.example.android.apis",
						"com.example.android.apis.TestMenu");
				startActivity(i);
			}
		});
		hwsButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClassName("com.example.android.apis",
						"com.example.android.apis.TestMenu");
				startActivity(i);
			}
		});
		
		backButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClassName("com.example.android.apis",
						"com.example.android.apis.ClassAndGradeAdded");
				startActivity(i);
			}
		});
		

	}
}
