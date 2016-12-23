package eu.webdude.cardealership;

import eu.webdude.cardealership.service.DatabaseSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarDealershipApplication implements CommandLineRunner {

	private final DatabaseSeed databaseSeed;

	@Autowired
	public CarDealershipApplication(DatabaseSeed databaseSeed) {
		this.databaseSeed = databaseSeed;
	}

	public static void main(String[] args) {
		SpringApplication.run(CarDealershipApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		databaseSeed.seed();
	}
}
