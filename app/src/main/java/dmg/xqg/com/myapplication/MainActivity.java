package dmg.xqg.com.myapplication;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Fragment01 fragment01;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        List<Fragment> fragments = new ArrayList<Fragment>() {
            {
                fragment01 = new Fragment01();
                add(fragment01); //
                add(new Fragment02()); //
            }
        };

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(fragments.size()); // 预加载

        // 1 试试延时，可行
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("chris","run1。。");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Log.e("chris","run2。。");
                            fragment01.textView01.setText("textView01不为空");
                        } catch (Exception e) {
                            Log.e("chris","textView01为空！！！");
                            e.printStackTrace();
                        }
                    }
                });
            }
        }, 100);


        // 2 监听Fragment onCreateView完成，可行
        /*fragment01.setFragmentCreatedHelper(new Fragment01.FragmentCreatedHelper() {
            @Override
            public void setData() {
                fragment01.textView01.setText("textView01不为空");
            }
        });*/
    }
}
