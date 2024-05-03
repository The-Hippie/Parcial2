package com.example.adaptaon;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx. recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;
    final ListAdapter.OnItemClickListener listener;
    public interface OnItemClickListener{
        void OnItemClick(ListElement item);
    }

    public ListAdapter(List<ListElement> itemList, Context context, ListAdapter.OnItemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.listener=listener;

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }

    public void setItems (List<ListElement> items) { mData = items; }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageUrl;
        TextView name, pc, status;
        ViewHolder(View itemView) {
            super(itemView);
            imageUrl = itemView.findViewById(R.id.imageUrl);
            name = itemView.findViewById(R.id.nameTextView);
            pc= itemView.findViewById(R.id.pcTextView);
            status = itemView.findViewById(R.id.statusTextView);
        }
        public void bind( ListElement dato){
            name.setText(dato.getName());
            pc.setText(dato.getPc());
            status.setText(dato.getStatus());
            //imagen
            Picasso.get().load(dato.getImageurl()).into(imageUrl);
        }
        void bindData(final ListElement item) {


            name.setText(item.getName());
            pc.setText(item.getPc());
            status.setText(item.getStatus());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(item);
                }
            });
        }
    }

}