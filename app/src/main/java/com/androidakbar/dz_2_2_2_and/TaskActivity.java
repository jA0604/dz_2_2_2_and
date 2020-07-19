package com.androidakbar.dz_2_2_2_and;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class TaskActivity extends AppCompatActivity {
    private Button btnStart;
    private Button btnEnd;
    private CalendarView cvStart;
    private CalendarView cvEnd;
    private Button btnOk;

    private long startMils;
    private String txtStart;
    private long endMils;
    private String txtEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        initViews();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cvStart.setVisibility(View.VISIBLE);
                cvEnd.setVisibility(View.GONE);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cvStart.setVisibility(View.GONE);
                cvEnd.setVisibility(View.VISIBLE);
            }
        });

        cvStart.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                txtStart = i2+"-"+i1+"-"+i;
                btnStart.setText("Дата-время старта задачи: " + txtStart);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                startMils = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);

            }
        });

        cvEnd.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                txtEnd = i2+"-"+i1+"-"+i;
                btnEnd.setText("Дата-время окончания задачи: " + txtEnd);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                endMils = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);

            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (startMils > endMils){
                    Toast.makeText(TaskActivity.this, "Ошибка в датах", Toast.LENGTH_LONG).show();
                    btnStart.setText("Дата-время старта задачи:");
                    btnEnd.setText("Дата-время окончания задачи:");
                } else {
                    Toast.makeText(TaskActivity.this, "старт: " + txtStart + " окончаниe: " + txtEnd, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initViews() {
        btnStart = findViewById(R.id.btn_start);
        btnEnd = findViewById(R.id.btn_end);
        cvStart = findViewById(R.id.cv_start);
        cvEnd = findViewById(R.id.cv_end);
        btnOk = findViewById(R.id.btn_OK_tsk);

        // Скроем календари при запуске приложения
        cvStart.setVisibility(View.GONE);
        cvEnd.setVisibility(View.GONE);
    }
}