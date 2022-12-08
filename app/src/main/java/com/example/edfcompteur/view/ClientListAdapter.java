package com.example.edfcompteur.view;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.example.edfcompteur.controleur.UpdateClient;
import com.example.edfcompteur.model.Client;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ClientListAdapter extends ListAdapter<Client, ClientViewHolder> {
    public ClientListAdapter (@NonNull DiffUtil.ItemCallback<Client> diffCallback) { super(diffCallback);
    }
    @NotNull
    @Override
    public ClientViewHolder onCreateViewHolder (@NotNull ViewGroup parent, int viewType)
    {
        return ClientViewHolder.create(parent);
    }
    @Override
    public void onBindViewHolder (@NonNull ClientViewHolder holder, int position) { Client current = getItem(position);
        holder.bind(current.getIdClient(), current.getNom(), current.getPrenom());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent UpdateClient = new Intent(v.getContext(), UpdateClient.class);
                UpdateClient.putExtra("idClient", current.getIdClient());
                UpdateClient.putExtra("nomClient", current.getNom());
                UpdateClient.putExtra("prenomClient", current.getPrenom());
                v.getContext().startActivity(UpdateClient);
            }
        });
    }


    public static class ClientDiff extends DiffUtil.ItemCallback<Client> {
        @Override
        public boolean areItemsTheSame (@NonNull Client oldItem, @NonNull Client newItem) {
            return oldItem == newItem;
        }
        @Override
        public boolean areContentsTheSame (@NonNull Client oldItem, @NonNull Client newItem) {
            return Objects.equals(oldItem.getIdClient(), newItem.getIdClient());
        }
    }
}
