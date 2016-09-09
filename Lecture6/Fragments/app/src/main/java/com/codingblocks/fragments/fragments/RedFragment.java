package com.codingblocks.fragments.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.fragments.R;

/**
 * Created by championswimmer on 02/09/16.
 */
public class RedFragment extends Fragment {

    public static RedFragment newInstance(int count) {

        Bundle args = new Bundle();
        args.putInt("count", count);
        RedFragment fragment = new RedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_red, container, false);


        int count = getArguments().getInt("count");
        ((TextView) rootView.findViewById(R.id.count)).setText(String.valueOf(count));

        return rootView;
    }
}
