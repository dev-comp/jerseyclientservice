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
   * Релизует БЛ бота
   * @param message входящее сообщение от мессенджера
   * @return String ответ
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8") // чтобы нормально кириллицу отдавал
  @Path("/{param:.+}")                                // чтобы слеши в параметрах принимал
  public Response getMessage(@PathParam("param") String message) {
    String output = "Jersey says " + message;
    /*
      todo@doc если будет время реализовать на регулярка или просто так обработку команд
      /help
      /orders
      /order#12345 пятизначный заказ
     */
    TestStorage.incomingMessages.put(new Timestamp(new Date().getTime()), new MsgObject(TestStorage.defUser, message));
    return Response.status(200).entity(output).build();
  }

  /**
   * Исходящее сообщение конретному пользователю мессенджера <br>
   * <b>Фактически заглушка, т.к. проще идти сразу на RESTService регистрирующий ботов</b>
   * @param message Исходящее сообщение
   * @return String успешный ответ или текст с ошибкой
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8")
  public Response postMessage(MsgObject message) {
    String output = "Message send successfully";
    return Response.status(200).entity(output).build();
  }

}