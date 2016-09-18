package com.client.service2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by a.bogdanov on 09.09.2016. <br>
 * Провайдер, учит сервис поддердживать сообщения в json формате
 */

@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GsonProvider<T> implements MessageBodyReader<T>, MessageBodyWriter<T> {

  private static final String PRETTY_PRINT = "pretty-print";

  private final Gson gson;
  private final Gson prettyGson;

  @Context
  private UriInfo ui;

  public GsonProvider() {
    GsonBuilder builder = new GsonBuilder()
            // todo@doc здесь можно регистрировать адаптеры для сложных объектов
            // .registerTypeAdapter(MsgObject.class, new MsgObjectAdapter())
            .serializeNulls()
            .enableComplexMapKeySerialization();

    this.gson = builder.create();
    this.prettyGson = builder.setPrettyPrinting().create();
  }

  @Override
  public boolean isReadable(Class<?> type, Type genericType,
                            Annotation[] annotations, MediaType mediaType) {
    return true;
  }

  @Override
  public T readFrom(Class<T> type, Type genericType, Annotation[] annotations,
                    MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
                    InputStream entityStream) throws IOException, WebApplicationException {

    try (InputStreamReader reader = new InputStreamReader(entityStream, "UTF-8")) {
      return gson.fromJson(reader, type);
    }
  }

  @Override
  public boolean isWriteable(Class<?> type, Type genericType,
                             Annotation[] annotations, MediaType mediaType) {
    return true;
  }

  @Override
  public long getSize(T t, Class<?> type, Type genericType,
                      Annotation[] annotations, MediaType mediaType) {
    return -1;
  }

  @Override
  public void writeTo(T t, Class<?> type, Type genericType, Annotation[] annotations,
                      MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
                      OutputStream entityStream) throws IOException, WebApplicationException {
    try (OutputStreamWriter je = new OutputStreamWriter(entityStream, "UTF-8")) {
      String json;
      if (ui.getQueryParameters().containsKey(PRETTY_PRINT)) {
        json = prettyGson.toJson(t);
      } else {
        json = gson.toJson(t);
      }
      je.write(json);
      je.flush();
    }
  }
}
