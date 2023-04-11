package com.saksoft;

import com.saksoft.model.UserEntity;
import com.saksoft.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SaksoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaksoftApplication.class, args);
		System.err.println("Welcome to users pannel of saksoft");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public CommandLineRunner demoData(UserRepository repo) {
		return args -> {
			List<UserEntity> userEntities = Arrays.asList(
					UserEntity.builder().userId(1L).firstName("Raj").lastName("Verma").email("raj.verma@imagine.com").age("35").build(),
					UserEntity.builder().userId(2L).firstName("Vaibhav").lastName("Telang").email("v.telang@futureready.com").age("29").build(),
					UserEntity.builder().userId(3L).firstName("Ketan").lastName("Bahadur").email("k.bahadur@infonext.com").age("32").build(),
					UserEntity.builder().userId(4L).firstName("Abhishek").lastName("Raj").email("abhi.raj@softsol.com").age("30").build());
			repo.saveAllAndFlush(userEntities);
		};
	}
}
