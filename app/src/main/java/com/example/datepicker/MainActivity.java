package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    TimePicker timePicker;
    Button displayDate,displayTime;
    TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker=findViewById(R.id.datePicker);
        displayDate=findViewById(R.id.button1);
        textView1=findViewById(R.id.textView1);
        timePicker=findViewById(R.id.timePicker);
        displayTime=findViewById(R.id.button2);
        textView2=findViewById(R.id.textView2);

        textView2.setText("CurrentTime:"+getCurrentTime());
        displayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText("ChangeTime:"+getCurrentTime());

            }
        });


        textView1.setText("Current Date: "+getCurrentDate());

        displayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText("changeDate:"+getCurrentDate());
            }
        });

    }

    private String getCurrentTime() {
        String currentTime="Current Time: "+timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();
        return currentTime;
    }

    private String getCurrentDate() {
        StringBuilder builder = new StringBuilder();
        builder.append((datePicker.getMonth() + 1)+"/");//month is 0 based
        builder.append(datePicker.getDayOfMonth()+"/");
        builder.append(datePicker.getYear());
        return builder.toString();
    }
}