package com.bvpieee.ui.teams;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bvpieee.R;

import java.util.List;

public class RecyclerViewAdapterAuxillaryTeam extends RecyclerView.Adapter<RecyclerViewAdapterAuxillaryTeam.MyViewHolderAuxy> {


    Context mContext;
    List<TeamFragModelClass> mData;
    Dialog memberDialog;

    public RecyclerViewAdapterAuxillaryTeam(Context mContext, List<TeamFragModelClass> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolderAuxy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(mContext).inflate(R.layout.coreteam_frag_content,parent,false);
        final MyViewHolderAuxy holder=new MyViewHolderAuxy(view);

        memberDialog=new Dialog(mContext);
        memberDialog.setContentView(R.layout.dialog_team_member_info);
        memberDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        holder.memberRvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageView memberimg=(ImageView) memberDialog.findViewById(R.id.imgMember);
                TextView memberName=(TextView) memberDialog.findViewById(R.id.MemberName);
                TextView memberInfo=(TextView) memberDialog.findViewById(R.id.member_info);
                memberimg.setImageResource(mData.get(holder.getAdapterPosition()).getPhoto());
                memberName.setText(mData.get(holder.getAdapterPosition()).getName());
                memberInfo.setText(mData.get(holder.getAdapterPosition()).getMemberDetails());
                memberDialog.show();
//                Toast.makeText(mContext,"Test Click" + String.valueOf(holder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderAuxy holder, int position) {

        holder.textView_name.setText(mData.get(position).getName());
        holder.textView_post.setText(mData.get(position).getPost());
        holder.imageView_photo.setImageResource(mData.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolderAuxy extends RecyclerView.ViewHolder {

        private TextView textView_name;
        private TextView textView_post;
        private ImageView imageView_photo;
        private LinearLayout memberRvItem;

        public MyViewHolderAuxy(@NonNull View itemView) {
            super(itemView);
            memberRvItem=(LinearLayout) itemView.findViewById(R.id.memberItem);
            textView_name=(TextView) itemView.findViewById(R.id.tvnameCore);
            textView_post=(TextView) itemView.findViewById(R.id.corePost);
            imageView_photo=(ImageView) itemView.findViewById(R.id.imgCore);
        }
    }

}
