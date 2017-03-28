package com.self.template.Fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

/**
 * <pre>
 *     author : ZouJianFeng-Marco
 *     e-mail :
 *     time   : 2017/03/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public abstract class BaseFragment extends Fragment {
	protected ViewGroup content;
	protected Handler mMainHandler;

	protected LayoutInflater inflater;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 inflater = getActivity().getLayoutInflater();
		content = (ViewGroup) inflater.inflate(layoutId(),  null, false);

		mMainHandler = new Handler(new Handler.Callback() {
			@Override
			public boolean handleMessage(Message msg) {
				BaseFragment.this.handleMessage(msg);
				return true;
			}
		});

		if (getArguments() != null) {
			initView(getArguments());
		}else {
			initView();
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container,  Bundle savedInstanceState) {
		ViewGroup p = (ViewGroup) content.getParent();
		if (p != null) {
			p.removeAllViewsInLayout();
		}
		return content;
	}


	protected abstract void initView();
	protected  void initView(Bundle bundle){};

	protected abstract int layoutId();


	protected void handleMessage(Message msg) {

	}


}
