package com.example.hasee.weather;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hasee.weather.db.userinfo;
import com.example.hasee.weather.util.Utility;

import java.util.List;

import static org.litepal.LitePalApplication.getContext;

public class HeadImageAdapter extends RecyclerView.Adapter<HeadImageAdapter.ViewHolder> {
    private List<HeadImage> mHeadImageList;
    private ImageView imageView;
    private TextView textView;
   /* private int selectedPosition = 0;

    public  int getSelectedPosition() {
        return selectedPosition;
    }*/

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView headImage;
        View headView;

        public ViewHolder(View view) {
            super(view);
            headView = view;
            headImage = (ImageView) view.findViewById(R.id.head_image);
            imageView = (ImageView) view.findViewById(R.id.head);
            textView = (TextView) view.findViewById(R.id.position);
        }
    }

    public HeadImageAdapter(List<HeadImage> headImageList) {
        mHeadImageList = headImageList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.headimage_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.headImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
               /* selectedPosition = position;*/
                HeadImage headImage = mHeadImageList.get(position);
               /* Toast.makeText(getContext(),"点击按钮",Toast.LENGTH_SHORT).show();*/
                /*headImage.setPosition(position);*/
                /*Head head = new Head(position);*/
                imageView.setImageResource(headImage.getImageId());
                textView.setText(position);
               /* Bitmap head = BitmapFactory.decodeResource(null,headImage.getImageId());
                byte[] images = Utility.img(head);*/

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position) {
        HeadImage headImage = mHeadImageList.get(position);
        holder.headImage.setImageResource(headImage.getImageId());
    }

    @Override
    public int getItemCount() {
        return mHeadImageList.size();
    }
}
