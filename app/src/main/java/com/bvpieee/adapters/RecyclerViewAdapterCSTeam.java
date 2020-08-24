package com.bvpieee.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bvpieee.R;
import com.bvpieee.models.TeamFragModelClass;

import java.util.List;

public class RecyclerViewAdapterCSTeam extends RecyclerView.Adapter<RecyclerViewAdapterCSTeam.CSViewHolder> {

    Context mContext;
    List<TeamFragModelClass> mData;
    Dialog memberDialog;


    public RecyclerViewAdapterCSTeam(Context mContext, List<TeamFragModelClass> mData){
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public CSViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(mContext).inflate(R.layout.coreteam_frag_content,parent,false);
        final CSViewHolder holder=new CSViewHolder(view);

        memberDialog=new Dialog(mContext);
        memberDialog.setContentView(R.layout.dialog_team_member_info);
        memberDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        holder.memberRvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageView memberimg= memberDialog.findViewById(R.id.imgMember);
                TextView memberName=memberDialog.findViewById(R.id.MemberName);
                TextView memberInfo=memberDialog.findViewById(R.id.member_info);
                TextView closeDialog=memberDialog.findViewById(R.id.closedialog);
                memberimg.setImageResource(mData.get(holder.getAdapterPosition()).getPhoto());
                memberName.setText(mData.get(holder.getAdapterPosition()).getName());
                memberInfo.setText(mData.get(holder.getAdapterPosition()).getMemberDetails());
                memberDialog.show();
//                Toast.makeText(mContext,"Test Click" + String.valueOf(holder.getAdapterPosition()),Toast.LENGTH_SHORT).show();

                closeDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        memberDialog.dismiss();
                    }
                });

            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterCSTeam.CSViewHolder holder, int position) {
        holder.itemView.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.animation_recyclerview));


        holder.name.setText(mData.get(position).getName());
        holder.post.setText(mData.get(position).getPost());
//        holder.imageView_photo.setImageResource(mData.get(holder.getAdapterPosition()).getPhoto());
        Uri url;
        url= Uri.parse(mData.get(position).getLinkedIn());

        holder.linkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW,url);
                intent.setData(url);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class CSViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView post;
//        private ImageView imageView_photo;
        private LinearLayout memberRvItem;
        private ImageButton linkedIn;

        public CSViewHolder(@NonNull View itemView) {
            super(itemView);
            memberRvItem=(LinearLayout) itemView.findViewById(R.id.memberItem);
            name=itemView.findViewById(R.id.tvnameCore);
            post=itemView.findViewById(R.id.corePost);
            linkedIn=itemView.findViewById(R.id.linkedin_img_btn);
//            imageView_photo=itemView.findViewById(R.id.img);

        }
    }



}
