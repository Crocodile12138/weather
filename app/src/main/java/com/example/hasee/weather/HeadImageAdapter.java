package com.example.hasee.weather;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class HeadImageAdapter extends RecyclerView.Adapter<HeadImageAdapter.ViewHolder> {
    private List<HeadImage> mHeadImageList;

    private int selectedPosition = 0;

    public  int getSelectedPosition() {
        return selectedPosition;
    }

   public int getImageId(int position){
       return mHeadImageList.get(position).getImageId();
   }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView headImage;
        View headView;

        public ViewHolder(View view) {
            super(view);
            headView = view;
            headImage = (ImageView) view.findViewById(R.id.head_image);

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
                selectedPosition = position;
                /*Log.d("MYTAG","position = "+ position);*/
               /* Bitmap head = BitmapFactory.decodeResource(null,headImage.getImageId());
                byte[] images = Utility.img(head);*/

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position) {
        HeadImage headImage = mHeadImageList.get(position);
        /*holder.headImage.setImageResource(headImage.getImageId());*/
        holder.headView.setBackgroundResource(headImage.getImageId());
        Log.d("MYTAG","onbind position = "+ position);
    }

    @Override
    public int getItemCount() {
        return mHeadImageList.size();
    }
}
