package com.self.template.Util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;


import com.self.template.R;

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
public class FragmentTabHandler {
	
	public static final int NO_ANIMATION=0;
	private List<Fragment> fragments;
	private FragmentActivity fragmentActivity;
	private int fragmentContentId;          
	private int currentTab;
	private boolean isInit=false;

	public FragmentTabHandler(FragmentActivity fragmentActivity, List<Fragment> fragments, int fragmentContentId) {
		this.fragments = fragments;
		this.fragmentActivity = fragmentActivity;
		this.fragmentContentId = fragmentContentId;
	}


	
	
	public void showTab(int idx) {	
		
		for (int i = 0; i < fragments.size(); i++) {
			if (idx == i) {			
				Fragment fragment = fragments.get(i);
				FragmentTransaction ft = null;
				if(!isInit&&idx==0){
					ft=obtainFragmentTransaction(idx,NO_ANIMATION);
					isInit=true;
				}else{
					ft=obtainFragmentTransaction(idx,1);
				}
			
			    if(getCurrentFragment()!=null&&getCurrentFragment().isVisible()){			    	
					getCurrentFragment().onPause();	
					ft.hide(getCurrentFragment());			    	
			    }

			    currentTab = idx;
				if(fragment.isAdded()){
					fragment.onResume();
				}else{
					ft.add(fragmentContentId, fragment);
				}	
				
				ft.show(fragment);
				try {
					ft.commit();
				} catch (Exception e) {
		//	      Log.d("commitError"," -->"+e.toString());
				}
				
				return;
			}
			
		}
				
	}

	
	/**
	 * FragmentTransaction 
	 */
	private FragmentTransaction obtainFragmentTransaction(int index, int type) {
		FragmentTransaction ft = fragmentActivity.getSupportFragmentManager().beginTransaction();
		
		if(type==NO_ANIMATION)
			return ft;
		
		if (index > currentTab) {
			ft.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_left_out);
		} else {
			ft.setCustomAnimations(R.anim.slide_right_in,R.anim.slide_right_out);
		}
		return ft;
	}
	


	public int getCurrentTab() {
		return currentTab;
	}

	public Fragment getCurrentFragment() {
		return fragments.get(currentTab);
	}



}
