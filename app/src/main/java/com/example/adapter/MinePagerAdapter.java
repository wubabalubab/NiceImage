package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.activity.MainActivity;
import com.example.textview.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MinePagerAdapter extends FragmentPagerAdapter {
    Context mContext;
    List<Fragment> fragments=new ArrayList<>();
    FragmentManager fm;
    ViewPager viewPager;
    public MinePagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    public MinePagerAdapter(Context context, FragmentManager fm, ViewPager viewPager) {
        super(fm);
        this.mContext=context;
        this.fm=fm;
        this.viewPager=viewPager;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
    @Override
    public int getCount() {
        return fragments.size();
    }
    public void setFragment(List<Fragment> fragments) {
        if (this.fragments != null) {
            FragmentTransaction ft=fm.beginTransaction();
            for (Fragment fragment : fragments) {
                this.fragments.remove(fragment);
            }
            ft.commit();
            ft=null;
            fm.executePendingTransactions();
        }
        this.fragments=fragments;
        notifyDataSetChanged();
    }

    public View getCustomView(int position, TabLayout tabLayout) {
        Context context=mContext;
        View view=null;
        view= LayoutInflater.from(context).inflate(R.layout.item_tab_act_main,tabLayout,false);
        ImageView image=view.findViewById(R.id.im_tab);
        switch(position){
            case 0:
                image.setBackgroundResource(R.drawable.ic_start);
                break;
            case 1:
                image.setBackgroundResource(R.drawable.ic_start);
                break;
            case 2:
                image.setBackgroundResource(R.drawable.ic_start);
                break;
        }
        return view;
    }
}
