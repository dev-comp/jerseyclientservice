package com.client.service2;

/**
 * Created by a.bogdanov on 09.09.2016. <br>
 * �������� ������ ������������� ����� �� ������������. <br>
 * ���������� �������� ������ �� ����
 */
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Timestamp;
import java.util.Date;

@Path("/testbot")
public class TestBotService {

  /**
   * ���������� ��� ���� <br>
   * @param incMessage �������� ��������� �� ���� MsgObject
   * @return message ��������� ��������� ���� MsgObject
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
  @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
  public Response postMessage(MsgObject incMessage) {
    String responseText;
    if (incMessage.msgBody.trim().equals("/start")) {
      responseText = "Hello! I`m echo toast bot. Lets drink for us dear " + incMessage.userObject.userName + "  \uD83C\uDF7B";
    }
    else if (incMessage.msgBody.trim().equals("/help")) {
      responseText = "I` can speak toast, just type something.";
    }
    else {
      responseText = "Lets drink for \"" + incMessage.msgBody + "\"" + "  \uD83C\uDF7B";
    }

    // ��������� �������� ���������
    MsgObject outMessage = new MsgObject(incMessage.userObject, "@BftDevCompEchoServiceBot: " + responseText);

    /*
      todo@doc ���� ����� ����� ����������� �� ��������� ��� ������ ��� ��������� ������
      /help
      /orders
      /order#12345 ����������� �����
     */

    // ��������� ��� ��������� ������� � ��������� ���������
    TestStorage.incomingMessages.put(new Timestamp(new Date().getTime()), incMessage);
    return Response.status(200).entity(outMessage).build();
  }


/*
  ������ ������
  @GET
  @Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8") // ����� ��������� ��������� �������
  @Path("/{param:.+}")                                // ����� ����� � ���������� ��������
  public Response getMessage(@PathParam("param") String message) {

*/
}