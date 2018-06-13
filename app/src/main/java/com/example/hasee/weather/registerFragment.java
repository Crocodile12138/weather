package com.example.hasee.weather;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hasee.weather.db.userinfo;

public class registerFragment extends Fragment implements View.OnClickListener{
    private EditText edit_yhm;
    private EditText edit_mm;
    private EditText mm_qr;
    private Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register,container,false);

        edit_yhm = (EditText) view.findViewById(R.id.edit_yhm);
        edit_mm = (EditText) view.findViewById(R.id.edit_mm);
        mm_qr = (EditText) view.findViewById(R.id.mm_qr);
        button = (Button) view.findViewById(R.id.button);

        return view;
    }

    @Override
    public void onClick(View v) {
        String input_yhm = edit_yhm.getText().toString();
        String input_mm = edit_mm.getText().toString();
        String input_qrmm = mm_qr.getText().toString();
        switch (v.getId()) {
            case R.id.button:
                if(input_mm.equals(input_qrmm)) {
                    userinfo userinfo = new userinfo();
                    userinfo.setName(input_yhm);
                    userinfo.setPassword(input_mm);
                    userinfo.save();
                    replaceFragment(new UserFragment());
                }else {
                    Toast.makeText(getContext(),"两次输入密码不同!",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.choose_area_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
