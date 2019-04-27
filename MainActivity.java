package com.example.nytimesarticleapp.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import com.example.nytimesarticleapp.R;
import com.example.nytimesarticleapp.databinding.ActivityMainBinding;
import com.example.nytimesarticleapp.util.FragmentUtils;
import com.example.nytimesarticleapp.view.base.BaseActivity;
import com.example.nytimesarticleapp.view.fragment.ArticleListFragment;

import static com.example.nytimesarticleapp.util.FragmentUtils.TRANSITION_NONE;


public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentUtils.replaceFragment(this, ArticleListFragment.newInstance(), R.id.fragContainer, false, TRANSITION_NONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }
}
