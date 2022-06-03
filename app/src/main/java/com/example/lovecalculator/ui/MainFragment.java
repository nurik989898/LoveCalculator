package com.example.lovecalculator.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lovecalculator.R;
import com.example.lovecalculator.databinding.FragmentMainBinding;
import com.example.lovecalculator.network.App;
import com.example.lovecalculator.network.Model;
import com.example.lovecalculator.repository.Repository;
import com.example.lovecalculator.viewModel.MainViewModel;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainFragment extends Fragment {
    FragmentMainBinding binding;
    NavController navController;
    MainViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        navController = NavHostFragment.findNavController(this);
    }

    private void initClickers() {
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromLoveApi();
            }
        });
    }

    private void getDataFromLoveApi() {
        String firstName = binding.EditOne.getText().toString();
        String secondName = binding.EditTwo.getText().toString();
        viewModel.getLoveModelLiveData(firstName, secondName).observe(this, model -> {
            binding.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString("nas", model.percentage);
                    bundle.putString("hah", model.firstName);
                    bundle.putString("ha", model.secondName);
                    bundle.putString("h", model.result);
                    Log.e("ololo", "OnResponse " + model.percentage);
                    navController.navigate(R.id.secondFragment, bundle);
                }
            });
        });
    }
}
