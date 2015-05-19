package sk.upjs.ics.android.slovensko;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class RegionBrowserActivity extends ActionBarActivity {

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
        });
    }

}
