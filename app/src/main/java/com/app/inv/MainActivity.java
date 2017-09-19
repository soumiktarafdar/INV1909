package com.app.inv;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.app.inv.InvestmentDetailsFragment.OnFragmentInteractionListener;
import com.app.inv.designproject.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        InvestmentFragment.OnFragmentInteractionListener, OnFragmentInteractionListener,
        ConfirmationFragment.OnFragmentInteractionListener, MyPreferenceFragment.OnFragmentInteractionListener,
        InvestmentHistoryFragment.OnFragmentInteractionListener, PreferenceResultFragment.OnFragmentInteractionListener,
        LinkAccountFragment.OnFragmentInteractionListener, PaymentActiveFragment.OnFragmentInteractionListener,
        PendingPaymentFragment.OnFragmentInteractionListener, PendingVerificationFragment.OnFragmentInteractionListener,
        ReInvestmentFragment.OnFragmentInteractionListener, SettingsFragment.OnFragmentInteractionListener{

    public DrawerLayout mDrawerLayout;
    public static NavigationView mNavigationView;
    public FragmentManager mFragmentManager;
    private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    public static TextView toolbar_home;
    private RecyclerView navRecyclerView;
    private RecyclerAdapterNavigationMenu mRecyclerAdapterNavigationMenu;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<NavigationMenu_SetterGetter> arrayList_NavigationMenu= new ArrayList<NavigationMenu_SetterGetter>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  *Setup the DrawerLayout and NavigationView
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_bar);
        mNavigationView.setNavigationItemSelectedListener(this);
        navRecyclerView = (RecyclerView)mNavigationView.findViewById(R.id.navRecyclerView);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar_home = (TextView)findViewById(R.id.toolbar_home);
        toolbar_home.setText(getString(R.string.title_investment));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Begin Fragment Transaction.
        replaceFragment(new InvestmentFragment(), R.string.title_investment);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerToggle.setDrawerIndicatorEnabled(false);
        mDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_menu);
        mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerVisible(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        layoutManager = new LinearLayoutManager(this);
        navRecyclerView.setLayoutManager(layoutManager);
    //    navRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        navRecyclerView.setHasFixedSize(true);
        navRecyclerView.setItemAnimator(new DefaultItemAnimator());

        arrayList_NavigationMenu.add(new NavigationMenu_SetterGetter(R.drawable.ic_menu_pref,
                getResources().getString(R.string.navigation_myPreference)));
        arrayList_NavigationMenu.add(new NavigationMenu_SetterGetter(R.drawable.ic_menu_pref_history,
                getResources().getString(R.string.navigation_investmentHistory)));
       /* arrayList_NavigationMenu.add(new NavigationMenu_SetterGetter(R.drawable.ic_menu_reinvestment,
                getResources().getString(R.string.navigation_Reinvestment)));*/
        arrayList_NavigationMenu.add(new NavigationMenu_SetterGetter(R.drawable.ic_menu_settings,
                getResources().getString(R.string.navigation_settings)));
        arrayList_NavigationMenu.add(new NavigationMenu_SetterGetter(R.drawable.ic_menu_logout,
                getResources().getString(R.string.navigation_Logout)));

        mRecyclerAdapterNavigationMenu = new RecyclerAdapterNavigationMenu(this, arrayList_NavigationMenu, mDrawerLayout);
        navRecyclerView.setAdapter(mRecyclerAdapterNavigationMenu);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

      /*  switch (id){
            case R.id.nav_my_preference:
                //Begin Fragment Transaction.
                replaceFragment(new InvestmentFragment(), R.string.title_investment);
                break;
            case R.id.nav_investment_history:
                //Begin Fragment Transaction.
                replaceFragment(new InvestmentHistoryFragment(), R.string.title_investmentHistory);
                break;
            case R.id.nav_reinvestment:
                //Begin Fragment Transaction.
                replaceFragment(new ReInvestmentFragment(), R.string.title_reInvestment);
                break;
            case R.id.nav_settings:
                //Open Setting Activity.
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_logout:
                //Perform Logout Operation here.
                break;
        }*/

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void replaceFragment(Fragment mFrag, int title){
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.containerView, mFrag);
        toolbar_home.setText(getString(title));
        t.addToBackStack(mFrag.getTag());
        t.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mFragmentManager = getSupportFragmentManager();

        if(mFragmentManager.getBackStackEntryCount()>0){
        //    Toast.makeText(this, String.valueOf(mFragmentManager.getBackStackEntryCount()), Toast.LENGTH_SHORT).show();
        //    updateActionBarTitle(mFragmentManager.getBackStackEntryAt(mFragmentManager.getBackStackEntryCount()).getName());
        }else {
            finish();
        }
    }

    private void updateActionBarTitle(Fragment fragment) {
        String fragClassName = fragment.getClass().getName();
/*
        if (fragClassName.equals(FirstFragment.class.getName())) {
            setTitle("Home");
        } else if (fragClassName.equals(SecondFragment.class.getName())) {
            setTitle("Second");
        }*/
    }
}

