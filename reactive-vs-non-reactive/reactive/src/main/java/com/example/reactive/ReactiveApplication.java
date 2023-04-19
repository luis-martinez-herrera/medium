package com.example.reactive;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger Demo", version = "1.0", description = "Documentation APIs v1.0"))
public class ReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);
	}

}

@RestController
@RequiredArgsConstructor
class ReservationRestController {

	private final ReservationRepository reservationRepository;

	@GetMapping ("/reservations")
	Publisher<Reservation> reservationPublisher(){
		return this.reservationRepository.findAll();
	}

	@PostMapping("/reservations")
	Publisher<Reservation> reservationPublisher(@RequestBody Reservation reservation){
		return this.reservationRepository.save(reservation);
	}
}

@Component
@AllArgsConstructor
@Slf4j
class SampleDataInitializer {

	private final ReservationRepository reservationRepository;

	@EventListener (ApplicationReadyEvent.class)
	public void initialize () {
		Flux<Reservation> saved = Flux.just("John", "Doe", "Lorem", "Ipsum")
		.map(name -> new Reservation(null, name))
		.flatMap(this.reservationRepository::save);

		reservationRepository
				.deleteAll()
				.thenMany(saved)
				.thenMany(this.reservationRepository.findAll())
				.subscribe(reservation -> log.info(reservation.toString()));
	}
}

interface ReservationRepository extends ReactiveCrudRepository<Reservation, String> {

}

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
class Reservation {
	@Id
	private String id;
	private String name;
}