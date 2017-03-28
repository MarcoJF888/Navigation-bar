package com.self.template.Fragment;

import android.app.Fragment;

import com.self.template.R;

/**
 * <pre>
 *     author : ZouJianFeng-Marco
 *     e-mail :
 *     time   : 2017/03/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class AFragment extends BaseFragment{

    public static AFragment newInstance() {
        AFragment f = new AFragment();
        return f;
    }

    @Override
    protected void initView() {}

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    protected int layoutId() {
        return R.layout.tab_a;
    }
}
