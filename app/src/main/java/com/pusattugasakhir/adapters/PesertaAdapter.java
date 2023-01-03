package com.pusattugasakhir.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pusattugasakhir.R;
import com.pusattugasakhir.models.Peserta;

import java.util.ArrayList;

public class PesertaAdapter extends RecyclerView.Adapter<PesertaAdapter.PesertaViewHolder>{

    ArrayList<Peserta> listPeserta = new ArrayList<>();

    public PesertaAdapter(ArrayList<Peserta> listPeserta) {
        this.listPeserta = listPeserta;
    }

    public void setListPeserta(ArrayList<Peserta> listPeserta) {
        this.listPeserta = listPeserta;
    }

    @NonNull
    @Override
    public PesertaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_peserta_semhas, parent, false);
    return new PesertaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PesertaViewHolder holder, int position) {
        Peserta peserta= listPeserta.get(position);
        holder.imagePeserta.setImageResource(R.drawable.profil);
        holder.textNamaPeserta.setText(peserta.getNamaPeserta());
        holder.textNimPeserta.setText(peserta.getNimPeserta());

    }

    @Override
    public int getItemCount() {
        return listPeserta.size();
    }

    public class PesertaViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageStatus,imagePeserta;
        public TextView textNamaPeserta, textNimPeserta;

        public PesertaViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imagePeserta = itemView.findViewById(R.id.imagePeserta);
            imageStatus = itemView.findViewById(R.id.imageStatus);
            textNamaPeserta = itemView.findViewById(R.id.textNamaPeserta);
            textNimPeserta = itemView.findViewById(R.id.textNimPeserta);

        }
    }
}
