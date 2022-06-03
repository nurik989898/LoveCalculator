package com.example.lovecalculator.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.lovecalculator.network.Model;
import com.example.lovecalculator.repository.Repository;

public class MainViewModel extends ViewModel {
    Repository repository = new Repository();
    public LiveData<Model>getLoveModelLiveData(String first,String second){
        return repository.getData(first, second);
    }
}
