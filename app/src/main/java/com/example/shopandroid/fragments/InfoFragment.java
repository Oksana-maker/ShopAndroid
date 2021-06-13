package com.example.shopandroid.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shopandroid.R;
import com.example.shopandroid.dummy.Content;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoFragment extends Fragment {

    public interface OnInfoFragmentListener {
        void onBtnBackClick();
    }

    private OnInfoFragmentListener listener;
    ImageView ivInfo;
    TextView txtTitleInfo;
    TextView txtPriceInfo;
    Content.DummyItem item;
    Button btnBack;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InfoFragment newInstance(String param1, String param2) {
        InfoFragment fragment = new InfoFragment();
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
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        ivInfo = view.findViewById(R.id.ivInfo);
        txtTitleInfo = view.findViewById(R.id.txtTitleInfo);
        txtPriceInfo = view.findViewById(R.id.txtPriceInfo);
        btnBack = view.findViewById(R.id.btnBack);
        Picasso.get().load(Uri.parse(item.imagePath)).into(ivInfo);
        txtTitleInfo.setText(item.title);
        txtPriceInfo.setText(String.valueOf(item.price));
        btnBack.setOnClickListener(v -> {
            listener.onBtnBackClick();
        });
        return view;
    }

    public void setData(Content.DummyItem item) {
        this.item = item;
        Log.d("TAG", "IOException : ");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnInfoFragmentListener) {
            listener = (OnInfoFragmentListener) context;
        }
    }
}