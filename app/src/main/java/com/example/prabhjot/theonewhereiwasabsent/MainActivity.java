package com.example.prabhjot.theonewhereiwasabsent;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean isMore=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button= (Button) findViewById(R.id.more);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MyFragment fragment = new MyFragment();
        fragmentTransaction.add(R.id.content_frame, fragment);

        Bundle bundle = new Bundle();
        bundle.putBoolean("val", isMore);
        fragment.setArguments(bundle);
        fragmentTransaction.commit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager newFragmentManager = getSupportFragmentManager();
                FragmentTransaction newFragmentTransaction = newFragmentManager.beginTransaction();
                MyFragment newFragment= new MyFragment();

                isMore=!isMore;
                Bundle newBundle = new Bundle();
                newBundle.putBoolean("val", isMore);
                newFragment.setArguments(newBundle);

                newFragmentTransaction.replace(R.id.content_frame, newFragment);
                newFragmentTransaction.commit();

                if(isMore)
                {
                    button.setText("LESS");
                }
                else
                {
                    button.setText("MORE");
                }
            }
        });
    }
}
