package eu.webdude.cardealership;

import eu.webdude.cardealership.service.DatabaseSeed;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.inject.Inject;
import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class CarDealershipApplication extends AsyncConfigurerSupport implements CommandLineRunner {

	private final DatabaseSeed databaseSeed;

	@Inject
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

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("car-dealership-");
		executor.initialize();
		return executor;
	}
}


