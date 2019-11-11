package com.bluesky.toa.ui.chat.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bluesky.toa.R;
import com.bluesky.toa.ui.chat.adapters.ConversationAdapter;
import com.bluesky.toa.ui.chat.models.Conversation;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ConversationsFragment extends Fragment {

    ConversationAdapter adapter;
    ListView conversationView;

    public static ConversationsFragment newInstance() {
        ConversationsFragment fragment = new ConversationsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_conversations, container, false);

        conversationView = root.findViewById(R.id.conversationList);

        // Dummy data
        Conversation conversation = new Conversation();
        conversation.setName("Jesmine");
        conversation.setLastMessage("Keep it up! You're making great progress!");
        conversation.setLastMessageTime("11:11am");
        ArrayList<Conversation> conversations = new ArrayList<>();
        conversations.add(conversation);

        adapter.setList(conversations);
        conversationView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        adapter = new ConversationAdapter(context);
    }
}
