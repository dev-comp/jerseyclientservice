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
   * �������� �� ����
   * @param message �������� ��������� �� �����������
   * @return String �����
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8") // ����� ��������� ��������� �������
  @Path("/{param:.+}")                                // ����� ����� � ���������� ��������
  public Response getMessage(@PathParam("param") String message) {
    String output = "Jersey says " + message;
    /*
      todo@doc ���� ����� ����� ����������� �� ��������� ��� ������ ��� ��������� ������
      /help
      /orders
      /order#12345 ����������� �����
     */
    TestStorage.incomingMessages.put(new Timestamp(new Date().getTime()), new MsgObject(TestStorage.defUser, message));
    return Response.status(200).entity(output).build();
  }

  /**
   * ��������� ��������� ���������� ������������ ����������� <br>
   * <b>���������� ��������, �.�. ����� ���� ����� �� RESTService �������������� �����</b>
   * @param message ��������� ���������
   * @return String �������� ����� ��� ����� � �������
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8")
  public Response postMessage(MsgObject message) {
    String output = "Message send successfully";
    return Response.status(200).entity(output).build();
  }

}