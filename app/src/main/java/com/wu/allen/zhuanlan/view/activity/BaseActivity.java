package com.wu.allen.zhuanlan.view.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wu.allen.zhuanlan.R;
import com.wu.allen.zhuanlan.util.ToastUtil;

/**
 * Created by allen on 2016/6/14.
 */
public class BaseActivity extends AppCompatActivity implements SwipeRefreshLayout
        .OnRefreshListener,RecyclerArrayAdapter.OnLoadMoreListener{

    public void onCreate(){}

    public void initView(){}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            ToastUtil.showLong(BaseActivity.this,"Wait");
        }else if (id == R.id.action_about){
            Intent intent = new Intent(getApplicationContext(),AboutActivity.class);
            startActivity(intent);
        }else if (id == android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
