package com.example.aplikasipemesananmakan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    //mendeklarasikan
    Context mContext;
    LayoutInflater inflater;
    //menginisialisasikan
    private ArrayList<com.example.aplikasipemesananmakan.ClassNama> arrayList;
    //membuat fungsi listviewadapter
    public ListViewAdapter(Context context){
        mContext = context;
        inflater = LayoutInflater.from(mContext);

        this.arrayList = new ArrayList<com.example.aplikasipemesananmakan.ClassNama>();
        this.arrayList.addAll(Home.classNamaArrayList);
    }

    //untuk memanggil textview
    public class ViewHolder{
        TextView name;
    }
    //untuk membuat parameter int
    @Override
    public int getCount() {
        return Home.classNamaArrayList.size();
    }
    //untuk membuat parameter object
    @Override
    public Object getItem(int i) {
        return Home.classNamaArrayList.get(i);
    }
    //untuk membuat parameter long
    @Override
    public long getItemId(int i) {
        return i;
    }
    //untuk membuat parameter
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //untuk manampilkan view itemlist dan namaitem
        final ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_list_vew, null);
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(Home.classNamaArrayList.get(i).getNama());
        return view;
    }
    //untuk membuat parameter fungsi
    public Filter getFilter(){
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if(constraint == null||constraint.length()==0){
                    filterResults.count = arrayList.size();
                    filterResults.values = arrayList;
                }
                else {
                    //
                    List<com.example.aplikasipemesananmakan.ClassNama> resultModel = new ArrayList<>();
                    String searchString = constraint.toString().toUpperCase();

                    for(com.example.aplikasipemesananmakan.ClassNama itemModel:arrayList){
                        if (itemModel.getNama().toUpperCase().contains(searchString.toUpperCase())){
                            resultModel.add(itemModel);
                        }
                        filterResults.count = resultModel.size();
                        filterResults.values = resultModel;
                    }
                }
                return filterResults;
            }
            //untuk membuat fungsi values
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                Home.classNamaArrayList = (ArrayList<com.example.aplikasipemesananmakan.ClassNama>) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }
}
