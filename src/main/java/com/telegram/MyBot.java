package com.telegram;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.http.request;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Map;

public class MyBot extends TelegramLongPollingBot {

//    @Override
//    public void onUpdateReceived(Update update) {
//        // TODO
//    }

    @Override
    public String getBotUsername() {
        // TODO
        return "pandavandama1_bot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "5146302938:AAGPaSLN0BvyGLLQblJNM4Fhf0-cd5X0gQo";
    }

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());


            Gson gson = new Gson();

            try {
                Map<String, Integer> test = gson.fromJson(new request().get().getBody(), new TypeToken<Map<String, Integer>>() {
                }.getType());
                System.out.println(test.size());

            } catch (UnirestException e) {
                e.printStackTrace();
            }

            message.setText("shlapa");

//            System.out.println(Integer.toString(test.keySet().size()));


            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}

