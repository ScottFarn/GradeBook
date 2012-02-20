package com.example.android.apis;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class AddClass extends Activity {
	private Button cancelButton, acceptButton;

	GlobalClass gs = (GlobalClass) getApplication();

	//Course course = gs.getCourse();
	//ArrayList<Course> courses = gs.getCourseArray();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.class_setup);

		// hideKeyBoard();
		cancelButton = (Button) findViewById(R.id.cancel);
		acceptButton = (Button) findViewById(R.id.accept);
		final AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
		dlgAlert.setMessage("Input.. Need Input!");
		dlgAlert.setTitle("Missing Input!");
		dlgAlert.setPositiveButton("OK", null);
		dlgAlert.setCancelable(true);
		dlgAlert.create();
		
		this.acceptButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				EditText name = (EditText) findViewById(R.id.course_name);
				EditText hours = (EditText) findViewById(R.id.credit_hours);
				System.out.println(hours + " " + name);

				// conditional needed!!!
				if (!name.getText().toString().trim().equals("")
						&& !hours.getText().toString().trim().equals("")) {
					String nm = name.getText().toString();
					double hrs = Double.parseDouble(hours.getText().toString());
			//		course = new Course(nm, hrs);
			//		courses.add(course);
			//		course.setNumCourses(course.getNumCourses() + 1);
					hideKeyBoard();
					// mainScreen();

					Intent i = new Intent();
					i.setClassName("com.example.android.apis",
							"com.example.android.apis.CreateWeights");
					startActivity(i);
				}else if(name.getText().toString().trim().equals("")
						&& !hours.getText().toString().trim().equals("")){
					dlgAlert.setMessage("You havent entered a class name");
					dlgAlert.show();
				}else if(!name.getText().toString().trim().equals("")
						&& hours.getText().toString().trim().equals("")){
					dlgAlert.setMessage("You havent entered the credit hours");
					dlgAlert.show();
				}else{
					dlgAlert.show();
				}

			}
		});
		this.cancelButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
		//		if (course.getNumCourses() > 0) {
		//			courses.remove(courses.size() - 1);
		//			course.setNumCourses(course.getNumCourses() - 1);
		//		}
				Intent i = new Intent();
				i.setClassName("com.example.android.apis",
						"com.example.android.apis.ApiDemos");
				startActivity(i);
			}
		});

	}

	public void hideKeyBoard() {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
	}

}
