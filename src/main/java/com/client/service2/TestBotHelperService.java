package com.client.service2;

/**
 * Created by a.bogdanov on 09.09.2016.
 * �������� ��� �����. ��������� ������ ������������ � ���� �������������
 */

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/get")
public class TestBotHelperService {

  /**
   * ������ �������� ������ ������������ � ���� �������������
   */
  @GET
  @Path("/clientlist")
  @Produces(MediaType.APPLICATION_JSON)
  public ArrayList<ClientRecord> getMessage() {
    return TestStorage.getTestClientList();
  }

  /**
   * ������ ���� ����, ���� ����� ���� ����� ���������� ������� date
   * @param date ����� ����� �������� ���������� ���
   * @return ���
   */
  @GET
  @Path("/incominglog/{date}")
  @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
  @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
  public Response getIncomingLog(@PathParam("date") String date) {
    return Response.status(200).entity(TestStorage.getLog(date)).build();
  }

  /**
   * ��������� ��������� ���������� ������������ ����������� <br>
   * @param message ��������� ���������
   * @return String �������� ����� ��� ����� � �������
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
