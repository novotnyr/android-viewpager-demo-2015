package sk.upjs.ics.android.slovensko;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RegionDetailFragment extends android.support.v4.app.Fragment {
    public static final String ARG_REGION_NAME = "RegionName";
    private TextView regionDetailTextView;

    public static RegionDetailFragment newInstance(String regionName) {
        Bundle args = new Bundle();
        args.putString(ARG_REGION_NAME, regionName);

        RegionDetailFragment regionDetailFragment = new RegionDetailFragment();
        regionDetailFragment.setArguments(args);

        return regionDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_region_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.regionDetailTextView = (TextView) view.findViewById(R.id.regionDetailTextView);
        Bundle args = getArguments();
        if(args != null && args.containsKey(ARG_REGION_NAME)) {
            this.regionDetailTextView.setText(args.getString(ARG_REGION_NAME));
        }
    }
}
