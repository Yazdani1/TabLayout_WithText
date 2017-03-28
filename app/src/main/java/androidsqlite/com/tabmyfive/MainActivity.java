package androidsqlite.com.tabmyfive;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        viewPager=(ViewPager)findViewById(R.id.viewpager_xml);
        setUpViewPager(viewPager);

        tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setUpViewPager(ViewPager viewPager){

        ViewpagerAdapter adapter=new ViewpagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new OneFragment(),"One");
        adapter.addFragment(new TwoFragment(),"Two");
        adapter.addFragment(new ThreeFragment(),"Three");
        viewPager.setAdapter(adapter);


    }


    class ViewpagerAdapter extends FragmentPagerAdapter

    {

        private final List<Fragment>mFragment=new ArrayList<>();

        private final List<String>mFragmentTitle=new ArrayList<>();


        public ViewpagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragment.get(position);
        }

        @Override
        public int getCount() {
            return mFragment.size();
        }

        public void addFragment(Fragment fragment,String title){

            mFragment.add(fragment);
            mFragmentTitle.add(title);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitle.get(position);
        }
    }





}
