package com.bvpieee.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
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

public class RecyclerViewAdapterSigs extends RecyclerView.Adapter<RecyclerViewAdapterSigs.MyViewHolderSigs> {


    Context mContext;
    List<TeamFragModelClass> mData;
    Dialog memberDialog;

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
    public void onBindViewHolder(@NonNull MyViewHolderSigs holder, int position) {
        holder.itemView.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.animation_recyclerview));
        holder.textView_name.setText(mData.get(position).getName());
        holder.textView_post.setText(mData.get(position).getPost());

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

//        holder.imageView_photo.setImageResource(mData.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolderSigs extends RecyclerView.ViewHolder {

        private TextView textView_name;
        private TextView textView_post;
        private ImageButton linkedIn;
        private LinearLayout memberRvItem;
//        private ImageView imageView_photo;


        public MyViewHolderSigs(@NonNull View itemView) {
            super(itemView);

            memberRvItem=(LinearLayout) itemView.findViewById(R.id.memberItem);
            textView_name=(TextView) itemView.findViewById(R.id.tvnameCore);
            textView_post=(TextView) itemView.findViewById(R.id.corePost);
            linkedIn=itemView.findViewById(R.id.linkedin_img_btn);
//            imageView_photo=(ImageView) itemView.findViewById(R.id.img);

        }
    }

}
