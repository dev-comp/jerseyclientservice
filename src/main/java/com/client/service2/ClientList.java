package com.client.service2;

/**
 * Created by a.bogdanov on 09.09.2016.
 * �������� ��� �����. ��������� ������ ������������ � ���� �������������
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/get/clientlist")
public class ClientList {

  /**
   * ������ �������� ������ ������������ � ���� �������������
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public ArrayList<ClientRecord> getMessage() {
    ArrayList<ClientRecord> arr = new ArrayList<>();
    ClientRecord cli_1 = new ClientRecord("Mister", "First");
    ClientRecord cli_2 = new ClientRecord("Mister", "Second");
    ClientRecord cli_3 = new ClientRecord("Mister", "Three");
    arr.add(cli_1);
    arr.add(cli_2);
    arr.add(cli_3);
    return arr;
  }
}
