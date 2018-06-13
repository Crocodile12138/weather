package com.example.hasee.weather;

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
import android.widget.Toast;
import com.example.hasee.weather.db.userinfo;
import org.litepal.crud.DataSupport;
import java.util.List;

public class UserFragment extends Fragment implements View.OnClickListener{

   /* private TextView text_user;
    private TextView text_password;
    private TextView check;*/
    private EditText edit_user;
    private EditText edit_password;
    private CheckBox remember_pass;
    private Button button_dl;
    private Button button_zhc;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user,container,false);

       /* text_user = (TextView) view.findViewById(R.id.text_user);
        text_password = (TextView) view.findViewById(R.id.text_password);
        check = (TextView) view.findViewById(R.id.check);*/
        edit_user = (EditText) view.findViewById(R.id.edit_user);
        edit_password = (EditText) view.findViewById(R.id.edit_password);
        remember_pass = (CheckBox)view.findViewById(R.id.remember_pass);
        button_dl = (Button) view.findViewById(R.id.button_dl);
        button_zhc = (Button) view.findViewById(R.id.button_zhc);

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

        button_zhc.setOnClickListener(this);
        button_dl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String input_yhm = edit_user.getText().toString();
        String input_mm = edit_password.getText().toString();
        switch (v.getId()) {
            case R.id.button_dl:
                List<userinfo> userinfos = DataSupport.findAll(userinfo.class);
                for(userinfo userinfo:userinfos) {
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
                            replaceFragment(new ChooseAreaFragment());
                        }else {
                            Toast.makeText(getContext(),"密码错误!",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getContext(),"该用户不存在!",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.button_zhc:
                replaceFragment(new registerFragment());
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.choose_area_fragment,fragment);
        /*transaction.addToBackStack(null);*/
        transaction.commit();
    }
}
