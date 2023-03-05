package contacts;

import contacts.loader.DataLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class SpringBootMVCApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMVCApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DataLoader.load();
	}
}
