package com.self.template.Fragment;

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

public class CFragment extends BaseFragment{

    public static CFragment newInstance() {
        CFragment f = new CFragment();
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
        return R.layout.tab_c;
    }
}