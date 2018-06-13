package com.example.hasee.weather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/*import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;*/

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*import android.view.View;
import android.widget.Button;
import android.widget.Toast;*/

/*import static org.litepal.LitePalApplication.getContext;*/

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Button setButton = (Button) findViewById(R.id.button_set);
        Button nightButton = (Button) findViewById(R.id.button_night);
        setButton.setOnClickListener(this);
        nightButton.setOnClickListener(this);*/

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getString("weather", null) != null) {
            Intent intent = new Intent(this, WeatherActivity.class);
            startActivity(intent);
            finish();
        }
    }

    /*@Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_set:
                replaceFragment(new SetFragment());
                break;
            case R.id.button_night:
                Toast.makeText(getContext(),"点击按钮",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.choose_area_fragment,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }*/

}