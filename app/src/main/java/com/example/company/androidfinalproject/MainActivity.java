package com.example.company.androidfinalproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MessagesRecycelerViewAdapter adapter;
    RecyclerView recyclerView;
    static List<Message> messages;

    EditText message_edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message_edit_text=findViewById(R.id.message_edit_text);
        recyclerView = findViewById(R.id.recyclerview);
        createRecyclerView();
    }

    public void createRecyclerView() {

        messages = new ArrayList<>();
        adapter = new MessagesRecycelerViewAdapter(messages, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fill_with_data();    //  fill the adapter list and the static products list with all the event from database

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);

        recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v,
                                       int left, int top, int right, int bottom,
                                       int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (bottom < oldBottom) {
                    recyclerView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView.scrollToPosition(adapter.getItemCount()-1);
                        }
                    }, 100);
                }
            }
        });


    }

    public void fill_with_data() {      //  fill the adapter list and the static products list with all the event from database


    }

    public void sendBtnClicked(View view) {
        messages.add(new Message(0,message_edit_text.getText().toString()));
        recyclerView.scrollToPosition(adapter.getItemCount()-1);
        message_edit_text.setText("");
    }

}
