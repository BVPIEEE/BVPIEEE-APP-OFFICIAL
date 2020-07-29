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
    public void onBindViewHolder(@NonNull RecyclerViewAdapterCSTeam.CSViewHolder holder, int position) {

        holder.name.setText(mData.get(position).getName());
        holder.post.setText(mData.get(position).getPost());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class CSViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView post;
        private LinearLayout memberRvItem;

        public CSViewHolder(@NonNull View itemView) {
            super(itemView);
            memberRvItem=(LinearLayout) itemView.findViewById(R.id.memberItem);
            name=itemView.findViewById(R.id.tvnameCore);
            post=itemView.findViewById(R.id.corePost);

        }
    }

}
