package com.example.shopandroid.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.shopandroid.R;
import com.example.shopandroid.dummy.Content;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment {

    public interface OnAddFragmentListener {
        void onBtnAddClick();
    }
    private OnAddFragmentListener listener;
    ImageView ivAdd;
    EditText etTitleAdd, etPriceAdd;
    Button btnCancel, btnSave;
    Uri uri;

    private static final int FILE_SELECT_CODE = 0;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddFragment newInstance(String param1, String param2) {
        AddFragment fragment = new AddFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        ivAdd = view.findViewById(R.id.ivAdd);
        etTitleAdd = view.findViewById(R.id.etTitleAdd);
        etPriceAdd = view.findViewById(R.id.etPriceAdd);
        btnCancel = view.findViewById(R.id.btnCancel);
        btnSave = view.findViewById(R.id.btnSave);

        ivAdd.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            try {
                startActivityForResult(Intent.createChooser(intent, "Select a File"), FILE_SELECT_CODE);
            } catch (Exception ex) {

            }
        });
        btnCancel.setOnClickListener(v -> {
            listener.onBtnAddClick();
        });
        btnSave.setOnClickListener(v -> {
            Content.ITEMS.add(new Content.DummyItem(
                    String.valueOf(Content.ITEMS.size())
                    , etTitleAdd.getText().toString()
                    , uri.toString()
                    , etPriceAdd.getAlpha()));
            listener.onBtnAddClick();
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_SELECT_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                uri = data.getData();
                Picasso.get().load(uri).into(ivAdd);
            }
        }
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnAddFragmentListener) {
            listener = (OnAddFragmentListener) context;
        }
    }
}