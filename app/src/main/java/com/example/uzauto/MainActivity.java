package com.example.uzauto;

import static android.content.ContentValues.TAG;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.uzauto.useingretrofit.JSONPlaceHolderApi;
import com.example.uzauto.useingretrofit.ModelJson;
import com.example.uzauto.useingretrofit.RetroClient;


import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    AppCompatButton kirish_btn;
    EditText tabel_edt, tell_edt;
    String tabel_str, tell_str;
    ProgressBar progressBar1, progressBar2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kirish_btn = findViewById(R.id.kirish_button);
        tabel_edt = findViewById(R.id.tabel_raqam_edt);
        tell_edt = findViewById(R.id.telefon_rqam_edt);
        progressBar1 = findViewById(R.id.progressBar_aylana);
        progressBar2 = findViewById(R.id.progressBar2);
        EditTextYozuvi editTextYozuvi = new EditTextYozuvi();
        editTextYozuvi.oqGaboyash(tabel_edt);
        editTextYozuvi.oqGaboyash(tell_edt);
        kirish_btn.setOnClickListener(v -> {
            //     progressBar2.setVisibility(View.VISIBLE);
            onClickKirishBTN();

        });
        tell_edt.setOnClickListener(v -> {
            tell_edt.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        });
        tabel_edt.setOnClickListener(v -> {
            tabel_edt.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        });
    }


    private void onClickKirishBTN() {

        progressBar1.setVisibility(View.VISIBLE);
        HodimlarMalumoti();

    }

    int counter = 0;

    public void HodimlarMalumoti() {
        tabel_str = tabel_edt.getText().toString();
        tell_str = tell_edt.getText().toString();

        JSONPlaceHolderApi api = RetroClient.getApiServise();
        Call<List<ModelJson>> call = api.getUzAutHodim();
        Log.d("url", String.valueOf(call.request().url()));
        call.enqueue(new Callback<List<ModelJson>>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<List<ModelJson>> call, Response<List<ModelJson>> response) {
                if (response.isSuccessful()) {
                    Log.d("Malumotlar Keldi ", String.valueOf(response.body().size()));
                    List<ModelJson> modelJsonArrayList = response.body();
                    Log.d("Kelgan malumotlar listi", String.valueOf(response.body().size()));
                    int a = 0;



                    for (int i = 0; i < modelJsonArrayList.size(); i = i + 1) {

                        if (tabel_str.equals(modelJsonArrayList.get(i).gettabel_raqam())) {
                            tabel_edt.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);

                            if (tell_str.equals(modelJsonArrayList.get(i).gettelefon_raqam())) {
                                tell_edt.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
                                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                                startActivity(intent);
                                progressBar1.setVisibility(View.GONE);
                            } else {
                                tell_edt.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                                progressBar1.setVisibility(View.GONE);
                            }
                        }
                    }







                }

            }

            @Override
            public void onFailure(Call<List<ModelJson>> call, Throwable t) {
                Log.d("Malumotlar Keldi ", t.getMessage());

            }

        });


    }
}