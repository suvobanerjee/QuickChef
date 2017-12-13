package com.suvo.quickchef.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suvo.quickchef.R;
import com.suvo.quickchef.adapters.RecipeListAdapter;
import com.suvo.quickchef.model.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suvo on 3/7/2017.
 */

public class FifteenMinRecipeListFrag extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fifteen_min_frag,null);

        //RecyclerView
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.fifteenMin_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(new RecipeListAdapter(this.getActivity(),getFifteenMinRecipeList()));

        return v;
    }

    private List<Recipe> getFifteenMinRecipeList() {

        //Images need to get from the db***************
        int thumbNailImgId = R.drawable.omelette;

        List<Recipe> recipeList = new ArrayList<Recipe>();

        Recipe recipe = new Recipe(thumbNailImgId,"Omellete","The easy and healthy snack");
        recipeList.add(recipe);

        recipe = new Recipe(thumbNailImgId,"Omellete2","The easy and healthy snack");
        recipeList.add(recipe);

        recipe = new Recipe(thumbNailImgId,"Omellete3","The easy and healthy snack");
        recipeList.add(recipe);

        recipe = new Recipe(thumbNailImgId,"Omellete4","The easy and healthy snack");
        recipeList.add(recipe);



        recipe = new Recipe(thumbNailImgId,"Omellete5","The easy and healthy snack");
        recipeList.add(recipe);

        return recipeList;
    }


    @Override
    public String toString() {
        return "15 Min";
    }
}
