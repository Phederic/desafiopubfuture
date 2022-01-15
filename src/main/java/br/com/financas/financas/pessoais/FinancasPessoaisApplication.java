package br.com.financas.financas.pessoais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableCaching
@EnableSpringDataWebSupport
public class FinancasPessoaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancasPessoaisApplication.class, args);
	}

}
