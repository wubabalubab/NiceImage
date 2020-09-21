package com.example.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.textview.R;
import com.example.util.PictureUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {

    private ImageView mimage;
    private static final String TAG = "ThirdFragment";
    private String str="https://ae01.alicdn.com/kf/Udc4f4aac155545818ea877ccb4d09aa0Y.jpg";
    private String str1="http://ww3.sinaimg.cn/large/610dc034jw1f689lmaf7qj20u00u00v7.jpg";
    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_third, container, false);
        mimage=view.findViewById(R.id.test);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        PictureUtil picUt=new PictureUtil();
        Log.e(TAG, "onActivityCreated: ");
        picUt.load(mimage,str);
    }
}
