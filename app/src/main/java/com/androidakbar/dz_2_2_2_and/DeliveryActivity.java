package com.androidakbar.dz_2_2_2_and;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class DeliveryActivity extends AppCompatActivity {

    private Spinner spnCountries;
    private Spinner spnCities;
    private Spinner spnHouses;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        initViews();
    }

    private void initViews() {
        spnCountries = findViewById(R.id.spn_countries);
        spnCities = findViewById(R.id.spn_cities);
        spnHouses = findViewById(R.id.spn_houses);
        btnOk = findViewById(R.id.btn_OK_dlv);
        initSpnCountries();
        initSpnHouses();
    }

    private void initSpnHouses() {
        Integer[] houseNumbers = new Integer[50];
        for (int i = 1; i <= 50; i++) {
            houseNumbers[i - 1] = i;
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, houseNumbers);
        spnHouses.setAdapter(adapter);

    }

    private void initSpnCountries() {

        ArrayAdapter<CharSequence> adpCountries = ArrayAdapter.createFromResource(DeliveryActivity.this, R.array.sa_countries, R.layout.support_simple_spinner_dropdown_item);
        spnCountries.setAdapter(adpCountries);

        spnCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] countries = getResources().getStringArray(R.array.sa_countries);
                InitSpnCities(countries[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void InitSpnCities(String country) {
        Log.d("MainAct", getResources().getString(R.string.name_country_r));
        ArrayAdapter<CharSequence> adpCities = null;

        if (country.equals(getResources().getString(R.string.name_country_r))) {
            adpCities = ArrayAdapter.createFromResource(this, R.array.sa_r_cities, android.R.layout.simple_spinner_item);
        } else if (country.equals(getResources().getString(R.string.name_country_u))) {
            adpCities = ArrayAdapter.createFromResource(this, R.array.sa_u_cities, android.R.layout.simple_spinner_item);
        } else {
            adpCities = ArrayAdapter.createFromResource(this, R.array.sa_b_cities, android.R.layout.simple_spinner_item);
        }

        if (adpCities != null) {
            adpCities.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnCities.setAdapter(adpCities);
        }
    }


    public void clickOk(View view) {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //       Log.d("Main", etMoney.getText().toString());
                Toast.makeText(DeliveryActivity.this
                        , spnCountries.getSelectedItem().toString()
                                + " "
                                + spnCities.getSelectedItem().toString()
                                + " "
                                + spnHouses.getSelectedItem().toString()
                        , Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}