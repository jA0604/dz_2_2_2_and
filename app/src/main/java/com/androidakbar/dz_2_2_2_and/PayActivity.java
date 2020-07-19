package com.androidakbar.dz_2_2_2_and;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class PayActivity extends AppCompatActivity {
    private EditText etInput;
    private EditText etMoney;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        final CheckBox chkCard = findViewById(R.id.chk_card);
        final CheckBox chkPhone = findViewById(R.id.chk_phone);
        final CheckBox chkCash = findViewById(R.id.chk_cash);
        etInput = findViewById(R.id.et_input);
        etMoney = findViewById(R.id.et_money);

        chkCard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkCard.isChecked()) {
                    chkPhone.setChecked(false);
                    chkCash.setChecked(false);
                    etInput.setInputType(InputType.TYPE_CLASS_NUMBER);
                    etInput.setText("");
                    text = "с банковской карты ";
                }
            }
        });

        chkPhone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkPhone.isChecked()) {
                    chkCard.setChecked(false);
                    chkCash.setChecked(false);
                    etInput.setInputType(InputType.TYPE_CLASS_PHONE);
                    etInput.setText("");
                    text = "с мобильного телефона ";
                }
            }
        });

        chkCash.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkCash.isChecked()) {
                    chkPhone.setChecked(false);
                    chkCard.setChecked(false);
                    etInput.setInputType(InputType.TYPE_CLASS_TEXT);
                    etInput.setText("");
                    text = "наличными по адресу ";
                }
            }
        });

        Button btnOk = findViewById(R.id.btn_OK_dlv);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Main", etMoney.getText().toString());
                Toast.makeText(PayActivity.this, "Вы ввели сумму:" + etMoney.getText().toString() + " оплата: " + text + etInput.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}