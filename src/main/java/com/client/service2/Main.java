package com.client.service2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by a.bogdanov on 18.09.2016.
 * Для тестов на коленке
 */
public class Main {

  public static void main(String[] args) throws Exception {
    MsgObject msg  = new MsgObject(new ClientRecord("Name", "Surname"), "Some Text");
    Gson gson = new GsonBuilder()
    			//.setPrettyPrinting()
    			.create();
    String json = gson.toJson(msg);
    System.out.println(json);

    String tmp = "{\"userObject\": { \"userName\": \"Name\", \"botName\": \"Surname\" }, \"msgBody\": \"Some Text\" }";
    MsgObject msg2 = gson.fromJson(json, MsgObject.class);
  }
}
