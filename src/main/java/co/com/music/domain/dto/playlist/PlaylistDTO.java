package co.com.music.domain.dto.playlist;

import co.com.music.domain.dto.song.DetailedSongDTO;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlaylistDTO {
    private String playlistId;
    private String name;
    private String username;
    private List<DetailedSongDTO> songs;
    private Double duration;
}

