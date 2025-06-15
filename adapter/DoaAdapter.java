package com.example.latihan_praktikum_7.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.latihan_praktikum_7.R;  // pastikan menggunakan package yang benar
import com.example.latihan_praktikum_7.entity.Doa;  // pastikan ini benar

import java.util.List;

public class DoaAdapter extends RecyclerView.Adapter<DoaAdapter.DoaViewHolder> {
    private List<Doa> doaList;  // Gunakan Doa yang dari entity package

    public DoaAdapter(List<Doa> doaList) {
        this.doaList = doaList;
    }

    @NonNull
    @Override
    public DoaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doa, parent, false);
        return new DoaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoaViewHolder holder, int position) {
        Doa doa = doaList.get(position);
        holder.tvDoa.setText(doa.doa);
        holder.tvAyat.setText(doa.ayat);
        holder.tvLatin.setText(doa.latin);
        holder.tvArtinya.setText(doa.artinya);
    }

    @Override
    public int getItemCount() {
        return doaList.size();
    }

    static class DoaViewHolder extends RecyclerView.ViewHolder {
        TextView tvDoa, tvAyat, tvLatin, tvArtinya;

        DoaViewHolder(View itemView) {
            super(itemView);
            tvDoa = itemView.findViewById(R.id.tvDoa);
            tvAyat = itemView.findViewById(R.id.tvAyat);
            tvLatin = itemView.findViewById(R.id.tvLatin);
            tvArtinya = itemView.findViewById(R.id.tvArtinya);
        }
    }
}
