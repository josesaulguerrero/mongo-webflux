package co.com.music.domain.dto.album;

import co.com.music.domain.dto.song.SongDetailDTO;
import lombok.*;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class AlbumDetailDTO {
    private final String albumId;
    private final String name;
    private final String artist;
    private final String releaseYear;
    private final List<SongDetailDTO> songs;
}