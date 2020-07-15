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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bvpieee.R;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapterCoreTeam extends RecyclerView.Adapter<RecyclerViewAdapterCoreTeam.MyViewHolder> {

    Context mContext;
    List<TeamFragModelClass>mData;
    Dialog memberDialog;

    public RecyclerViewAdapterCoreTeam(Context mContext, List<TeamFragModelClass> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(mContext).inflate(R.layout.coreteam_frag_content,parent,false);
        final MyViewHolder holder=new MyViewHolder(view);

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
                memberDialog.show();
//                Toast.makeText(mContext,"Test Click" + String.valueOf(holder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView_name.setText(mData.get(position).getName());
        holder.textView_post.setText(mData.get(position).getPost());
        holder.imageView_photo.setImageResource(mData.get(position).getPhoto());
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textView_name;
        private TextView textView_post;
        private ImageView imageView_photo;
        private LinearLayout memberRvItem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            memberRvItem=(LinearLayout) itemView.findViewById(R.id.memberItem);
            textView_name=(TextView) itemView.findViewById(R.id.tvnameCore);
            textView_post=(TextView) itemView.findViewById(R.id.corePost);
            imageView_photo=(ImageView) itemView.findViewById(R.id.imgCore);

        }
    }


}
