package com.client.service2;

/**
 * Created by a.bogdanov on 15.09.2016.
 * ������ ����������� ���������
 */
public class MsgObject {

  final ClientRecord userObject;
  final String msgBody;

  /**
   * ������ ����������� ���������
   * @param _client ������ (������ ���������� ����������� ��������)
   * @param _msgBody ����� ���������
   */
  public MsgObject(ClientRecord _client, String _msgBody) {
    userObject = _client;
    msgBody = _msgBody;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MsgObject)) return false;

    MsgObject msgObject = (MsgObject) o;

    return userObject.equals(msgObject.userObject) && msgBody.equals(msgObject.msgBody);
  }

  @Override
  public int hashCode() {
    int result = userObject.hashCode();
    result = 31 * result + msgBody.hashCode();
    return result;
  }
}
