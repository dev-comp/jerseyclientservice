package com.client.service2;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by a.bogdanov on 18.09.2016.
 * ƒанные дл€ локальной проверки
 */
public class TestStorage {

  public static TreeMap<Timestamp, MsgObject> incomingMessages = new TreeMap<>();
  public static ClientRecord defUser = new ClientRecord("Default", "User");

  /**
   * ѕолучить список зарегистрированных на основном сервисе пользователей
   * @return список
   */
  public static ArrayList<ClientRecord> getTestClientList() {
    ArrayList<ClientRecord> arr = new ArrayList<>();
    ClientRecord cli_1 = new ClientRecord("ћистер", "First");
    ClientRecord cli_2 = new ClientRecord("Mister", "Second");
    ClientRecord cli_3 = new ClientRecord("Mister", "Three");
    arr.add(cli_1);
    arr.add(cli_2);
    arr.add(cli_3);
    return arr;
  }

  /**
   * ¬озвращает кусок лога после указанного времени date
   * @param date врем€ запроса лога
   * @return кусок лога
   */
  public static TreeMap<Timestamp, MsgObject> getLog(String date) {
    if ("all".equals(date))
      return incomingMessages;

    // todo@doc тут моут быть засады с датами, но пока так
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    Date requestDate;
    try {
      requestDate = dateFormat.parse(date.replaceAll("\"", "").replaceAll("Z", ""));
    } catch (ParseException e) {
      throw new IllegalArgumentException(e);
    }
    TreeMap<Timestamp, MsgObject> deltaLog = new TreeMap<>();
    for (Map.Entry<Timestamp, MsgObject> en : incomingMessages.entrySet()) {
      if (en.getKey().compareTo(requestDate) >= 0) {
        deltaLog.put(en.getKey(), en.getValue());
      }
    }
    return deltaLog;
  }

}