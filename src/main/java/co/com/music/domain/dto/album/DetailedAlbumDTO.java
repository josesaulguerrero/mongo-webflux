package co.com.music.domain.dto.album;

import co.com.music.domain.dto.song.DetailedSongDTO;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetailedAlbumDTO {
    private String albumId;
    private String name;
    private String artist;
    private String releaseYear;
    private List<DetailedSongDTO> songs;
}