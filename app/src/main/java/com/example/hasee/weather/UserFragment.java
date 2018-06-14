package com.example.hasee.weather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.hasee.weather.db.userinfo;
import org.litepal.crud.DataSupport;
import java.util.List;

public class UserFragment extends Fragment implements View.OnClickListener{

    private EditText edit_user;
    private EditText edit_password;
    private Button button_dl;
    private Button button_zhc;
    private Button backbutton;
    private Button nav_button;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;
    /*private TextView textView;*/
    private String position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user,container,false);

        edit_user = (EditText) view.findViewById(R.id.edit_user);
        edit_password = (EditText) view.findViewById(R.id.edit_password);
        rememberPass = (CheckBox)view.findViewById(R.id.remember_pass);
        backbutton = (Button) view.findViewById(R.id.back_button);
        button_dl = (Button) view.findViewById(R.id.button_dl);
        button_zhc = (Button) view.findViewById(R.id.button_zhc);
        nav_button = (Button) view.findViewById(R.id.nav_button);
        /*textView = (TextView) view.findViewById(R.id.position);*/

        pref = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean isRemember = pref.getBoolean("remember_password",false);
        if(isRemember){    //将账号密码设置到文本框中
            String account = pref.getString("account","");
            String password = pref.getString("password","");
            edit_user.setText(account);
            edit_password.setText(password);
            rememberPass.setChecked(true);
        }

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        backbutton.setOnClickListener(this);
        button_zhc.setOnClickListener(this);
        button_dl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String input_yhm = edit_user.getText().toString();
        String input_mm = edit_password.getText().toString();
        switch (v.getId()) {
            case R.id.back_button:
                replaceFragment(new SetFragment(),0);
                break;
            case R.id.button_dl:
                /*position = textView.getText().toString();*/
                /*int num = Integer.valueOf(position).intValue();*/
                List<userinfo> userinfos = DataSupport.findAll(userinfo.class);
                for(userinfo userinfo:userinfos) {
                    position = userinfo.getPosition();
                    int num = Integer.valueOf(position).intValue() + 3;
                    String str = "R.drawable." + String.valueOf(num);
                    if(userinfo.getName().equals(input_yhm)) {
                        if(userinfo.getPassword().equals(input_mm)) {
                            editor = pref.edit();
                            if(rememberPass.isChecked()) {   //检查复选框是否被选中
                                editor.putBoolean("remember_password",true);
                                editor.putString("account",input_yhm);
                                editor.putString("password",input_mm);
                            }else {
                                editor.clear();
                            }
                            editor.apply();
                            userinfo.setState("IN");
                           /* nav_button.setBackground(R.id.head);*/
                          /* nav_button.setBackgroundResource(getId());*/
                            nav_button.setBackgroundResource(Integer.parseInt(str));
                            /*replaceFragment(new ChooseAreaFragment(),0);*/
                            Intent intent_dl = new Intent(getContext(), MainActivity.class);
                            startActivity(intent_dl);
                        }else {
                            Toast.makeText(getContext(),"密码错误!",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getContext(),"该用户不存在!",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.button_zhc:
                replaceFragment(new registerFragment(),1);
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment,int i) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.choose_area_fragment,fragment);
        if(i == 1) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
