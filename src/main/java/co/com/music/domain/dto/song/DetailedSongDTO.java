package co.com.music.domain.dto.song;

import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetailedSongDTO {
    private String songId;
    private String name;
    private String lyricsBy;
    private String producedBy;
    private String arrangedBy;
    private LocalDateTime timestamp;
}
