package com.client.service2;

/**
 * Created by a.bogdanov on 09.09.2016.
 * Заглушка для теста. Получение списка подключенных к боту пользователей
 */

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/get")
public class TestBotHelperService {

  /**
   * Отдает тестоывй список подключенных к боту пользователей
   */
  @GET
  @Path("/clientlist")
  @Produces(MediaType.APPLICATION_JSON)
  public ArrayList<ClientRecord> getMessage() {
    return TestStorage.getTestClientList();
  }

  /**
   * Отдает либо весь, либо кусок лога после указанного времени date
   * @param date время после которого интересует лог
   * @return лог
   */
  @GET
  @Path("/incominglog/{date}")
  @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
  @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
  public Response getIncomingLog(@PathParam("date") String date) {
    return Response.status(200).entity(TestStorage.getLog(date)).build();
  }

  /**
   * Исходящее сообщение конретному пользователю мессенджера <br>
   * @param message Исходящее сообщение
   * @return String успешный ответ или текст с ошибкой
   */
  @POST
  @Path("/sendmsg")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8")
  public Response postMessage(MsgObject message) {
    String output = "Message transfered to BotService successfully";
    return Response.status(200).entity(output).build();
  }
}
