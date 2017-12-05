package com.example.trile.storeverfinal.LeMinhTri.Java;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.example.trile.storeverfinal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment{
    ViewFlipper viewFlipper;
    Animation in,out;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.home_layout, container, false);
        viewFlipper = (ViewFlipper) v.findViewById(R.id.viewplipper_banner);
        in = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_in);
        out = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_out);
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);

        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);
        return v;
    }

}
