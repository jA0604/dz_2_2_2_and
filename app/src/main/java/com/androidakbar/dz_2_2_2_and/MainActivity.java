package com.androidakbar.dz_2_2_2_and;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private Toolbar appToolbar;
    private Intent intentNote;
    private Intent intentPay;
    private Intent intentDelivery;
    private Intent intentTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        appToolbar = findViewById(R.id.app_toolbar);
        appToolbar.setTitle(R.string.name_dz);
        appToolbar.inflateMenu(R.menu.menu_main);
        setSupportActionBar(appToolbar);

        intentNote = new Intent(MainActivity.this, NoteActivity.class);
        intentPay = new Intent(MainActivity.this, PayActivity.class);
        intentDelivery = new Intent(MainActivity.this, DeliveryActivity.class);
        intentTask = new Intent(MainActivity.this, TaskActivity.class);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mm_settings: {
                return true;
            }
            case R.id.mm_note: {
                startActivity(intentNote);
                return true;
            }
            case R.id.mm_pay: {
                startActivity(intentPay);
                return true;
            }
            case R.id.mm_delivery: {
                startActivity(intentDelivery);
                return true;
            }
            case R.id.mm_task: {
                startActivity(intentTask);
                return true;
            }

        }

        return false;
    }


}