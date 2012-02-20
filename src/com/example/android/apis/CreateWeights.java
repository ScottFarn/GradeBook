package com.example.android.apis;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

public class CreateWeights extends Activity {

	private Button addButton, cancelButton, acceptButton;
	private Intent i = new Intent();
	private int weights = 0, total;
	private AlertDialog dlgAlert;
	private EditText type, weight;
	private ArrayList<EditText> weightList= new ArrayList<EditText>();
	private ArrayList<EditText> typeList= new ArrayList<EditText>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		getWindow().setFormat(PixelFormat.RGBA_8888);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
		super.onCreate(savedInstanceState);
		// course.setNumWeights(0);
		String types = "";
		setContentView(R.layout.create_weights);
		addButton = (Button) this.findViewById(R.id.add);
		cancelButton = (Button) this.findViewById(R.id.cancel);
		acceptButton = (Button) this.findViewById(R.id.accept);

		final AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
		dlgAlert.setMessage("This is an alert with no consequence");
		dlgAlert.setTitle("App Title");
		dlgAlert.setPositiveButton("OK", null);
		dlgAlert.setCancelable(true);
		dlgAlert.create();

		this.addButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				TableLayout tl = (TableLayout) findViewById(R.id.table_layout);

				weights++;
				/* Create a new row to be added. */
				TableRow tr = new TableRow(getApplicationContext());
				tr.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
						LayoutParams.WRAP_CONTENT));
				/* Create 2 edit text to be the row context */
				// course.setNumWeights(course.getNumWeights()+1);
				type = new EditText(CreateWeights.this);
				weight = new EditText(CreateWeights.this);
				weightList.add(weight);
				typeList.add(type);
				type.setHint("Type");
				type.setMaxLines(1);
				type.setWidth(150);
				type.setMaxWidth(150);

				weight.setHint("Weight");
				weight.setMaxLines(1);
				weight.setWidth(95);
				weight.setMaxWidth(95);
				weight.setInputType(InputType.TYPE_CLASS_NUMBER);

				/* Add Button to row. */
				tr.addView(type);
				tr.addView(weight);

				/* Add row to TableLayout. */
				tl.addView(tr, new TableLayout.LayoutParams(
						LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			}
		});

		this.cancelButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// if (course.getNumCourses() > 0) {
				// courses.remove(courses.size()-1);
				// course.setNumCourses(course.getNumCourses()-1);
				// }

				i.setClassName("com.example.android.apis",
						"com.example.android.apis.ApiDemos");
				startActivity(i);
			}
		});

		this.acceptButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				total = 0;
				boolean alertfound = false;
				for (int j = 0; j < weightList.size(); j++) {

					// if neither of the entries are blank, then calculate the
					// weights
					if (!weightList.get(j).getText().toString().trim().equals("")
							&& !typeList.get(j).getText().toString().trim().equals("")) {

						//String tipe = type.getText().toString();
						double wait = Double.parseDouble(weightList.get(j).getText()
								.toString());
						total += wait;
						// courses.get(courses.size()).addAWeight(wait);
						// courses.get(courses.size()).addAType(tipe);
						hideKeyBoard();
						// blank type
					}
				}
				
				
				for(int j = 0; j < weightList.size(); j++){
					
						if (typeList.get(j).getText().toString().trim().equals("")
								&& !weightList.get(j).getText().toString().trim()
										.equals("")) {
							dlgAlert.setMessage("You have a blank type");
							alertfound = true;
							// blank weight
						} else if (!typeList.get(j).getText().toString().trim().equals("")
								&& weightList.get(j).getText().toString().trim()
										.equals("")) {
							dlgAlert.setMessage("You have a blank weight");
							alertfound = true;
						} else if(total != 100 && alertfound == false){
							dlgAlert.setMessage("Total weight does not add up to 100%");
							
						} 
					
				}
				if (total == 100) {
					// hideKeyBoard();
					i.setClassName("com.example.android.apis",
							"com.example.android.apis.ClassAdded");
					startActivity(i);
			}else
				dlgAlert.show();
				
			}
		});

	}

	public void hideKeyBoard() {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
	}
}
