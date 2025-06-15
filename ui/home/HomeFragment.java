package com.example.latihan_praktikum_7.ui.home;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latihan_praktikum_7.R;
import com.example.latihan_praktikum_7.adapter.DoaAdapter;
import com.example.latihan_praktikum_7.viewModel.DoaViewModel;
public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private DoaAdapter doaAdapter;
    private DoaViewModel doaViewModel;
    public HomeFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        doaViewModel = new ViewModelProvider(this).get(DoaViewModel.class);
        doaViewModel.getDoaList().observe(getViewLifecycleOwner(), doaList -> {
            doaAdapter = new DoaAdapter(doaList);
            recyclerView.setAdapter(doaAdapter);
        });
        doaViewModel.fetchDoaFromApi();
        return view;
    }}
