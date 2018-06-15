package com.example.hasee.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SetFragment extends Fragment implements View.OnClickListener {

    private TextView title_set;
    private Button backbutton;
    private Button button_log;
    private Button button_updata;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.set, container, false);
        title_set = (TextView) view.findViewById(R.id.title_set);
        backbutton = (Button) view.findViewById(R.id.back_button);
        button_log = (Button) view.findViewById(R.id.button_log);
        button_updata = (Button) view.findViewById(R.id.button_update);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        backbutton.setOnClickListener(this);
        button_log.setOnClickListener(this);
        button_updata.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                /*replaceFragment(new ChooseAreaFragment(),0);*/
                Intent intent_back = new Intent(getContext(), MainActivity.class);
                startActivity(intent_back);
                /*Toast.makeText(getContext(),"点击按钮",Toast.LENGTH_SHORT).show();*/
                break;
            case R.id.button_log:
                Intent intent_log = new Intent(getContext(), LoginActivity.class);
                startActivity(intent_log);
                break;
            case R.id.button_update:
                Toast.makeText(getContext(),"点击按钮",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
