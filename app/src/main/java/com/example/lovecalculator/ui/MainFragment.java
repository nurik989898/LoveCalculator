package com.example.lovecalculator.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainFragment extends Fragment {
    FragmentMainBinding binding;
    NavController navController;
    private  final  String HOST = "love-calculator.p.rapidapi.com";
    public static final String KEY = "0543a92391mshbc36b91471d70ddp16c854jsn1f8ee85720a4";
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
        getDataFromLoveApi();
        initClickers();
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
        String firstName=binding.editOne.getText().toString();
        String secondName=binding.edittwo.getText().toString();
        App.api.loveCalculate(firstName,secondName,HOST,KEY).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
            if (response.isSuccessful()){
                Bundle bundle = new Bundle();
                bundle.putString("nas",response.body().percentage);
                Log.e("ololo","OnResponse " + response.body().percentage);
                binding.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        navController.navigate(R.id.secondFragment,bundle);
                    }
                });
            }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.e("ololo","onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}