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

import com.example.hasee.weather.db.Updata;
import com.example.hasee.weather.db.userinfo;

import org.litepal.crud.DataSupport;

import java.util.List;

public class SetFragment extends Fragment implements View.OnClickListener {

    private Button backbutton;
    private Button button_log;
    private Button button_updata;
    private List<userinfo> userinfos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.set, container, false);
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
        userinfos = DataSupport.findAll(userinfo.class);
        switch (v.getId()) {
            case R.id.back_button:
                Intent intent_back = new Intent(getContext(), MainActivity.class);
                startActivity(intent_back);
                break;
            case R.id.button_log:
                Intent intent_log = new Intent(getContext(), LoginActivity.class);
                startActivity(intent_log);
                break;
            case R.id.button_update:
                int i = 0;
                for(userinfo userinfo:userinfos) {
                    if(userinfo.getState().equals("in")) {
                        Intent intent_updata = new Intent(getContext(), UpdataActivity.class);
                        startActivity(intent_updata);
                    }
                    i++;
                }
                if(i == userinfos.size()) {
                    Toast.makeText(getContext(), "请先登陆!", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
