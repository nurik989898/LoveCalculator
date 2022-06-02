package com.example.lovecalculator.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lovecalculator.R;
import com.example.lovecalculator.databinding.FragmentMainBinding;
import com.example.lovecalculator.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    FragmentSecondBinding binding;
    NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String percentage = getArguments().getString("nas");
        binding.result.setText(percentage);
        String firstname = getArguments().getString("hah");
        binding.Anny.setText(firstname);
        String secondName = getArguments().getString("ha");
        binding.bill.setText(secondName);
        String desc = getArguments().getString("h");
        binding.desc.setText(desc);
        navController = NavHostFragment.findNavController(this);
        binding.btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigateUp();
            }
        });
    }

}