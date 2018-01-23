package dmg.xqg.com.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;



import java.util.List;


/**
 * @author: zhangxin
 * @time: 2016/7/17 10:47
 * @description: viewpager 的公共适配器
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private Bundle bundle;

    public ViewPagerAdapter(FragmentManager frm, List<Fragment> fragments) {
        super(frm);
        this.fragments = fragments;
    }

    public ViewPagerAdapter(FragmentManager frm, List<Fragment> fragments, Bundle bundle) {
        super(frm);
        this.fragments = fragments;
        this.bundle = bundle;
    }

    @Override
    public Fragment getItem(int index) {
        Fragment baseFragment = fragments.get(index);
        if (null != bundle) {
            baseFragment.setArguments(bundle);
        }
        return baseFragment;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
