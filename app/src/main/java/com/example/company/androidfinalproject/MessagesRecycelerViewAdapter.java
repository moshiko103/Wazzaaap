package com.example.company.androidfinalproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.List;


public class MessagesRecycelerViewAdapter  extends RecyclerView.Adapter<View_Holder> {

    boolean flag=false;
    List<Message> list;
    Context context;
    OnItemClickListener myListener;

    public interface OnItemClickListener {           /////////   interface   ////////////
        void onItemClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        myListener = listener;
    }

    public MessagesRecycelerViewAdapter(List<Message> list, Context context) {        //   constructor
        this.list = list;
        this.context = context;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v;
        if (flag)
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.left_message_row_layout, parent, false);
        else
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.right_message_row_layout, parent, false);

        View_Holder holder = new View_Holder(v, myListener);
        flag=!flag;
        return holder;
    }

    @Override
    public void onBindViewHolder(View_Holder holder, int position) {
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        // holder.productName.setText(list.get(position).name);
        String s=MainActivity.messages.get(position).getContent()+position;
        holder.message.setText(s);
    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Message data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Message data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

    public void animate(RecyclerView.ViewHolder viewHolder) {
        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.bounce_interpolator);
        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
    }
}

/////////////////////////////////////////    here is the View Holder class    /////////////////////////////////////////////////////


    class View_Holder extends RecyclerView.ViewHolder {


        TextView message;

        View_Holder(View itemView, final MessagesRecycelerViewAdapter.OnItemClickListener listener) {
            super(itemView);
            message = itemView.findViewById(R.id.message_text);
            // productName =  itemView.findViewById(R.id.productName);
            //productDescription =  itemView.findViewById(R.id.productDescription);
            // imageView =  itemView.findViewById(R.id.product_image);
            // deleteImage= itemView.findViewById(R.id.image_delete);

        }
    }
