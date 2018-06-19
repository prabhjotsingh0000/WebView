package com.example.prabhjot.theonewhereiwasabsent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class MyFragment extends Fragment {

    boolean isMore;
    WebView webView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        isMore= this.getArguments().getBoolean("val");

        View view= inflater.inflate(R.layout.fragment_layout, container, false);;

        webView= (WebView) view.findViewById(R.id.webView);

        ViewGroup.LayoutParams params = webView.getLayoutParams();

        if(isMore)
        {
            params.height= ViewGroup.LayoutParams.WRAP_CONTENT;
        }

        else
        {
            params.height= dpToPx(150);

        }
        webView.loadUrl("file:///android_asset/sample.html");
        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });

        return view;

    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

}