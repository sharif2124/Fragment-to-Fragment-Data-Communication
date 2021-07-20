package com.sharif.fragmenttofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements FragmentOne.CustomListner{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ChangeFragment(View view) {
        Fragment fragment = null;
        switch (view.getId())
        {
            case R.id.bt1:
               fragment = new FragmentOne();
                break;

            case R.id.bt2:
                fragment = new FragmentTwo();
                break;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.l2,fragment);
        ft.commit();
    }


    @Override
    public void sendMessage(String text) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("MSG",text);
        FragmentTwo fragmentTwo = new FragmentTwo();
        fragmentTwo.setArguments(bundle);
        ft.replace(R.id.l2,fragmentTwo);
        ft.commit();
    }
}