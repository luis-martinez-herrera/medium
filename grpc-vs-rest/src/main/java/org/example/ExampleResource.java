package org.example;

import java.util.concurrent.atomic.AtomicInteger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    AtomicInteger counter = new AtomicInteger();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        int count = counter.incrementAndGet();

        return "Hello from RESTEasy Reactive, call number: " + count;
    }
}