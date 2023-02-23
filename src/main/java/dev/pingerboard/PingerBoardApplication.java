package dev.pingerboard;

import dev.pingerboard.enums.Status;
import dev.pingerboard.model.Server;
import dev.pingerboard.repository.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PingerBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(PingerBoardApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ServerRepository serverRepository) {
        return args -> {
            serverRepository.save(new Server(null, "192.168.1.160", "Ubuntu Linux", "Personal PC",
                    "http://localhost:8080/server/image/server_icon1.png", Status.SERVER_UP));
            serverRepository.save(new Server(null, "192.168.1.58", "Fedora Linux", "Dell Tower",
                    "http://localhost:8080/server/image/server_icon2.png", Status.SERVER_UP));
            serverRepository.save(new Server(null, "142.250.185.238", "Google", "Server",
                    "http://localhost:8080/server/image/server_icon3.png", Status.SERVER_UP));
            serverRepository.save(new Server(null, "62.217.160.2", "Yandex (dzen)", "Server",
                    "http://localhost:8080/server/image/server_icon1.png", Status.SERVER_UP));
        };
    }

}
