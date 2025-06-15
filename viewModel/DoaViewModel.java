package com.example.latihan_praktikum_7.viewModel;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.latihan_praktikum_7.database.AppDatabase;
import com.example.latihan_praktikum_7.database.DoaDao;
import com.example.latihan_praktikum_7.entity.Doa;
import com.example.latihan_praktikum_7.network.ApiService;
import com.example.latihan_praktikum_7.network.RetrofitClient;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class DoaViewModel extends AndroidViewModel {
    private final DoaDao doaDao;
    private final MutableLiveData<List<Doa>> doaListLiveData = new MutableLiveData<>();
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    public DoaViewModel(@NonNull Application application) {
        super(application);
        AppDatabase db = AppDatabase.getInstance(application);
        doaDao = db.doaDao();
    }
    public LiveData<List<Doa>> getDoaList() {
        return doaListLiveData;
    }
    public LiveData<List<Doa>> searchDoa(String keyword) {
        MutableLiveData<List<Doa>> searchResults = new MutableLiveData<>();
        executorService.execute(() -> {
            List<Doa> results = doaDao.searchDoa(keyword);
            searchResults.postValue(results);
        });
        return searchResults;
    }
    public void fetchDoaFromApi() {
        ApiService apiService = RetrofitClient.getApiService();
        apiService.getDoaList().enqueue(new Callback<List<Doa>>() {
            @Override
            public void onResponse(Call<List<Doa>> call, Response<List<Doa>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    executorService.execute(() -> {
                        doaDao.insertAll(response.body());
                        doaListLiveData.postValue(response.body());
                    });
                }
            }
            @Override
            public void onFailure(Call<List<Doa>> call, Throwable t) {
                executorService.execute(() -> {
                    List<Doa> doaList = doaDao.getAllDoa();
                    doaListLiveData.postValue(doaList);
                });
            }
        });
    }
}
