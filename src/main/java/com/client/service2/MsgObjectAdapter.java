package com.client.service2;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by a.bogdanov on 15.09.2016.
 * Пример адаптера для MsgObject, модет потребоваться для сложных объектов <br>
 * НЕ используется
 */
@Deprecated
public class MsgObjectAdapter extends TypeAdapter<MsgObject> {

  /**
   * Сериализует объект в json
   * @param out json представление объекта value
   * @param value объект для сериализации
   * @throws IOException
   */
  @Override
  public void write(JsonWriter out, MsgObject value) throws IOException  {
    // не проверял работу метода
    Gson gson = new Gson();
    out.beginObject().name("userObject");
    gson.getAdapter(new TypeToken<MsgObject>() {}).write(out, value);
    out.endObject();
  }

  /**
   * Создает объект из json
   * @param in переданный с клиента json
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
