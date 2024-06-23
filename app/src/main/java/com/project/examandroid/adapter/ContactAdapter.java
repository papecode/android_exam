package com.project.examandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.project.examandroid.R;
import com.project.examandroid.model.Contact;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<Contact> contacts = new ArrayList<>();

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact currentContact = contacts.get(position);
        holder.textViewName.setText(currentContact.getFirstName() + " " + currentContact.getLastName());
        holder.textViewEmail.setText(currentContact.getEmail());
        holder.textViewPhone.setText(currentContact.getPhone());
        Picasso.get().load(currentContact.getImage()).into(holder.imageViewProfile);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewEmail;
        private TextView textViewPhone;
        private ImageView imageViewProfile;

        public ContactViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewEmail = itemView.findViewById(R.id.text_view_email);
            textViewPhone = itemView.findViewById(R.id.text_view_phone);
            imageViewProfile = itemView.findViewById(R.id.image_view_profile);
        }
    }
}