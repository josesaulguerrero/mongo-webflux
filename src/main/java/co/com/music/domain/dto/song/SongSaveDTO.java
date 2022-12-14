package co.com.music.domain.dto.song;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class SongSaveDTO {
    protected final String name;
    protected final String lyricsBy;
    protected final String producedBy;
    protected final String arrangedBy;
}
