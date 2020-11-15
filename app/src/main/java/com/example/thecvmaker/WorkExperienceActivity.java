package com.example.thecvmaker;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thecvmaker.adapter.WorkExperienceRvAdapter;
import com.example.thecvmaker.models.WorkExpItem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WorkExperienceActivity extends AppCompatActivity {

    private final List<WorkExpItem> ExperienceList = new ArrayList<>();
    private final UserCv userCv = new UserCv();
    private EditText StartDateWorkExp;
    private EditText EndDateWorkExp;
    private EditText CompNameWorkExp;
    private EditText PositionWorkExp;
    private EditText DescriptionWorkExp;
    private CheckBox current_working;
    private TextView AnotherExp;
    private WorkExpItem expItem;
    private DatePickerDialog.OnDateSetListener mDateSetListener1;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;
    RecyclerView recyclerView;
    WorkExperienceRvAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_experience);
        initViews();

        StartDateWorkExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(WorkExperienceActivity.this,
                        mDateSetListener1, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();
            }
        });
        mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                StartDateWorkExp.setText(date);
            }
        };


        EndDateWorkExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(WorkExperienceActivity.this,
                        mDateSetListener2, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();
            }
        });
        mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                EndDateWorkExp.setText(date);
            }
        };
        AnotherExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkExperienceArrayAdapterDetails();
                ResetWorkExpDetails();
            }
        });
        recyclerView = findViewById(R.id.experience_rv_container);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewAdapter = new WorkExperienceRvAdapter(WorkExperienceActivity.this, ExperienceList);
        recyclerView.setAdapter(recyclerViewAdapter);


    }

    private void initViews() {

        StartDateWorkExp = findViewById(R.id.exp_start_date_edt);
        EndDateWorkExp = findViewById(R.id.exp_end_date_edt);
        CompNameWorkExp = findViewById(R.id.company_name_edt);
        PositionWorkExp = findViewById(R.id.position_edt);
        DescriptionWorkExp = findViewById(R.id.job_description_edt);
        current_working = findViewById(R.id.exp_current_checkbox_btn);
        AnotherExp = findViewById(R.id.add_experience_btn);
    }

    private void setWorkExperienceArrayAdapterDetails() {
        expItem = new WorkExpItem();
        expItem.setStart_date(StartDateWorkExp.getText().toString());
        if (current_working.isChecked()) {
            expItem.setEnd_date(current_working.getText().toString());

        } else {
            expItem.setEnd_date(EndDateWorkExp.getText().toString());
        }

        expItem.setCompany(CompNameWorkExp.getText().toString());
        expItem.setPosition(PositionWorkExp.getText().toString());
        expItem.setDescription(DescriptionWorkExp.getText().toString());
        ExperienceList.add(expItem);
    }

    public void ResetWorkExpDetails() {
        StartDateWorkExp.setText("");
        EndDateWorkExp.setText("");
        CompNameWorkExp.setText("");
        PositionWorkExp.setText("");
        DescriptionWorkExp.setText("");

    }
  /*  public void setUserCVWorkExpDetails() {
        userCV.setName(Name);
        userCV.setAddress(Address);
        userCV.setDob(Dob);
        userCV.setEmailAddress(EmailAddress);
        userCV.setGender(Gender);
        userCV.setLanguage(Language);
        userCV.setNationality(Nationality);
        userCV.setPhoneNumber(PhoneNumber);
    }*/


}