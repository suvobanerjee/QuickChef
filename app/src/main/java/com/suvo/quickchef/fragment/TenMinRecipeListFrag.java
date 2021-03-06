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

public class TenMinRecipeListFrag extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.ten_min_frag,null);

        //RecyclerView
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.tenMin_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(new RecipeListAdapter(this.getActivity(),getTenMinRecipeList()));

        return v;
    }

    private List<Recipe> getTenMinRecipeList() {

        //Images need to get from the db***************
        int thumbNailImgId = R.drawable.omelette;

        List<Recipe> recipeList = new ArrayList<Recipe>();

        Recipe recipe = new Recipe(thumbNailImgId,"Omellete","The 10 min recipe is here");
        recipeList.add(recipe);

        recipe = new Recipe(thumbNailImgId,"Omellete2","The 10 min recipe is here");
        recipeList.add(recipe);

        recipe = new Recipe(thumbNailImgId,"Omellete3","The 10 min recipe is here");
        recipeList.add(recipe);

        recipe = new Recipe(thumbNailImgId,"Omellete4","The 10 min recipe is here");
        recipeList.add(recipe);

        recipe = new Recipe(thumbNailImgId,"Omellete5","The 10 min recipe is here");
        recipeList.add(recipe);

        return recipeList;
    }

    @Override
    public String toString() {
        return "10 Min";
    }
}
