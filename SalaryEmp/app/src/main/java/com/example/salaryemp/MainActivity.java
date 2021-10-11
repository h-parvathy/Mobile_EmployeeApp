// Assignment 1 - Mobile Development
// Parvathy Harikumar - c0784311
// Salman Kalubhai Charania - c0780043
// Diyamol Varghese – c0787971

package com.example.salaryemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton masters, bachelors, diploma, highSchool;
    EditText years;
    TextView salary;
    CheckBox java, c, php, python, swift, yes;
    Button calculate;
    double sal, yearlyBonus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        masters = findViewById(R.id.rdbMasters);
        bachelors = findViewById(R.id.rdbBachelors);
        diploma = findViewById(R.id.rdbDiploma);
        highSchool = findViewById(R.id.rdbhs);
        years = findViewById(R.id.txtYears);
        salary = findViewById(R.id.txtSalary);
        java = findViewById(R.id.chkJava);
        c = findViewById(R.id.chkC);
        php = findViewById(R.id.chkPhp);
        python = findViewById(R.id.chkPython);
        swift = findViewById(R.id.chkSwift);
        yes = findViewById(R.id.chkYes);
        calculate = findViewById(R.id.btnCalculate);

        // set buttons on for the listener
        masters.setOnClickListener(new ButtonEvents());
        bachelors.setOnClickListener(new ButtonEvents());
        diploma.setOnClickListener(new ButtonEvents());
        highSchool.setOnClickListener(new ButtonEvents());

        //set checkboxes on for Listener
        java.setOnCheckedChangeListener(new ChekBoxEvent());
        c.setOnCheckedChangeListener(new ChekBoxEvent());
        php.setOnCheckedChangeListener(new ChekBoxEvent());
        python.setOnCheckedChangeListener(new ChekBoxEvent());
        swift.setOnCheckedChangeListener(new ChekBoxEvent());

        //If employee has a child add $250 to salary.
        yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (yes.isChecked()) {
                    yes.setText("Yes");
                    sal+=250;
                    Toast.makeText(getBaseContext(), "Employee has Children", Toast.LENGTH_LONG).show();

                }
                else {
                    yes.setText("No");
                    sal-=250;
                    Toast.makeText(getBaseContext(), "Employee doesn't have Children", Toast.LENGTH_LONG).show();

                }
                salary.setText(String.format("%.2f", sal));

            }
        });

        // set on click for - Calculate Button (final)
        calculate.setOnClickListener(new ButtonEvents());

    }

    //Implementing functionality on clicking buttons
    // Qualification - Masters, Diploma, Bachelors, High School
    // Calculate - the final calculate button
    private class ButtonEvents implements View.OnClickListener {
        @Override
        public  void  onClick(View v){
            switch(v.getId()){
                case R.id.rdbMasters:
                    sal = 6500;
                    Toast.makeText(getBaseContext(), "Employee has Masters Degree", Toast.LENGTH_LONG).show();
                    break;
                case R.id.rdbBachelors:
                    sal = 6000;
                    Toast.makeText(getBaseContext(), "Employee has Bachelors Degree", Toast.LENGTH_LONG).show();
                    break;
                case R.id.rdbDiploma:
                    sal = 5400;
                    Toast.makeText(getBaseContext(), "Employee has Diploma", Toast.LENGTH_LONG).show();
                    break;
                case R.id.rdbhs:
                    sal = 4000;
                    Toast.makeText(getBaseContext(), "Employee is a High School Graduate", Toast.LENGTH_LONG).show();
                    break;
                case R.id.btnCalculate:
                    int yrs = Integer.parseInt(years.getText().toString());
                    // Adding Bonus for experience.
                    sal -= yearlyBonus; // refreshing old experience
                    yearlyBonus = 0;
                    if (yrs >= 0) {
                        Toast.makeText(getBaseContext(), "Employee has "+ yrs +" of Experience", Toast.LENGTH_LONG).show();
                        if (yrs > 5)
                            yearlyBonus += 500;
                        else
                            yearlyBonus += 75 * yrs;
                    }
                    sal += yearlyBonus;
                    salary.setText(String.format("%.2f", sal));
                    break;
            }

            salary.setText(String.format("%.2f", sal));

        }
    }




    //class to implement the checkboxes
    private class ChekBoxEvent implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView.getId() == R.id.chkJava) {
                if (java.isChecked()) {
                    sal+=200;
                    Toast.makeText(getBaseContext(), "Employee knows JAVA language", Toast.LENGTH_LONG).show();
                } else {
                    sal-=200;
                    Toast.makeText(getBaseContext(), "Employee doesn't know JAVA language", Toast.LENGTH_LONG).show();
                }
            }
            if (buttonView.getId() == R.id.chkC) {
                if (c.isChecked()) {
                    sal+=170;
                    Toast.makeText(getBaseContext(), "Employee knows C# language", Toast.LENGTH_LONG).show();
                } else {
                    sal-=170;
                    Toast.makeText(getBaseContext(), "Employee doesn't know C# language", Toast.LENGTH_LONG).show();
                }
            }
            if (buttonView.getId() == R.id.chkPhp) {
                if (php.isChecked()) {
                    sal+=100;
                    Toast.makeText(getBaseContext(), "Employee knows Php language", Toast.LENGTH_LONG).show();
                } else {
                    sal-=100;
                    Toast.makeText(getBaseContext(), "Employee doesn't know Php language", Toast.LENGTH_LONG).show();
                }
            }
            if (buttonView.getId() == R.id.chkPython) {
                if (python.isChecked()) {
                    sal+=230;
                    Toast.makeText(getBaseContext(), "Employee knows Python language", Toast.LENGTH_LONG).show();
                } else {
                    sal-=230;
                    Toast.makeText(getBaseContext(), "Employee doesn't know Python language", Toast.LENGTH_LONG).show();
                }
            }
            if (buttonView.getId() == R.id.chkSwift) {
                if (swift.isChecked()) {
                    sal+=200;
                    Toast.makeText(getBaseContext(), "Employee knows Swift language", Toast.LENGTH_LONG).show();
                } else {
                    sal-=200;
                    Toast.makeText(getBaseContext(), "Employee doesn't know Swift language", Toast.LENGTH_LONG).show();
                }
            }
            salary.setText(String.format("%.2f", sal));
        }
    }

}
