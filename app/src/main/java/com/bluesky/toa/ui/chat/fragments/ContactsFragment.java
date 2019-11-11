package com.bluesky.toa.ui.chat.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bluesky.toa.R;
import com.bluesky.toa.ui.chat.adapters.ContactAdapter;
import com.bluesky.toa.ui.chat.models.Contact;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ContactsFragment extends Fragment {

    ContactAdapter adapter;
    ListView contactsView;

    public static ContactsFragment newInstance() {
        ContactsFragment fragment = new ContactsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contacts, container, false);

        contactsView = root.findViewById(R.id.contactList);

        // Dummy data
        Contact contact = new Contact();
        contact.setName("Jesmine");
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(contact);

        adapter.setList(contacts);
        contactsView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        adapter = new ContactAdapter(context);
    }
}
