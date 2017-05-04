package com.suvo.quickchef.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.suvo.quickchef.R;
import com.suvo.quickchef.activity.MainActivity;
import com.suvo.quickchef.activity.RecipeDetails;
import com.suvo.quickchef.model.Recipe;

import java.util.List;

/**
 * Created by suvo on 3/6/2017.
 */

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.MyRecipeListHolder> {

    private Context mContext;
    private List<Recipe> recipeList;


    public RecipeListAdapter(Context mContext, List<Recipe> recipeList) {
        this.mContext = mContext;
        this.recipeList = recipeList;
    }


    public class MyRecipeListHolder extends RecyclerView.ViewHolder
    {

        ImageView thumbnailStrip,vegNonVeg;
        TextView title,subtitle;

        public MyRecipeListHolder(View itemView) {
            super(itemView);

            thumbnailStrip = (ImageView) itemView.findViewById(R.id.menuList_thumbnail);
            vegNonVeg = (ImageView) itemView.findViewById(R.id.menuList_vegNonVeg);
            title = (TextView) itemView.findViewById(R.id.menuList_menuTitle);
            subtitle = (TextView) itemView.findViewById(R.id.menuList_subtitle);
        }
    }

    @Override
    public MyRecipeListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_list_model,parent,false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext , RecipeDetails.class);
                mContext.startActivity(i);
            }
        });

        return new MyRecipeListHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecipeListHolder holder, int position) {

        final Recipe recipe = recipeList.get(position);

        Glide.with(mContext).load(recipe.getThumbnail()).into(holder.thumbnailStrip);
        holder.title.setText(recipe.getTitle());
        holder.title.setText(recipe.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }





}
