package com.example.bitsandpizza;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PizzaFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView pizzaRecyler= (RecyclerView) inflater.inflate(R.layout.fragment_pizza,container,false);
        List<Pizza> pizzaList= Arrays.asList(Pizza.pizza);
        CapImgAdapter capImgAdapter=new CapImgAdapter(pizzaList);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),2);
        pizzaRecyler.setLayoutManager(gridLayoutManager);

        pizzaRecyler.setAdapter(capImgAdapter);
        return pizzaRecyler;
    }
}