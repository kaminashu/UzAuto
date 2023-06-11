package av.uzmd.uzauto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import av.uzmd.uzauto.R;
import av.uzmd.uzauto.useingretrofit.JSONPlaceHolderApi;
import av.uzmd.uzauto.useingretrofit.ModelJson;
import av.uzmd.uzauto.useingretrofit.RetroClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity {
    AppCompatButton qatnashish_btn, trening_vaqtlri_btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        qatnashish_btn = findViewById(R.id.qatnashish_btn);
        trening_vaqtlri_btn = findViewById(R.id.trening_vaqtlari);

        qatnashish_btn.setOnClickListener(v -> {
            LoadUrlBaza();

        });
        trening_vaqtlri_btn.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, TreningVaqtlari_Activity.class);
            startActivity(intent);
        });

    }

    public void LoadUrlBaza() {

        JSONPlaceHolderApi api = RetroClient.getApiServise();
        Call<List<ModelJson>> call = api.getTrening();
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
                    String url = modelJsonArrayList.get(0).geturl();
                    Uri uriUrl = Uri.parse(String.valueOf(url));
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                    Log.d("Kelgan malumotlar listi", modelJsonArrayList.get(0).geturl());
                }

            }

            @Override
            public void onFailure(Call<List<ModelJson>> call, Throwable t) {
                Log.d("Malumotlar Keldi ", t.getMessage());

            }

        });


    }
}