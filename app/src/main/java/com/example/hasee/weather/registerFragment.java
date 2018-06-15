package com.example.hasee.weather;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.hasee.weather.db.userinfo;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.valueOf;

public class registerFragment extends Fragment implements View.OnClickListener{
    private TextView textView;
    private EditText edit_yhm;
    private EditText edit_mm;
    private EditText mm_qr;
    private Button button;
    private Button backbutton;
    private RecyclerView recyclerView;
    private HeadImageAdapter adapter;
    private List<HeadImage> headimageList = new ArrayList<>();
    private ImageView head;
    private int position;
    private int ImageViewId;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register,container,false);

        edit_yhm = (EditText) view.findViewById(R.id.edit_yhm);
        edit_mm = (EditText) view.findViewById(R.id.edit_mm);
        mm_qr = (EditText) view.findViewById(R.id.mm_qr);
        button = (Button) view.findViewById(R.id.button);
        backbutton = (Button) view.findViewById(R.id.back_button);
        head = (ImageView) view.findViewById(R.id.head);

        initHeadImage();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);




        return view;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new HeadImageAdapter(headimageList);
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(this);
        backbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String input_yhm = edit_yhm.getText().toString();
        String input_mm = edit_mm.getText().toString();
        String input_qrmm = mm_qr.getText().toString();

        switch (v.getId()) {
            case R.id.back_button:
                replaceFragment(new UserFragment());
                break;
            case R.id.button:

                position = adapter.getSelectedPosition();
                textView.setText(position);

                /*int num = valueOf(position).intValue();*/
                ImageViewId = adapter.getImageId(position);
                if(input_mm.equals(input_qrmm)) {
                    userinfo userinfo = new userinfo(position);
                    userinfo.setName(input_yhm);
                    userinfo.setPassword(input_mm);
                    userinfo.setImageViewId(ImageViewId);
                    userinfo.setState("out");
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
        transaction.commit();
    }

    private void initHeadImage() {
        HeadImage headImage1 = new HeadImage(R.drawable.contact3);
        headimageList.add(headImage1);
        HeadImage headImage2 = new HeadImage(R.drawable.contact4);
        headimageList.add(headImage2);
        HeadImage headImage3 = new HeadImage(R.drawable.contact5);
        headimageList.add(headImage3);
        HeadImage headImage4 = new HeadImage(R.drawable.contact6);
        headimageList.add(headImage4);
        HeadImage headImage5 = new HeadImage(R.drawable.contact7);
        headimageList.add(headImage5);
        HeadImage headImage6 = new HeadImage(R.drawable.contact8);
        headimageList.add(headImage6);
        HeadImage headImage7 = new HeadImage(R.drawable.contact9);
        headimageList.add(headImage7);
        HeadImage headImage8 = new HeadImage(R.drawable.contact10);
        headimageList.add(headImage8);
        HeadImage headImage9 = new HeadImage(R.drawable.contact11);
        headimageList.add(headImage9);
        HeadImage headImage10 = new HeadImage(R.drawable.contact12);
        headimageList.add(headImage10);
        HeadImage headImage11 = new HeadImage(R.drawable.contact14);
        headimageList.add(headImage11);
        HeadImage headImage12 = new HeadImage(R.drawable.contact15);
        headimageList.add(headImage12);
        HeadImage headImage13 = new HeadImage(R.drawable.contact16);
        headimageList.add(headImage13);
    }

}
