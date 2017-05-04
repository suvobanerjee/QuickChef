package com.suvo.quickchef.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.suvo.quickchef.R;

public class MenuListActivity extends FragmentActivity  {

    private TextView testTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        testTextView = (TextView) findViewById(R.id.menuList_textView);

        Intent i = getIntent();
        String menuType= i.getStringExtra("menuType");

        testTextView.setText(menuType);


    }
}
