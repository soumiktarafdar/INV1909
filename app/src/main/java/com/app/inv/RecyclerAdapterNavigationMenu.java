package com.app.inv;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.inv.designproject.R;

import java.util.ArrayList;

public class RecyclerAdapterNavigationMenu extends RecyclerView.Adapter<RecyclerAdapterNavigationMenu.MyViewHolder> {

    private ArrayList<NavigationMenu_SetterGetter> arrayList = new ArrayList<>();
    private Context context;
    private DrawerLayout mDrawerLayout;

    public RecyclerAdapterNavigationMenu(Context context, ArrayList<NavigationMenu_SetterGetter> arrayList,
                                         DrawerLayout drawerLayout) {
        this.arrayList = arrayList;
        this.context = context;
        this.mDrawerLayout = drawerLayout;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_navigation_menu, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.image_nav_menu.setImageResource(arrayList.get(position).getMenu_icon());
        holder.text_nav_option.setText(arrayList.get(position).getMenu_option());

        if(arrayList.get(position).getMenu_option().equals("Logout")){
            holder.view_line.setVisibility(View.GONE);
        }

        holder.text_nav_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String option = arrayList.get(position).getMenu_option();
                switch (option){
                    case "My Preference":
                        //Begin Fragment Transaction.
                        ((MainActivity)context).replaceFragment(new MyPreferenceFragment(), R.string.title_myPreference);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case "Investment History":
                        //Begin Fragment Transaction.
                        ((MainActivity)context).replaceFragment(new InvestmentHistoryFragment(), R.string.title_investmentHistory);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        break;
                 /*   case "Reinvestment":
                        //Begin Fragment Transaction.
                        ((MainActivity)context).replaceFragment(new ReInvestmentFragment(), R.string.title_reInvestment);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        break;*/
                    case "Settings":
                        //Open Setting Activity.
                        ((MainActivity)context).replaceFragment(new SettingsFragment(), R.string.title_Settings);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case "Logout":
                        //Perform Logout Operation here.
                        ((MainActivity)context).finish();
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView text_nav_option;
        private ImageView image_nav_menu;
        private View view_line;

        public MyViewHolder(View itemView) {
            super(itemView);
            image_nav_menu = (ImageView) itemView.findViewById(R.id.image_nav_menu);
            text_nav_option = (TextView)itemView.findViewById(R.id.text_nav_option);
            view_line = (View) itemView.findViewById(R.id.view_line);
        }
    }
}

