package com.example.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.ImageRvAdapter;
import com.example.bean.ImageBean;
import com.example.textview.R;
import com.example.util.NetUtil;
import com.example.util.PictureUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    @BindView(R.id.rv_fg_first_main)
    RecyclerView rvFgFirstMain;
    private ArrayList<ImageBean> mList=new ArrayList<>();
    private int index = 1;
    private PictureUtil pictureUtil;
    private Unbinder unbinder;
    private ImageRvAdapter mAdapter;
    private NetUtil netUtil;
    private ImageTask imageTask;
    private static final String TAG = "FirstFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();

        GridLayoutManager layoutmanager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        rvFgFirstMain.setLayoutManager(layoutmanager);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        imageTask.cancel(true);
    }

    private void initData() {
        netUtil = new NetUtil();
        pictureUtil = new PictureUtil();
        // Cannot execute task: the task is already running. oor
        imageTask=new ImageTask();
        imageTask.execute();
    }

    private class ImageTask extends AsyncTask<Void, Void, List<ImageBean>> {

        public ImageTask() {
        }

        @Override
        protected List<ImageBean> doInBackground(Void... voids) {
            return netUtil.getImageList(10, index);
        }

        @Override
        protected void onPostExecute(List<ImageBean> imageBeans) {
            super.onPostExecute(imageBeans);
            mList.clear();
            mList.addAll(imageBeans);
            index++;
            Log.e(TAG, "onPostExecute: "+mList.toString());
            mAdapter=new ImageRvAdapter(getContext(),mList);
            rvFgFirstMain.setAdapter(mAdapter);
//            if (rvFgFirstMain.getRecycledViewPool() != null) {
//                rvFgFirstMain.getRecycledViewPool().setMaxRecycledViews(0,10);
//            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            imageTask.onCancelled();
        }
    }

}
