package com.suvo.quickchef.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by suvo on 3/8/2017.
 */

public class MyFragpagerAdapter extends FragmentPagerAdapter {


    ArrayList<Fragment> pages = new ArrayList<>();

    public MyFragpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }


    //add a page
    public void addpages(Fragment f)
    {
        pages.add(f);
    }


    //set title for tab
    @Override
    public CharSequence getPageTitle(int position) {
        return pages.get(position).toString();
    }
}
