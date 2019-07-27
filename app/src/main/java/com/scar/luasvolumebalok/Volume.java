package com.scar.luasvolumebalok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Volume extends AppCompatActivity implements View.OnClickListener  {
    private EditText eRusuk;
    private Button bHitung;
    private TextView tHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        eRusuk = findViewById(R.id.idrusukv);
        bHitung = findViewById(R.id.bhitungv);
        tHasil = findViewById(R.id.thasilv);

        bHitung.setOnClickListener(this);
        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            tHasil.setText(result);
        }

    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.bhitungv);
        String inputRusuk = eRusuk.getText().toString().trim();

        boolean isEmptyFields = false;
        boolean isInvalidDouble = false;

        if (TextUtils.isEmpty(inputRusuk)) {
            isEmptyFields = true;
            eRusuk.setError("Tidak Boleh Kosong");
        }

        Double rusuk = toDouble(inputRusuk);

        if (rusuk == null){
            isInvalidDouble = true;
            eRusuk.setError("Nomor harus sesuai");
        } if (!isEmptyFields && !isInvalidDouble){
            double volume = rusuk * rusuk * rusuk;
            tHasil.setText(String.valueOf(volume));
        }
    }

    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e){
            return null;
        }
    }
    private static final String STATE_RESULT = "state_result";
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tHasil.getText().toString());
    }
}
