package com.example.latihan_praktikum_7.ui.konten;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latihan_praktikum_7.R;
import com.example.latihan_praktikum_7.adapter.KontenAdapter;
import com.example.latihan_praktikum_7.viewModel.DoaViewModel;
import com.example.latihan_praktikum_7.entity.Doa;

import java.util.List;
public class KontenFragment extends Fragment {
    private DoaViewModel doaViewModel;
    private KontenAdapter kontenAdapter;
    private RecyclerView recyclerViewKonten;
    private SearchView searchView;
    public KontenFragment() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_konten, container, false);
        recyclerViewKonten = view.findViewById(R.id.recyclerViewKonten);
        searchView = view.findViewById(R.id.searchView);
        recyclerViewKonten.setLayoutManager(new LinearLayoutManager(getContext()));
        kontenAdapter = new KontenAdapter();
        recyclerViewKonten.setAdapter(kontenAdapter);
        doaViewModel = new ViewModelProvider(this).get(DoaViewModel.class);
        doaViewModel.getDoaList().observe(getViewLifecycleOwner(), doaList -> {
            kontenAdapter.setListDoa(doaList);
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchDoa(query);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                searchDoa(newText);
                return true;
            }
        });
        return view;
    }
    private void searchDoa(String keyword) {
        if (TextUtils.isEmpty(keyword)) {
            doaViewModel.getDoaList().observe(getViewLifecycleOwner(), doaList -> {
                kontenAdapter.setListDoa(doaList);
            });
        } else {
            doaViewModel.searchDoa(keyword).observe(getViewLifecycleOwner(), doaList -> {
                kontenAdapter.setListDoa(doaList);
            });
        }}}
