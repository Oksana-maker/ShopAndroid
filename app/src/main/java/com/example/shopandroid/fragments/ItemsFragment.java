package com.example.shopandroid.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shopandroid.ItemsRecyclerViewAdapter;
import com.example.shopandroid.R;
import com.example.shopandroid.dummy.Content;

/**
 * A fragment representing a list of Items.
 */
public class ItemsFragment extends Fragment
        implements ItemsRecyclerViewAdapter.OnItemsRecyclerViewAdapter {

    public interface OnItemsFragmentListener {
        void onItemSelect(Content.DummyItem item);
    }

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnItemsFragmentListener listener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemsFragment() {
    }

    @Override
    public void onItemClick(Content.DummyItem item) {
        listener.onItemSelect(item);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnItemsFragmentListener) {
            listener = (OnItemsFragmentListener) context;
        }
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ItemsFragment newInstance(int columnCount) {
        ItemsFragment fragment = new ItemsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new ItemsRecyclerViewAdapter(this::onItemClick, Content.ITEMS));
        }
        return view;
    }

}
