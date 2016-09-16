package com.client.service2;

/**
 * Created by a.bogdanov on 15.09.2016.
 * Объект описывающий сообщение
 */
public class MsgObject {

  final ClientRecord client;
  final String msg;

  /**
   * Объект описывающий сообщений
   * @param _client клиент (объект однозначно определящий адресата)
   * @param _msg текст сообщеиня
   */
  public MsgObject(ClientRecord _client, String _msg) {
    client = _client;
    msg = _msg;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MsgObject)) return false;

    MsgObject msgObject = (MsgObject) o;

    return client.equals(msgObject.client) && msg.equals(msgObject.msg);
  }

  @Override
  public int hashCode() {
    int result = client.hashCode();
    result = 31 * result + msg.hashCode();
    return result;
  }
}
