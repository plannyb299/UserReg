package com.example.userregistration.email;

public interface EmailSender {
    void send(String to, String email);
    String buildEmail(String name, String url);
}
