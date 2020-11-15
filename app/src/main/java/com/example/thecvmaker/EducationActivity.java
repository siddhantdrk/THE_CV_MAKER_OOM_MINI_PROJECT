package com.example.thecvmaker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.Calendar;

public class EducationActivity extends AppCompatActivity {

    private EditText eduStartDateEdt, eduEndDateEdt, eduSchoolInstituteEdt, eduDescriptionEdt;
    private CheckBox eduCurrentCheckBox;
    private Spinner eduDegreeSpinner;
    private TextView addEducationBtn;
    private MaterialButton nextToWorkExperience;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        initViews();
        Intent intent = getIntent();
        if (intent.getStringExtra("FromActivity").equals("PersonalDetailsActivity")) {
            UserCv obj = intent.getParcelableExtra("Example");
            String name = obj.getName();
            Log.d("CheckParcelable", name);
        }

        eduStartDateEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(EducationActivity.this,
                        mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();

            }
        });

        eduEndDateEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(EducationActivity.this,
                        mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();

            }
        });
    }

    private void initViews() {
        eduStartDateEdt = findViewById(R.id.edu_start_date_edt);
        eduEndDateEdt = findViewById(R.id.edu_end_date_edt);
        eduDegreeSpinner = findViewById(R.id.degree_spinner);
        eduCurrentCheckBox = findViewById(R.id.edu_current_check_box);
        eduSchoolInstituteEdt = findViewById(R.id.school_name_edt);
        eduDescriptionEdt = findViewById(R.id.edu_description_edt);
        addEducationBtn = findViewById(R.id.add_education_btn);
        nextToWorkExperience = findViewById(R.id.next_work_experience);
    }
}