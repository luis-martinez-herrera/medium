package com.example.nonreactive;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger Demo", version = "1.0", description = "Documentation APIs v1.0"))
public class NonReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(NonReactiveApplication.class, args);
	}

}

@RestController
@RequiredArgsConstructor
class ReservationRestController {

	private final ReservationRepository reservationRepository;

	@GetMapping("/reservations")
	List<Reservation> reservationPublisher(){
		return this.reservationRepository.findAll();
	}

	@PostMapping("/reservations")
	Reservation reservationPublisher(@RequestBody Reservation reservation){
		return this.reservationRepository.save(reservation);
	}
}

@Component
@AllArgsConstructor
@Slf4j
class SampleDataInitializer {

	private final ReservationRepository reservationRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void initialize () {
		reservationRepository
				.deleteAll();

		Stream.of("John", "Doe", "Lorem", "Ipsum")
				.map(name -> new Reservation(null, name))
				.forEach(this.reservationRepository::save);

		this.reservationRepository.findAll().forEach(reservation -> log.info(reservation.toString()));
	}
}

interface ReservationRepository extends MongoRepository<Reservation, String> {

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