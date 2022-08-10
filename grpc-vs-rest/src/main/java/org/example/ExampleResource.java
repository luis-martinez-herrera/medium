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
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        int count = counter.incrementAndGet();

        return "{\"message\": \"Hello \",\"count\": " + count + "}";
    }
}