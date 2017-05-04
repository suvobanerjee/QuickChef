package com.suvo.quickchef.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.suvo.quickchef.R;
import com.suvo.quickchef.adapters.MyFragpagerAdapter;
import com.suvo.quickchef.fragment.FifteenMinRecipeListFrag;
import com.suvo.quickchef.fragment.FiveMinRecipeListFrag;
import com.suvo.quickchef.fragment.TenMinRecipeListFrag;

public class MenuListActivityUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        String menuType = i.getStringExtra("menuType");

        int pos = 0;
        if(menuType != null) {

            //Log.i("MENUTYPE",menuType);
            if (menuType.equals("5 min")) {
                pos = 0;
            } else if (menuType.equals("10 min")) {
                pos = 1;
            } else {
                pos = 3;
            }
        }

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/


        ViewPager vp = (ViewPager) findViewById(R.id.menuList_viewpager);
        this.addPages(vp);



        /*MyFragpagerAdapter adapter = new MyFragpagerAdapter(getSupportFragmentManager());
        adapter.addpages(new FiveMinRecipeListFrag());
        adapter.addpages(new TenMinRecipeListFrag());
        adapter.addpages(new FifteenMinRecipeListFrag());


        //set adapter to pager
        vp.setAdapter(adapter);
*/
        vp.setCurrentItem(pos);



        TabLayout tabLayout = (TabLayout) findViewById(R.id.menuList_tabId);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(vp);
        tabLayout.addOnTabSelectedListener(listener(vp));

    }

    //add all pages
    private void addPages(ViewPager pager)
    {
        MyFragpagerAdapter adapter = new MyFragpagerAdapter(getSupportFragmentManager());
        adapter.addpages(new FiveMinRecipeListFrag());
        adapter.addpages(new TenMinRecipeListFrag());
        adapter.addpages(new FifteenMinRecipeListFrag());

        //set adapter to pager
        pager.setAdapter(adapter);

    }


    private TabLayout.OnTabSelectedListener listener(final ViewPager pager)
    {
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };
    }

}
