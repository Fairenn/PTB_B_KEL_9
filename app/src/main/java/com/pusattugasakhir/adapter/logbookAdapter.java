package com.pusattugasakhir.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pusattugasakhir.R;
import com.pusattugasakhir.models.logbook;

import java.util.ArrayList;

public class logbookAdapter extends RecyclerView.Adapter<logbookAdapter.logbookViewHolder> {

    ArrayList<logbook> listLogbook = new ArrayList<>();

    public logbookAdapter(ArrayList<logbook> listLogbook) {
        this.listLogbook = listLogbook;
    }

    public void setListLogbook(ArrayList<logbook> listLogbook) {
        this.listLogbook = listLogbook;
    }

    @NonNull
    @Override
    public logbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_logbook2, parent, false);
    return new logbookViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull logbookViewHolder holder, int position) {
        logbook logbook = listLogbook.get(position);
        holder.date.setText(logbook.getDate());
        holder.logbook.setText(logbook.getProgress());
    }

    @Override
    public int getItemCount() {
        return listLogbook.size();
    }


    public class logbookViewHolder extends RecyclerView.ViewHolder {

        public TextView date, logbook;

        public logbookViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            logbook = itemView.findViewById(R.id.progress);
        }
    }
}


