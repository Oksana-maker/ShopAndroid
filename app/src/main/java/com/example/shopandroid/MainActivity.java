package com.example.shopandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shopandroid.dummy.Content;
import com.example.shopandroid.fragments.AddFragment;
import com.example.shopandroid.fragments.InfoFragment;
import com.example.shopandroid.fragments.ItemsFragment;

public class MainActivity extends AppCompatActivity
        implements ItemsFragment.OnItemsFragmentListener
        , InfoFragment.OnInfoFragmentListener
        , AddFragment.OnAddFragmentListener
{
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_view, new AddFragment(), "ADD_TAG")
                    .commit();
            btnAdd.setVisibility(View.INVISIBLE);
        });

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, new ItemsFragment(), "LIST_TAG")
                .commit();
    }

    @Override
    public void onItemSelect(Content.DummyItem item) {
        InfoFragment infoFragment = new InfoFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, infoFragment, "INFO_TAG")
                .commit();

        infoFragment.setData(item);
        btnAdd.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBtnBackClick() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, new ItemsFragment(), "LIST_TAG")
                .commit();
        btnAdd.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBtnAddClick() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, new ItemsFragment(), "LIST_TAG")
                .commit();
        btnAdd.setVisibility(View.VISIBLE);
    }
}