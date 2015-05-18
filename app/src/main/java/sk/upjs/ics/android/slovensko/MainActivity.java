package sk.upjs.ics.android.slovensko;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        configureRegionListTab();
        configureCountyListTab();
    }

    private void configureRegionListTab() {
        ActionBar actionBar = getSupportActionBar();

        ActionBar.Tab tab = actionBar.newTab();
        tab.setText("Kraje");
        tab.setTabListener(this);
        tab.setTag(RegionListFragment.class.getName());

        actionBar.addTab(tab);
    }


    private void configureCountyListTab() {
        ActionBar actionBar = getSupportActionBar();

        ActionBar.Tab tab = actionBar.newTab();
        tab.setText("Okresy");
        tab.setTabListener(this);
        tab.setTag(CountyListFragment.class.getName());

        actionBar.addTab(tab);
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        String tag = (String) tab.getTag();
        String fragmentClassName = tag;

        Fragment selectedFragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (selectedFragment == null) {
            selectedFragment = Fragment.instantiate(this, fragmentClassName);
            ft.add(android.R.id.content, selectedFragment, tag);
        } else {
            ft.attach(selectedFragment);
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        String tag = (String) tab.getTag();
        Fragment selectedFragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (selectedFragment != null) {
            ft.detach(selectedFragment);
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
