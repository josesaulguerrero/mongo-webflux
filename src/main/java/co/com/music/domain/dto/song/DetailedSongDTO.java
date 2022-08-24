package co.com.music.domain.dto.song;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class DetailedSongDTO {
    private final String songId;
    private final String name;
    private final String lyricsBy;
    private final String producedBy;
    private final String arrangedBy;
    private final LocalDateTime timestamp;
}
