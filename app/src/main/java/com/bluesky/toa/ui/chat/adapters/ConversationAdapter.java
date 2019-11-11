package com.bluesky.toa.ui.chat.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bluesky.toa.R;
import com.bluesky.toa.ui.chat.models.Conversation;

import java.util.ArrayList;

public class ConversationAdapter extends ArrayAdapter<Conversation> {
    ArrayList<Conversation> list;

    public ConversationAdapter(Context ctx) {
        super(ctx, 0);
    }

    public void setList(ArrayList<Conversation> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Conversation getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View result = null;
        result = inflater.inflate(R.layout.conversation, null);

        ImageView photo = result.findViewById(R.id.contactPhoto);
        TextView name = result.findViewById(R.id.conversationContactName);
        TextView lastMessage = result.findViewById(R.id.conversationContactLastMessage);
        TextView lastMessageTime = result.findViewById(R.id.conversationContactLastMessageTime);

        name.setText(getItem(position).getName());
        lastMessage.setText(getItem(position).getLastMessage());
        lastMessageTime.setText(getItem(position).getLastMessageTime());

        return result;
    }
}
