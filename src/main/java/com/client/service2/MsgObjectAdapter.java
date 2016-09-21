package com.client.service2;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by a.bogdanov on 15.09.2016.
 * ������ �������� ��� MsgObject, ����� ������������� ��� ������� �������� <br>
 * �� ������������
 */
@Deprecated
public class MsgObjectAdapter extends TypeAdapter<MsgObject> {

  /**
   * ����������� ������ � json
   * @param out json ������������� ������� value
   * @param value ������ ��� ������������
   * @throws IOException
   */
  @Override
  public void write(JsonWriter out, MsgObject value) throws IOException  {
    // �� �������� ������ ������
    Gson gson = new Gson();
    out.beginObject().name("userObject");
    gson.getAdapter(new TypeToken<MsgObject>() {}).write(out, value);
    out.endObject();
  }

  /**
   * ������� ������ �� json
   * @param in ���������� � ������� json
   * @return MsgObject
   */
  @Override
  public MsgObject read(JsonReader in) throws IOException {
    String msg = null, name = null, surname = null;
    in.beginObject();
    while (in.hasNext()) {
      switch (in.nextName()) {
      case "userObject":
        in.beginObject();
        while (in.hasNext()) {
          switch (in.nextName()) {
            case "userName":
              name = in.nextString();
              break;
            case "botEntryName":
              surname = in.nextString();
              break;
          }
        }
        in.endObject();
        break;
      case "msgBody":
        msg = in.nextString();
        break;
      }
    }
    in.endObject();

    ClientRecord clRec = new ClientRecord(name, surname);
    return new MsgObject(clRec, msg);
  }
}
