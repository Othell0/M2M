package com.cs.mm.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.cs.mm.R;
import com.cs.mm.util.ShareUtil;
import com.github.lazylibrary.util.AppUtils;

/**
 * Created by exbbefl on 6/12/2016.
 */
public class AboutApp extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_app);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //CollapsingToolbarLayout
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        if (collapsingToolbar != null) {
            collapsingToolbar.setTitle("关于App");
        }
        assert collapsingToolbar != null;
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.black));
        TextView mVersion = (TextView) findViewById(R.id.version);
        String version = AppUtils.getVerName(this);
        assert mVersion != null;
        mVersion.setText("版本号:" + "V" +
                "" + "" + version);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_share_app) {
            ShareUtil.shareText(this, "分享一个很赞的妹纸App,From @八宝山老司机...");
        }

        return super.onOptionsItemSelected(item);
    }
}