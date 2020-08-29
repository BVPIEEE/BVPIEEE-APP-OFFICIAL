package com.bvpieee.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bvpieee.R;
import com.bvpieee.models.ChapterTeamFragModel;

import java.util.List;

public class RecyclerViewAdapterChapters extends RecyclerView.Adapter<RecyclerViewAdapterChapters.MyViewHolderForChapterTeams> {

    Context mContext;
    List<ChapterTeamFragModel> mData;
    private onChapterClickListener monclickListener;

    public RecyclerViewAdapterChapters(Context mContext, List<ChapterTeamFragModel> mData,onChapterClickListener onClickListener) {
        this.mContext = mContext;
        this.mData = mData;
        this.monclickListener = onClickListener;
    }

    @NonNull
    @Override
    public MyViewHolderForChapterTeams onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(mContext).inflate(R.layout.chapter_frag_content,parent,false);
        return new MyViewHolderForChapterTeams(view,monclickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderForChapterTeams holder, int position) {
//        holder.itemView.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.animation_recyclerview));

        holder.textView_chapter_name.setText(mData.get(position).getChapterName());
        holder.textview_chaptwr_fullform.setText(mData.get(position).getChapterFullForm());
        holder.imageView_chapter_photo.setImageResource(mData.get(position).getChapPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolderForChapterTeams extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView_chapter_name;
        private TextView textview_chaptwr_fullform;
        private ImageView imageView_chapter_photo;
        private LinearLayout memberItem;
        onChapterClickListener onClickListener;
        public MyViewHolderForChapterTeams(@NonNull View itemView, onChapterClickListener onClickListener) {
            super(itemView);
            textView_chapter_name=itemView.findViewById(R.id.tvChapName);
            textview_chaptwr_fullform=itemView.findViewById(R.id.tvChapNameFullForm);
            imageView_chapter_photo=itemView.findViewById(R.id.imgChapter);
            memberItem=itemView.findViewById(R.id.chapterCard);
            this.onClickListener=onClickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onClickListener.onChapterClick(getAbsoluteAdapterPosition());
        }
    }

    public interface onChapterClickListener {
        void onChapterClick(int position);
    }

}
