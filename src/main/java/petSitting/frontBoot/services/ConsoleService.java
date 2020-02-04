package petSitting.frontBoot.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
//implements et service : déléguer gestion console à spring. => point d'entrée dans programme ici.
@Service
public class ConsoleService implements CommandLineRunner{

//	@Autowired
//	PasswordEncoder passwordEncoder;


	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello world par springBoot");
	}

	
	
}
