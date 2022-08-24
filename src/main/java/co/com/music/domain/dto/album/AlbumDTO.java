package co.com.music.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
public class AlbumDTO {
    private String albumId;
    private String name;
    private String artist;
    private Integer releaseYear;
    private List<SongDTO> songs;
}