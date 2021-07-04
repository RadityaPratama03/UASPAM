package com.example.aplikasipemesananmakan;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class PesanMakan extends AppCompatActivity {
    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_makan);
    }
    public void increment(View view){//perintah tombol tambah
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 50",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }
    public void decrement(View view){//perintah tombol kurang
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }


    public void Submitorder(View view) {
        EditText nameEditText=(EditText)findViewById(R.id.edt_name);
        String name=nameEditText.getText().toString();
        Log.v("MainActivity","Nama:"+name);

        CheckBox nasigorengChekBox= (CheckBox) findViewById(R.id.nasigoreng_checkbox);
        boolean hasnasigoreng=nasigorengChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has nasigoreng:"+hasnasigoreng);

        CheckBox miegorengChekBox= (CheckBox) findViewById(R.id.miegoreng_checkbox);
        boolean hasmiegoreng=miegorengChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has miegoreng:"+hasmiegoreng);

        CheckBox pecelChekBox= (CheckBox) findViewById(R.id.pecel_checkbox);
        boolean haspecel=pecelChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has pecel:"+haspecel);

        CheckBox estehChekBox= (CheckBox) findViewById(R.id.esteh_checkbox);
        boolean hasesteh=estehChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has esteh:"+hasesteh);

        CheckBox esjerukChekBox= (CheckBox) findViewById(R.id.esjeruk_checkbox);
        boolean hasesjeruk=esjerukChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has esjeruk:"+hasesjeruk);

        CheckBox kopiChekBox= (CheckBox) findViewById(R.id.kopi_checkbox);
        boolean haskopi=kopiChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has kopi:"+haskopi);

        int price=calculateprice(hasnasigoreng,hasmiegoreng,haspecel,hasesteh,hasesjeruk,haskopi);
        String pricemessage=createOrderSummary(price,name,hasnasigoreng, hasmiegoreng, haspecel,hasesteh,hasesjeruk,haskopi);


        displayMessage(pricemessage);

    }
    private int calculateprice(boolean addnasigoreng,boolean addmiegoreng, boolean addpecel, boolean addesteh,
                               boolean addesjeruk, boolean addkopi)
    {
        int harga= 0;

        if(addnasigoreng){
            harga=harga+10000;
        }
        if (addmiegoreng){
            harga=harga+10000;
        }
        if (addpecel){
            harga=harga+10000;
        }
        if (addesteh){
            harga=harga+3000;
        }
        if (addesjeruk){
            harga=harga+3000;
        }
        if (addkopi){
            harga=harga+5000;
        }
        return quantity * harga;
    }
    private String createOrderSummary(int price, String name, boolean addnasigoreng, boolean addmiegoreng,
                                      boolean addpecel,boolean addesteh,boolean addesjeruk,boolean addkopi) {//hasil pemesanan
        String pricemessage=" Nama = "+name;
        pricemessage+="\n Tambahkan Nasi Goreng =" +addnasigoreng;
        pricemessage+="\n Tambahkan Mie Goreng =" +addmiegoreng;
        pricemessage+="\n Tambahkan Pecel =" +addpecel;
        pricemessage+="\n Tambahkan Es Teh =" +addesteh;
        pricemessage+="\n Tambahkan Es Jeruk =" +addesjeruk;
        pricemessage+="\n Tambahkan Kopi =" +addkopi;
        pricemessage+="\n Jumlah Pemesanan =" +quantity;
        pricemessage+="\n Total = Rp " +price;
        pricemessage+="\n Selamat Menikmati :)";
        return  pricemessage;
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}
