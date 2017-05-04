package com.suvo.quickchef.activity;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.suvo.quickchef.R;
import com.suvo.quickchef.adapters.MainMenuAdapter;
import com.suvo.quickchef.model.MainMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    //private RecyclerView recyclerView;
    private MainMenuAdapter menuAdapter;
    private List<MainMenu> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        menuList =  new ArrayList<>();
        menuAdapter = new MainMenuAdapter(this,menuList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,2);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(menuAdapter);

        prepareMenu();

        try
        {
            Glide.with(this).load(R.drawable.omelette).into((ImageView) findViewById(R.id.recipe_details_backdrop));
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */

    private void initCollapsingToolbar()
    {
        final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.recipeDetails_collapsing_toolbar);
        collapsingToolbar.setTitle(" ");

        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.recipeDetails_appBar);
        appBarLayout.setExpanded(true);


        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (scrollRange == -1)
                {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if(scrollRange + verticalOffset == 0)
                {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                }
                else if(isShow)
                {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }


    /**
     * Adding few albums for testing
     */
    private void prepareMenu()
    {
        int covers[] = new int[]{R.drawable.noodle,
                                    R.drawable.ten_min,
                                    R.drawable.fifteen_min,
                                    R.drawable.twenty_min};


        MainMenu mainMenu = new MainMenu("5 min","But its not a noodle",covers[0]);
        menuList.add(mainMenu);

        mainMenu = new MainMenu("10 min","But its not a noodle",covers[1]);
        menuList.add(mainMenu);

        mainMenu = new MainMenu("15 min","But its not a noodle",covers[2]);
        menuList.add(mainMenu);

        mainMenu = new MainMenu("House party","But its not a noodle",covers[3]);
        menuList.add(mainMenu);
    }



    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration
    {
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;


            Log.i("Span Count!!!",String.valueOf(spanCount));
            Log.i("Spacing!!!",String.valueOf(spacing));
            Log.i("Include Edge!!!",String.valueOf(includeEdge));
        }




        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
        {
            int position = parent.getChildAdapterPosition(view);
            Log.i("position offset!!!",String.valueOf(position));

            int column = position%spanCount;

            if(includeEdge)
            {
                outRect.left =  spacing - column * spacing/spanCount;
                outRect.right = (column+1)*spacing/spanCount;

                if (position < spanCount)
                {
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            }
            else
            {
                outRect.left = column * spacing/spanCount;
                outRect.right = spacing-(column+1)*spacing/spanCount;
                if(position >= spanCount)
                {
                    outRect.top = spacing;
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp)
    {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,r.getDisplayMetrics()));
    }
}
