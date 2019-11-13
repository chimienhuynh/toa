package com.bluesky.toa.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bluesky.toa.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {


    List<String> list = new ArrayList<>();

    public void update(List<String> dlist) {
        list = dlist;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_notification, parent, false);

        return new NotificationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tv_title;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.iv_notificationitem);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title_item_notification);
        }

        void onBind(int i) {
            tv_title.setText(list.get(i));
        }
    }
}
