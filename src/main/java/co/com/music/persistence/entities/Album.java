package co.com.music.persistence.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Year;
import java.util.List;

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
    private Year releaseYear;
    private List<Song> songs;
}
