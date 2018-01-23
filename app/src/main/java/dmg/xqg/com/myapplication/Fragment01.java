package dmg.xqg.com.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by qhsj on 2018/1/23.
 */

public class Fragment01 extends Fragment {

    public TextView textView01;
    private FragmentCreatedHelper mFragmentCreatedHelper;

    public void setFragmentCreatedHelper(FragmentCreatedHelper fragmentCreatedHelper){
        this.mFragmentCreatedHelper = fragmentCreatedHelper;
    }

    interface FragmentCreatedHelper{
        void setData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("chris","onCreateView01");
        View rootView = inflater.inflate(R.layout.fragment01, container, false);
        textView01 = (TextView)rootView.findViewById(R.id.tv01);

        if (mFragmentCreatedHelper != null){
            mFragmentCreatedHelper.setData();
        }

        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser){
            Log.e("chris","isVisibleToUser01");
        }else{
            Log.e("chris","not isVisibleToUser01");
        }
    }
}
