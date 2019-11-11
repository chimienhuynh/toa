package com.bluesky.toa.ui.chat.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bluesky.toa.R;
import com.bluesky.toa.ui.chat.models.Contact;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {
    ArrayList<Contact> list;

    public ContactAdapter(Context ctx) {
        super(ctx, 0);
    }

    public void setList(ArrayList<Contact> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Contact getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View result = null;
        result = inflater.inflate(R.layout.contact, null);

        ImageView photo = result.findViewById(R.id.contactPhoto);
        TextView name = result.findViewById(R.id.contactName);

        name.setText(getItem(position).getName());

        return result;
    }
}
