package com.example.activity;

import android.os.Bundle;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.adapter.MinePagerAdapter;
import com.example.fragment.FirstFragment;
import com.example.fragment.SecondFragment;
import com.example.fragment.ThirdFragment;
import com.example.textview.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager_ac_main)
    ViewPager viewpagerAcMain;
    MinePagerAdapter mAdapter;
    List<Fragment>fragments;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragments=new ArrayList<>();
        FirstFragment firstFragment=new FirstFragment();
        SecondFragment secondFragment=new SecondFragment();
        ThirdFragment thirdFragment=new ThirdFragment();
        fragments.add(firstFragment);
        fragments.add(secondFragment);
        fragments.add(thirdFragment);
        mAdapter=new MinePagerAdapter(this,getSupportFragmentManager(),viewpagerAcMain);
        viewpagerAcMain.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewpagerAcMain);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        mAdapter.setFragment(fragments);
        for (int i = 0; i <tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab=tabLayout.getTabAt(i);
            assert tab != null;
            tab.setCustomView(mAdapter.getCustomView(i,tabLayout));
        }
        viewpagerAcMain.setCurrentItem(0);
        tabLayout.setSelectedTabIndicatorHeight(0);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
    public void setPageCurrent(int position) {
        viewpagerAcMain.setCurrentItem(position);
    }
}
