package br.unisc.tcc_projeto;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TccProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TccProjetoApplication.class, args);
	}

	@Bean
	public Cloudinary cloudinary() {
		return new Cloudinary(ObjectUtils.asMap(
				"cloud_name", System.getenv("dajbsbnkp"),
				"api_key", System.getenv("986711538466976"),
				"api_secret", System.getenv("xP-6E4rn9V95ot3-vxLCZVZ0Y-w"),
				"secure", true
		));
	}

}