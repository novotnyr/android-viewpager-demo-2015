package sk.upjs.ics.android.slovensko;

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

        this.viewPager = (ViewPager) findViewById(R.id.tabViewPager);
    }

}
