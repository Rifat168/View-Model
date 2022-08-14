package com.seip.viewmodelexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seip.viewmodelexample.databinding.FragmentHomeBinding;
import com.seip.viewmodelexample.viewmodels.HomeViewModel;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container,false);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.getName().observe(getViewLifecycleOwner(), s -> binding.nameTV.setText(s));
        binding.changeNameBtn.setOnClickListener(v -> {
            final String name= binding.nameInputET.getText().toString();
            homeViewModel.setName(name);

        });
        return binding.getRoot();
    }
}