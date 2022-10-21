package org.example;

import examples.Greeter;
import examples.HelloReply;
import examples.HelloRequest;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import java.util.concurrent.atomic.AtomicInteger;

@GrpcService
public class GrpcExampleResource implements Greeter{

  AtomicInteger counter = new AtomicInteger();

  @Override
  public Uni<HelloReply> sayHello(HelloRequest request) {
    int count = counter.incrementAndGet();
    String name = request.getName();
    return Uni.createFrom().item("Hello " + name + request.getName444())
        .map(res -> HelloReply.newBuilder().setMessage(res).setCount(count).build());
  }
}
