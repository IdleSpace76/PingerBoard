package dev.pingerboard.model;

import dev.pingerboard.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long server_id;

    @Column(unique = true)
    @NotEmpty(message = "IP Address must not be empty")
    private String ipAddress;

    private String name;
    private String type;
    private String imageUrl;
    private Status status;
}
