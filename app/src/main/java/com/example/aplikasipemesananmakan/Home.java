package com.example.aplikasipemesananmakan;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    private ListView list;
    private com.example.aplikasipemesananmakan.ListViewAdapter adapter;
    EditText searchView;
    FloatingActionButton fabPesanMakan = findViewById(R.id.btnpesan);

    String[] listNama;

    public  static ArrayList<com.example.aplikasipemesananmakan.ClassNama> classNamaArrayList = new ArrayList<com.example.aplikasipemesananmakan.ClassNama>();

    Bundle bundle = new Bundle();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listNama = new String[]{"Nasi Goreng", "Mie Goreng", "Pecel", "Es Teh",
                "Es Jeruk", "Kopi"};

        list = findViewById(R.id.listKontak);
        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i < listNama.length; i++){
            com.example.aplikasipemesananmakan.ClassNama classNama = new com.example.aplikasipemesananmakan.ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);
        }

        adapter = new com.example.aplikasipemesananmakan.ListViewAdapter(this);

        list.setAdapter(adapter);

        searchView = findViewById(R.id.searchView);
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (Home.this).adapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String nama = classNamaArrayList.get(position).getNama();
                bundle.putString("a",nama.trim());

                PopupMenu pm = new PopupMenu(getApplicationContext(),view);
                pm.setOnMenuItemClickListener(Home.this);
                pm.inflate(R.menu.popup_menu);
                pm.show();
            }
        });
        fabPesanMakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,PesanMakan.class);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), com.example.aplikasipemesananmakan.LihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnnomor:
                switch (bundle.getString("a")){
                    case "Nasi Goreng":
                        Toast.makeText(getApplicationContext(), "Rp 10.000",Toast.LENGTH_LONG).show();
                        break;
                    case "Mie Goreng":
                        Toast.makeText(getApplicationContext(), "Rp 10.000",Toast.LENGTH_LONG).show();
                        break;
                    case "Pecel":
                        Toast.makeText(getApplicationContext(), "Rp 10.000",Toast.LENGTH_LONG).show();
                        break;
                    case "Es Teh":
                        Toast.makeText(getApplicationContext(), "Rp 3.000",Toast.LENGTH_LONG).show();
                        break;
                    case "Es Jeruk ":
                        Toast.makeText(getApplicationContext(), "Rp 3.000",Toast.LENGTH_LONG).show();
                        break;
                    case "Kopi":
                        Toast.makeText(getApplicationContext(), "Rp 5.000",Toast.LENGTH_LONG).show();
                        break;
                }
                break;
        }
        return false;
    }
}