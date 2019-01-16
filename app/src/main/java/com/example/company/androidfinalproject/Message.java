package com.example.company.androidfinalproject;

public class Message {
    private int messageId;
    private String content;

    public Message(int messageId, String content) {
        this.messageId = messageId;
        this.content = content;
    }


    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}