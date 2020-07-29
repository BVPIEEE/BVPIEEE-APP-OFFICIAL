package com.bvpieee.ui.teams;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bvpieee.R;

import java.util.List;

public class RecyclerViewAdapterSigs extends RecyclerView.Adapter<RecyclerViewAdapterSigs.MyViewHolderSigs> {


    Context mContext;
    List<TeamFragModelClass> mData;

    public RecyclerViewAdapterSigs (Context mContext,List<TeamFragModelClass> mData){
        this.mContext=mContext;
        this.mData=mData;
    }


    @NonNull
    @Override
    public MyViewHolderSigs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(mContext).inflate(R.layout.coreteam_frag_content,parent,false);
        MyViewHolderSigs holder=new MyViewHolderSigs(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderSigs holder, int position) {
        holder.textView_name.setText(mData.get(position).getName());
        holder.textView_post.setText(mData.get(position).getPost());
//        holder.imageView_photo.setImageResource(mData.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolderSigs extends RecyclerView.ViewHolder {

        private TextView textView_name;
        private TextView textView_post;
//        private ImageView imageView_photo;


        public MyViewHolderSigs(@NonNull View itemView) {
            super(itemView);

            textView_name=(TextView) itemView.findViewById(R.id.tvnameCore);
            textView_post=(TextView) itemView.findViewById(R.id.corePost);
//            imageView_photo=(ImageView) itemView.findViewById(R.id.imgCore);

        }
    }

}
