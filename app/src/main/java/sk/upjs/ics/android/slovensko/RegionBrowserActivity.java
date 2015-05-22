package sk.upjs.ics.android.slovensko;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class RegionBrowserActivity extends ActionBarActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {

    public static final String EXTRA_SELECTED_REGION = "selectedRegion";
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_browser);

        final String[] regionNames = getResources().getStringArray(R.array.regionNames);
        this.viewPager = (ViewPager) findViewById(R.id.regionViewPager);
        this.viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return RegionDetailFragment.newInstance(regionNames[i]);
            }

            @Override
            public int getCount() {
                return regionNames.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return regionNames[position];
            }
        });
        this.viewPager.setOnPageChangeListener(this);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (String regionName : regionNames) {
            ActionBar.Tab tab = actionBar.newTab()
                    .setText(regionName)
                    .setTabListener(this);
            actionBar.addTab(tab);
        }

        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_SELECTED_REGION)) {
            String selectedRegion = intent.getStringExtra(EXTRA_SELECTED_REGION);
            int i = 0;
            for(String regionName : regionNames) {
                if(regionName.equals(selectedRegion)) {
                    this.viewPager.setCurrentItem(i);
                }
                i++;
            }
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        this.viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // do nothing
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // do nothing
    }

    @Override
    public void onPageSelected(int pageIndex) {
        getSupportActionBar().setSelectedNavigationItem(pageIndex);
    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
