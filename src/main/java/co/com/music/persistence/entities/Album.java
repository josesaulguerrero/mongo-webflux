package co.com.music.persistence.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder(toBuilder = true)
@Document(collection = "albums")
public class Album {
    @Id
    private String albumId;
    private String name;
    private String artist;
    private LocalDate releaseYear;
}
