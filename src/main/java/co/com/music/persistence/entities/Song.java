package co.com.music.persistence.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Document(collection = "songs")
public class Song {
    @Id
    private String songId;
    private String name;
    private String lyricsBy;
    private String producedBy;
    private String arrangedBy;
    private LocalDateTime timestamp;
}