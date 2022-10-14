package com.pusattugasakhir.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pusattugasakhir.R;
import com.pusattugasakhir.models.catatan;

import java.util.ArrayList;

public class catatanAdapter extends RecyclerView.Adapter<catatanAdapter.catatanViewHolder>{

    ArrayList<catatan> listcatatan = new ArrayList<>();

    public void setListcatatan(ArrayList<catatan> listcatatan) {
        this.listcatatan = listcatatan;
    }

    public class catatanViewHolder extends RecyclerView.ViewHolder {

        public TextView catatan1, date1;

        public catatanViewHolder(@NonNull View itemView) {
            super(itemView);
            catatan1 = itemView.findViewById(R.id.catatan1);
            date1 = itemView.findViewById(R.id.date1);
        }
    }

    @NonNull
    @Override
    public catatanAdapter.catatanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_logbook2, parent, false);
        return new catatanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull catatanAdapter.catatanViewHolder holder, int position) {
        catatan catatan = listcatatan.get(position);

        holder.catatan1.setText(catatan.getCatatan());
        holder.date1.setText(catatan.getTanggal());
    }

    @Override
    public int getItemCount() {
        return listcatatan.size();
    }
}
