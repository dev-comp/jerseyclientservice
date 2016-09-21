package com.client.service2;

/**
 * Created by a.bogdanov on 09.09.2016. <br>
 * Основной сервис обслуживающий ботов из мессенджеров. <br>
 * Фактически сожержит логику БЛ бота
 */
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Timestamp;
import java.util.Date;

@Path("/testbot")
public class TestBotService {

  /**
   * Реализация ЭХО бота <br>
   * @param incMessage Входящее сообщение дл бота MsgObject
   * @return message Исходящее сообщения типа MsgObject
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
  @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
  public Response postMessage(MsgObject incMessage) {
    String msgText = incMessage.msgBody;
    // формируем ответное сообщение
    MsgObject outMessage = new MsgObject(incMessage.userObject, "JerseyEchoBot: " + msgText);

    /*
      todo@doc если будет время реализовать на регулярка или просто так обработку команд
      /help
      /orders
      /order#12345 пятизначный заказ
     */

    // сохраняем для тестового примера в локальном хранилище
    TestStorage.incomingMessages.put(new Timestamp(new Date().getTime()), incMessage);
    return Response.status(200).entity(outMessage).build();
  }


/*
  Просто пример
  @GET
  @Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8") // чтобы нормально кириллицу отдавал
  @Path("/{param:.+}")                                // чтобы слеши в параметрах принимал
  public Response getMessage(@PathParam("param") String message) {

*/
}