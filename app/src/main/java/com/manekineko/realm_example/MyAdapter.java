package com.manekineko.realm_example;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


import io.realm.Realm;
import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private RealmResults<Data> realmResults;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id;
        TextView pwd;
        MyViewHolder(View view){
            super(view);
            id = view.findViewById(R.id.id);
            pwd = view.findViewById(R.id.pwd);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       // Data data = realmResults.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.id.setText("ID: " + realmResults.get(position).getId());
        myViewHolder.pwd.setText("PWD: " + realmResults.get(position).getPwd());
    }
    public void update(RealmResults<Data> RealmResults){
        this.realmResults = RealmResults;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return realmResults.size();
    }
}
