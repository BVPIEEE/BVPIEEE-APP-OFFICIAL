package com.bvpieee.adapters;

import android.content.Context;
import android.content.Intent;
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
import com.bvpieee.models.DeveloperDetailModel;

import java.util.List;

public class DeveloperDetailAdapter extends RecyclerView.Adapter<DeveloperDetailAdapter.DeveloperViewHolder> {


    Context mContext;
    List<DeveloperDetailModel> mData;

    public DeveloperDetailAdapter(Context mContext, List<DeveloperDetailModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public DeveloperDetailAdapter.DeveloperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.developer_detail_card, parent, false);
        DeveloperViewHolder holder = new DeveloperViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DeveloperDetailAdapter.DeveloperViewHolder holder, int position) {

//        holder.itemView.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.animation_recyclerview));

        holder.textView_developer_name.setText(mData.get(position).getDevelopeName());
        holder.textview_developer_post.setText(mData.get(position).getDeveloperDetails());
        holder.imageView_developer_photo.setImageResource(mData.get(position).getDeveloperPhoto());

        Uri url;
        url = Uri.parse(mData.get(position).getDeveloperLinkedin());

        holder.linkedinDeveloper.setOnClickListener(view -> {
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

        Uri email;
        email = Uri.parse(mData.get(position).getDeveloperEmail());

        holder.gmailDeveloper.setOnClickListener(view -> {
            Intent emailTheDeveloper = new Intent(Intent.ACTION_SENDTO, email);
            emailTheDeveloper.setPackage("com.google.android.gm");
            if (emailTheDeveloper.getPackage() == null) {
                emailTheDeveloper.setData(email);
                mContext.startActivity(emailTheDeveloper);
            } else {
                mContext.startActivity(Intent.createChooser(emailTheDeveloper, "Email Us"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class DeveloperViewHolder extends RecyclerView.ViewHolder {

        private TextView textView_developer_name;
        private TextView textview_developer_post;
        private ImageView imageView_developer_photo;
        private ImageButton linkedinDeveloper;
        private ImageButton gmailDeveloper;
        private LinearLayout memberItem;

        public DeveloperViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_developer_name = itemView.findViewById(R.id.tvdeveloper_name);
            textview_developer_post = itemView.findViewById(R.id.tvdeveloper_post);
            imageView_developer_photo = itemView.findViewById(R.id.developer_image);
            linkedinDeveloper = itemView.findViewById(R.id.linkein_developer);
            gmailDeveloper = itemView.findViewById(R.id.gmail_developer);
            memberItem = itemView.findViewById(R.id.developers);
        }
    }
}
