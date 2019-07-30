package com.scar.luasvolumebalok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    int req_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnvolume = findViewById(R.id.btnvolume);
        btnvolume.setOnClickListener(this);

        Button btnvolumeA = findViewById(R.id.btnluas);
        btnvolumeA.setOnClickListener(this);

    }

    @Override
    public void  onClick(View v) {
        switch (v.getId()) {
            case R.id.btnvolume:
                Intent moveIntent = new Intent(MainActivity.this, Volume.class);
                startActivity(moveIntent);
            break;
            case R.id.btnluas:
                //Intent moveIntentA = new Intent(MainActivity.this, Luas.class);
                //startActivity(moveIntentA);
                Intent data = new Intent(MainActivity.this, Luas.class);
                startActivityForResult(data, req_code);
            break;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == req_code){
            if (resultCode == RESULT_OK){
                TextView hasilnama = findViewById(R.id.viewluas);
                hasilnama.setText(data.getData().toString());
            }
        }
    }
}
