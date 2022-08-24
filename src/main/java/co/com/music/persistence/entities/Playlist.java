package co.com.music.persistence.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Document(collection = "playlists")
public class Playlist {
    @Id
    private String playlistId;
    private String name;
    private String username;
    private List<Song> songs;
    private Double durationInMinutes;
}
