package com.example.latihan_praktikum_7.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "messages")
public class Message {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String sender;
    private String content;
    private long timestamp;
    private String photoUri;
    private double latitude;
    private double longitude;

    // Constructor
    public Message(String sender, String content, long timestamp, String photoUri, double latitude, double longitude) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
        this.photoUri = photoUri;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    public String getPhotoUri() { return photoUri; }
    public void setPhotoUri(String photoUri) { this.photoUri = photoUri; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
}

