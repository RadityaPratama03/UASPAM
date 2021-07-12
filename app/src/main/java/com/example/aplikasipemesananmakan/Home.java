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
    //menginisialisasi
    private ListView list;
    private com.example.aplikasipemesananmakan.ListViewAdapter adapter;
    //mendeklarasikan EditText
    EditText searchView;
    //mendeklarasikan Floatinbutton pesan
    FloatingActionButton fabPesanMakan = findViewById(R.id.btnpesan);
    //menginisialisasi listnama
    String[] listNama;
    //mendeklarasikan classnama untuk menjadi arraylist
    public  static ArrayList<com.example.aplikasipemesananmakan.ClassNama> classNamaArrayList = new ArrayList<com.example.aplikasipemesananmakan.ClassNama>();
    //membuat parameter bundle
    Bundle bundle = new Bundle();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //menginisialisasikan data makanan
        listNama = new String[]{"Nasi Goreng", "Mie Goreng", "Pecel", "Es Teh",
                "Es Jeruk", "Kopi"};
        //untuk memanggil layout id
        list = findViewById(R.id.listKontak);
        classNamaArrayList = new ArrayList<>();
        //untuk mengembalikan nilai
        for (int i = 0; i < listNama.length; i++){
            com.example.aplikasipemesananmakan.ClassNama classNama = new com.example.aplikasipemesananmakan.ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);
        }
        //untuk mendeklarasikan ListViewAdapter
        adapter = new com.example.aplikasipemesananmakan.ListViewAdapter(this);
        list.setAdapter(adapter);
        //untuk memanggil layout seacrhview
        searchView = findViewById(R.id.searchView);
        searchView.addTextChangedListener(new TextWatcher() {
            //untuk membuat fungsi seacrh
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
        //membuat fungsi pop menu
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //untuk menginisialisasi dan menerima data
                String nama = classNamaArrayList.get(position).getNama();
                //memberi parameter bundle
                bundle.putString("a",nama.trim());
                //untuk memanggil popmenu
                PopupMenu pm = new PopupMenu(getApplicationContext(),view);
                pm.setOnMenuItemClickListener(Home.this);
                pm.inflate(R.menu.popup_menu);
                pm.show();
            }
        });
        //membuat fungsi pesanmakan
        fabPesanMakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //untuk memanggil pesanmakan
                Intent i = new Intent(Home.this,PesanMakan.class);
                startActivity(i);
            }
        });
    }
    //membuat menu
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            //untuk memanggil class lihat data
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), com.example.aplikasipemesananmakan.LihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnnomor:
                //untuk menampilkan data makanan
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