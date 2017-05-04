package com.suvo.quickchef.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.suvo.quickchef.R;
import com.suvo.quickchef.activity.MenuListActivity;
import com.suvo.quickchef.activity.MenuListActivityUp;
import com.suvo.quickchef.model.MainMenu;

import java.util.List;

/**
 * Created by suvo on 3/3/2017.
 */

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.MyViewHolder> {

    private Context mContext;
    private List<MainMenu> menuLsit;

    public MainMenuAdapter(Context mContext, List<MainMenu> menuLsit) {
        this.mContext = mContext;
        this.menuLsit = menuLsit;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_menu_card,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final MainMenu mainMenu = menuLsit.get(position);

        holder.menuTypeName.setText(mainMenu.getTypeOfRecipe());
      /*  holder.menuTypeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("Adapter:::",mainMenu.getTypeOfRecipe());
                startNewActitvity(mainMenu.getTypeOfRecipe());

            }
        });
*/
        holder.subtitle.setText(mainMenu.getSubtitle());
  /*      holder.subtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("Adapter:::",mainMenu.getSubtitle());
                startNewActitvity(mainMenu.getTypeOfRecipe());

            }
        });
*/
        // loading album cover using Glide library
        Glide.with(mContext).load(mainMenu.getThumbnail()).into(holder.thubnail);
        holder.thubnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActitvity(mainMenu.getTypeOfRecipe());
            }
        });




    }

    @Override
    public int getItemCount() {
        return menuLsit.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        public TextView menuTypeName,subtitle;
        public ImageView thubnail;


        public MyViewHolder(View itemView) {
            super(itemView);

            menuTypeName = (TextView) itemView.findViewById(R.id.mainMenu_menuType);
            subtitle = (TextView) itemView.findViewById(R.id.mainMenu_susbtitle);
            thubnail = (ImageView) itemView.findViewById(R.id.mainMenu_thumbnail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startNewActitvity(menuLsit.get(getLayoutPosition()).getTypeOfRecipe());
                }
            });

        }
    }

    public void startNewActitvity(String menuType)
    {
        //Intent i=new Intent(mContext, MenuListActivity.class);
        Intent i=new Intent(mContext, MenuListActivityUp.class);
        i.putExtra("menuType",menuType);
        mContext.startActivity(i);
    }
}
