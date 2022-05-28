package org.example.itischat.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@MappedSuperclass
@Data
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
