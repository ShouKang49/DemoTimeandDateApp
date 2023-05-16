package sg.edu.rp.c346.id22013080.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnreset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textView);
        btnreset = findViewById(R.id.buttonreset);


        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentHour = tp.getCurrentHour();
                int currentMinute = tp.getCurrentMinute();
                String displayTime = "";

                if(currentHour <= 9){
                    if(currentMinute <= 9){
                        displayTime = String.format("Time is 0%d:0%d",currentHour,currentMinute);
                    }
                    else{
                        displayTime = String.format("Time is 0%d:%d",currentHour,currentMinute);
                    }
                }
                else{
                    if(currentMinute <= 9){
                        displayTime = String.format("Time is %d:0%d",currentHour,currentMinute);
                    }
                    else{
                        displayTime = String.format("Time is %d:%d",currentHour,currentMinute);
                    }
                }


                tvDisplay.setText(displayTime);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentYear = dp.getYear();
                int currentMonth = dp.getMonth();
                currentMonth ++;
                int currentDay = dp.getDayOfMonth();
                String displayDate = String.format("Date is %d/%d/%d", currentDay, currentMonth, currentYear);
                tvDisplay.setText(displayDate);
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            tp.setCurrentHour(0);
            tp.setCurrentMinute(0);
            dp.updateDate(2020,0,1);
            }
        });
    }
}