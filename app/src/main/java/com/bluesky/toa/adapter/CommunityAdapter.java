package com.bluesky.toa.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bluesky.toa.R;

import java.util.ArrayList;
import java.util.List;

public class CommunityAdapter  extends RecyclerView.Adapter<CommunityAdapter.CommunityViewHolder>{

    List<String> list = new ArrayList<>();

    public void update(List<String> dlist) {
        list = dlist;
    }
    @NonNull
    @Override
    public CommunityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_clubs, parent, false);

        return new CommunityViewHolder(v);     }

    @Override
    public void onBindViewHolder(@NonNull CommunityViewHolder holder, int position) {
        holder.onBind(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CommunityViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;

        public CommunityViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title_item_club);
        }

        void onBind(int i) {
            tv_title.setText(list.get(i));
        }
    }
}
