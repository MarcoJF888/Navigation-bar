package com.self.template;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;
/**
 * <pre>
 *     author : ZouJianFeng-Marco
 *     e-mail :
 *     time   : 2017/03/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class HomeAct extends FragmentActivity {

    private long mExitTime;
    public FlowRadioGroup rgs;
    public FragmentTabHandler fragmentContorler;
    private List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.win_home);



        TabFragment homeFragment = new TabFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString(TabFragment.CONTENT,"首页");
        homeFragment.setArguments(bundle1);
        fragments.add(homeFragment);

        TabFragment homeFragment2 = new TabFragment();
        Bundle bundle2= new Bundle();
        bundle2.putString(TabFragment.CONTENT,"资讯");
        homeFragment2.setArguments(bundle2);
        fragments.add(homeFragment2);

        TabFragment homeFragment3 = new TabFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putString(TabFragment.CONTENT,"发现");
        homeFragment3.setArguments(bundle3);
        fragments.add(homeFragment3);

        TabFragment homeFragment4 = new TabFragment();
        Bundle bundle4 = new Bundle();
        bundle4.putString(TabFragment.CONTENT,"我的");
        homeFragment4.setArguments(bundle4);
        fragments.add(homeFragment4);


        rgs = (FlowRadioGroup) findViewById(R.id.tabMain);

        fragmentContorler = new FragmentTabHandler(HomeAct.this, fragments, R.id.layout_tab_content);

        rgs.setOnCheckedChangeListener(new FlowRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(FlowRadioGroup group, int checkedId) {
                switch (checkedId) {

                    case R.id.btnHome:
                        fragmentContorler.showTab(0);
                        break;

                    case R.id.btnNews:
                        fragmentContorler.showTab(1);
                        break;

                    case R.id.btnDiscovery:
                        fragmentContorler.showTab(2);
                        break;

                    case R.id.btnMe:
                        fragmentContorler.showTab(3);
                        break;

                    default:
                        break;
                }
            }
        });

        ((RadioButton)findViewById(R.id.btnHome)).setChecked(true);
    }

}
