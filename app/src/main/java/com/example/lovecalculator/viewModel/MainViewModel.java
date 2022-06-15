package com.example.lovecalculator.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.lovecalculator.network.Model;
import com.example.lovecalculator.repository.Repository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {
    Repository repository;
    @Inject
    public MainViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<Model>getLoveModelLiveData(String first, String second){
        return repository.getData(first, second);
    }
}
