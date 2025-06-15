package com.example.latihan_praktikum_7.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.latihan_praktikum_7.R;
import com.example.latihan_praktikum_7.entity.Doa;
import java.util.ArrayList;
import java.util.List;

public class KontenAdapter extends RecyclerView.Adapter<KontenAdapter.KontenViewHolder> {

    private List<Doa> listDoa = new ArrayList<>();

    public void setListDoa(List<Doa> listDoa) {
        this.listDoa = listDoa;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KontenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_konten, parent, false);
        return new KontenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KontenViewHolder holder, int position) {
        Doa doa = listDoa.get(position);
        holder.tvJudul.setText(doa.doa);
        holder.tvIsi.setText(doa.artinya);
    }

    @Override
    public int getItemCount() {
        return listDoa.size();
    }

    static class KontenViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul, tvIsi;

        public KontenViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tvJudul);
            tvIsi = itemView.findViewById(R.id.tvIsi);
        }
    }
}
