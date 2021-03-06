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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bvpieee.R;
import com.bvpieee.models.TeamFragModelClass;

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
        view = LayoutInflater.from(mContext).inflate(R.layout.coreteam_frag_content, parent, false);
        final MyViewHolderAuxy holder = new MyViewHolderAuxy(view);

        memberDialog = new Dialog(mContext);
        memberDialog.setContentView(R.layout.dialog_team_member_info);
        memberDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        holder.memberRvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageView memberimg = (ImageView) memberDialog.findViewById(R.id.imgMember);
                TextView memberName = (TextView) memberDialog.findViewById(R.id.MemberName);
                TextView memberInfo = (TextView) memberDialog.findViewById(R.id.member_info);
                TextView closeDialog = memberDialog.findViewById(R.id.closedialog);

//                LinearLayout dialogLayout= memberDialog.findViewById(R.id.dialog_layout);
//
//                Random random = new Random();
//                int currentColor= Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
//                dialogLayout.setBackgroundColor(currentColor);

                memberimg.setImageResource(mData.get(holder.getAbsoluteAdapterPosition()).getPhoto());
                memberName.setText(mData.get(holder.getAbsoluteAdapterPosition()).getName());
                memberInfo.setText(mData.get(holder.getAbsoluteAdapterPosition()).getMemberDetails());
                memberDialog.show();


                closeDialog.setOnClickListener(view1 -> memberDialog.dismiss());

            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderAuxy holder, int position) {
//        holder.itemView.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.animation_recyclerview));


        holder.textView_name.setText(mData.get(position).getName());
        holder.textView_post.setText(mData.get(position).getPost());
        holder.branchAndYear.setText(mData.get(position).getBranchYear());

        Uri url;
        url = Uri.parse(mData.get(position).getLinkedIn());

        holder.linkedIn.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, url);
            intent.setPackage("com.linkedin.android");
            try{
                intent.setData(url);
                mContext.startActivity(intent);
            }
            catch (Exception e) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, url));
            }
        });

//        holder.imageView_photo.setImageResource(mData.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolderAuxy extends RecyclerView.ViewHolder {

        private TextView textView_name;
        private TextView textView_post;
        //        private ImageView imageView_photo;
        private LinearLayout memberRvItem;
        private ImageButton linkedIn;
        private TextView branchAndYear;

        public MyViewHolderAuxy(@NonNull View itemView) {
            super(itemView);
            memberRvItem = (LinearLayout) itemView.findViewById(R.id.memberItem);
            textView_name = (TextView) itemView.findViewById(R.id.tvnameCore);
            textView_post = (TextView) itemView.findViewById(R.id.corePost);
            linkedIn = (ImageButton) itemView.findViewById(R.id.linkedin_img_btn);
            branchAndYear = (TextView) itemView.findViewById(R.id.branchAndyear);
//            imageView_photo=(ImageView) itemView.findViewById(R.id.img);
        }
    }

}
