package co.com.music.domain.dto.playlist;

import co.com.music.domain.dto.song.SongDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
public class PlaylistDTO {
    private String playlistId;
    private String name;
    private String username;
    private List<SongDTO> songs;
    private Double duration;
}

