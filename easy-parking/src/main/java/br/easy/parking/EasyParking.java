package br.easy.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Classe que implementa a lógica principal da aplicação.
 */
@SpringBootApplication
@EntityScan("br.easy.parking.repository.entity")
@EnableJpaRepositories("br.easy.parking.repository")
@EnableJpaAuditing
@EnableScheduling
public class EasyParking {
    /**
     * Lógica da main.
     * @param args Argumentos de entrada como linhas de comando.
     */
    public static void main(String[] args) {
        SpringApplication.run(EasyParking.class, args);
    }
}