package com.cs.mm.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cs.mm.R;
import com.cs.mm.util.ShareUtil;
import com.cs.mm.view.fragment.MainFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private String[] titles = {"福利","Android","iOS","休息视频"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //List
        fragments = new ArrayList<>();
        for (String title : titles){
            fragments.add(MainFragment.getInstance(title));
        }

        //ViewPager
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        if (viewPager != null) {
            viewPager.setOffscreenPageLimit(4);
        }
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        //TabLayout
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(viewPager);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_share_app:
                ShareUtil.shareText(this, "分享一个很赞的App，让更多的人上车吧～(￣▽￣～)(～￣▽￣)～ ノ http://fir.im/Othello");
                /*Snackbar.make(viewPager, "还没开发呢.. ( ＞ω＜)", Snackbar.LENGTH_SHORT).show();*/
                break;
            case R.id.action_about_app:
                startActivity(new Intent(this, AboutApp.class));
                Snackbar.make(viewPager, "还没开发呢... ( ＞ω＜)", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.action_about_me:
                startActivity(new Intent(this, AboutMe.class));
                Snackbar.make(viewPager, "什么都没有...ヾ (o ° ω ° O ) ノ", Snackbar.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
