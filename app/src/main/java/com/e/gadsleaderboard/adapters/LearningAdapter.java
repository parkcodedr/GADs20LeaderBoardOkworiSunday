package com.e.gadsleaderboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.e.gadsleaderboard.R;
import com.e.gadsleaderboard.model.User;

import java.util.List;

public class LearningAdapter extends RecyclerView.Adapter<LearningAdapter.MyViewHolder> {
    private Context context;
    private List<User> user;
    RequestOptions options;

    public LearningAdapter(Context context, List<User> user) {
        this.context = context;
        this.user = user;
        options = new RequestOptions()
                .fitCenterTransform()
                .transform(new RoundedCorners(5))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error2);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater =LayoutInflater.from(context);
        view = inflater.inflate(R.layout.recyclerview_row,parent,false);
        return new MyViewHolder(view,context,user);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(user.get(position).getName());
        holder.hour.setText(user.get(position).getHour_skill()+ " Learning Hour");
        holder.country.setText(user.get(position).getCountry());
        Glide.with(context).load(user.get(position).getImg_url()).apply(options).into(holder.user_image);

    }

    @Override
    public int getItemCount() {
        return user.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,hour,country;
        ImageView user_image;
        Context context;
        List<User> user;

        public MyViewHolder(@NonNull View itemView,Context context,List<User> user) {
            super(itemView);
            name = itemView.findViewById(R.id.user_name);
            country = itemView.findViewById(R.id.country);
            hour = itemView.findViewById(R.id.hour);
            user_image = itemView.findViewById(R.id.user_image);
            this.context = context;
            this.user = user;

        }
    }
}
