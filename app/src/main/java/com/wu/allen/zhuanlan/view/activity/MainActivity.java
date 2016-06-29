package com.wu.allen.zhuanlan.view.activity;


import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.listeners.ActionClickListener;
import com.wu.allen.zhuanlan.R;
import com.wu.allen.zhuanlan.util.NetWorkUtil;
import com.wu.allen.zhuanlan.view.fragment.GirlFragment;
import com.wu.allen.zhuanlan.view.fragment.ZhihuFragment;

import java.util.List;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private String[] titles = {"专栏","妹纸"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        switchToFragmnent();
        isNetOk();
    }
    // Judge network is ok
    public void isNetOk(){
        if(!NetWorkUtil.isNetworkConnected(getApplicationContext())){
            SnackbarManager.show(
                    Snackbar.with(getApplicationContext()) // context
                            .text("没有网络==") // text to display
                            .actionLabel("重试?") // action button label
                            .actionListener(new ActionClickListener() {
                                @Override
                                public void onActionClicked(Snackbar snackbar) {
                                    isNetOk();
                                }
                            }) // action button's ActionClickListener
                    , this);
        }
    }
    // initView
    public void initView(){
        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        setSupportActionBar(toolbar);
    }
    // switch fragment
    public void switchToFragmnent() {

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new ZhihuFragment();
                    case 1:
                        return new GirlFragment();
                    default:
                        return new ZhihuFragment();
                }
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return getString(R.string.zhihu);
                    case 1:
                        return getString(R.string.girl);
                    default:
                        return getString(R.string.zhihu);
                }
            }
        });

        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
