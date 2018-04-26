package kz.kaznitu.dancer;

import kz.kaznitu.dancer.models.Club;
import kz.kaznitu.dancer.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Dancer implements CommandLineRunner {

	@Autowired
	ClubRepository clubRepository;

	public static void main(String[] args) {
		SpringApplication.run(Dancer.class, args);
	}

	@Override
	public void run(String... strings) throws Exception{
        Club club1 = new Club();
        club1.setFullName("Восточные танцы");
        club1.setLeague("Kazakhstan");

        Club club2 = new Club();
        club2.setFullName("Корейские танцы");
        club2.setLeague("Korea");

        clubRepository.save(club1);
        clubRepository.save(club2);

	}
}
