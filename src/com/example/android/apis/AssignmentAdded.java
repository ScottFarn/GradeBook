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

public class AssignmentAdded extends Activity{

	Button backButton, updateAssignment, deleteButton;
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			getWindow().setFormat(PixelFormat.RGBA_8888);
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
			setContentView(R.layout.assignment_added);
			
			backButton = (Button) this.findViewById(R.id.cancel);
			updateAssignment = (Button) findViewById(R.id.add_grade);
			deleteButton= (Button) findViewById(R.id.delete);
			final AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
			dlgAlert.setMessage("Are you sure you want to delete Test1?");
			dlgAlert.setTitle("Delete?!");
			dlgAlert.setPositiveButton("OK", null);
			dlgAlert.setCancelable(true);
			dlgAlert.create();
			
			dlgAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					Intent i = new Intent();
								
					i.setClassName("com.example.android.apis",
							"com.example.android.apis.TestMenu");
					startActivity(i);
				}
				});
			dlgAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					//do nothing
					
				}
				});
			
			backButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					Intent i = new Intent();
					i.setClassName("com.example.android.apis",
							"com.example.android.apis.TestMenuOneTestAdded");
					startActivity(i);
				}
			});
			updateAssignment.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					Intent i = new Intent();
					i.setClassName("com.example.android.apis",
							"com.example.android.apis.TestMenuOneTestAdded");
					startActivity(i);
				}
			});
			deleteButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					
					dlgAlert.show();
					
				}
			});
	}
	

}
