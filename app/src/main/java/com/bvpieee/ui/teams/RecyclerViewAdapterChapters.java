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
import com.bvpieee.adapters.ChapterPagerAdapter;

import java.util.List;

public class RecyclerViewAdapterChapters extends RecyclerView.Adapter<RecyclerViewAdapterChapters.MyViewHolderForChapterTeams> {

    Context mContext;
    List<ChapterTeamFragModel> mData;

    public RecyclerViewAdapterChapters(Context mContext, List<ChapterTeamFragModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolderForChapterTeams onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(mContext).inflate(R.layout.chapter_frag_content,parent,false);
        MyViewHolderForChapterTeams holder=new MyViewHolderForChapterTeams(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderForChapterTeams holder, int position) {
        holder.textView_chapter_name.setText(mData.get(position).getChapterName());
        holder.imageView_chapter_photo.setImageResource(mData.get(position).getChapPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolderForChapterTeams extends RecyclerView.ViewHolder {

        private TextView textView_chapter_name;
        private ImageView imageView_chapter_photo;

        public MyViewHolderForChapterTeams(@NonNull View itemView) {
            super(itemView);
            textView_chapter_name=(TextView) itemView.findViewById(R.id.tvChapName);
            imageView_chapter_photo=(ImageView) itemView.findViewById(R.id.imgChapter);


        }
    }

}
