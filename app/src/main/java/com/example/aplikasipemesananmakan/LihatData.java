package com.example.aplikasipemesananmakan;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LihatData extends AppCompatActivity {
    TextView tvnama, tvprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);
        Bundle bundle = getIntent().getExtras();
        String nama = bundle.getString("a");

        tvnama = findViewById(R.id.tvNamaKontak);
        tvprice = findViewById(R.id.tvNomorTelepon);
        switch (nama){
            case "Nasi Goreng":
                tvnama.setText("Nasi Goreng");
                tvprice.setText("Rp. 10.000");
                break;
            case "Mie Goreng":
                tvnama.setText("Mie Goreng");
                tvprice.setText("Rp. 10.000");
                break;
            case "Pecel":
                tvnama.setText("Pecel");
                tvprice.setText("Rp. 10.000");
                break;
            case "Es Teh":
                tvnama.setText("Es Teh");
                tvprice.setText("Rp. 3.000");
                break;
            case "Es Jeruk":
                tvnama.setText("Es Jeruk");
                tvprice.setText("Rp. 3.000");
                break;
            case "Kopi":
                tvnama.setText("Kopi");
                tvprice.setText("Rp. 5.000");
                break;
        }
    }
}