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

public class Fragment02 extends Fragment {

    public TextView textView02;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("chris","onCreateView02");
        View rootView = inflater.inflate(R.layout.fragment02, container, false);
        textView02 = (TextView)rootView.findViewById(R.id.tv02);
        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser){
            Log.e("chris","isVisibleToUser02");
        }else{
            Log.e("chris","not isVisibleToUser02");
        }
    }
}
