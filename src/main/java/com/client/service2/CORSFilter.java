package com.client.service2;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

import javax.ws.rs.ext.Provider;

/**
 * Created by a.bogdanov on 21.09.2016.
 * Поддержим работу CORS (Cross-origin resource sharing)
 */
@Provider
public class CORSFilter implements ContainerResponseFilter {

    @Override
    public ContainerResponse filter(ContainerRequest req, ContainerResponse resp) {
      resp.getHttpHeaders().putSingle("Access-Control-Allow-Origin", "*");
      resp.getHttpHeaders().putSingle("Access-Control-Allow-Credentials", "true");
      resp.getHttpHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
      resp.getHttpHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
      return resp;
    }
}
