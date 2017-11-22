package google.architecture.specific;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;

import google.architecture.common.base.BaseActivity;
import google.architecture.common.base.BaseFragment;
import google.architecture.common.util.BindingUtils;
import google.architecture.common.widget.NoScrollViewPager;
import google.architecture.specific.databinding.ActivityMainBinding;

public class ActivityMain extends BaseActivity {

    ActivityMainBinding mainBinding;
    private NoScrollViewPager mPager;
    private List<BaseFragment> mFragments = new ArrayList<>();
    private FragmentAdapter mAdapter;

    public BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int i = item.getItemId();
            if (i == R.id.navigation_home) {
                mPager.setCurrentItem(0);
                return true;
            } else if (i == R.id.navigation_dashboard) {
                mPager.setCurrentItem(1);
                return true;
            } else if (i == R.id.navigation_notifications) {
                mPager.setCurrentItem(2);
                return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         mainBinding = DataBindingUtil.setContentView(ActivityMain.this, R.layout.activity_main);

         mainBinding.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
         mPager = mainBinding.containerPager;

        BaseFragment fragmentGirls = (BaseFragment) ARouter.getInstance().build( "/girls/list/fragment" ).navigation();
        BaseFragment fragmentNews = (BaseFragment) ARouter.getInstance().build( "/news/list/fragment" ).navigation();
        BaseFragment fragmentAbout = (BaseFragment) ARouter.getInstance().build( "/about/fragment" ).navigation();

        mFragments.add(fragmentGirls);
        mFragments.add(fragmentNews);
        mFragments.add(fragmentAbout);

        mAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragments);
        mainBinding.setViewPaAdapter(mAdapter);

    }
}
