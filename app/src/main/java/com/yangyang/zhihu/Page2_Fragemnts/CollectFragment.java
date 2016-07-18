package com.yangyang.zhihu.Page2_Fragemnts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yangyang.zhihu.R;

/**
 * Created by yy on 16/7/18.
 */
public class CollectFragment extends Fragment {
    public CollectFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      return inflater.inflate(R.layout.fragment4,container,false);
    }

}
