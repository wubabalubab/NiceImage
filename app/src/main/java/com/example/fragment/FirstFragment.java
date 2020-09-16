package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.adapter.ImageRvAdapter;
import com.example.bean.ImageBean;
import com.example.textview.R;
import com.example.util.PictureUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private List<ImageBean> mList;
    private int index=0;
    PictureUtil pictureUtil;
    Unbinder unbinder;
    ImageRvAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_first, container, false);
       unbinder= ButterKnife.bind(this,view);
       return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        pictureUtil=new PictureUtil();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder!=null) {
            unbinder.unbind();
        }
    }

    private void initData() {

    }

}
