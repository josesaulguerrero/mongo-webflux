package co.com.music.domain.dto.song;

import lombok.*;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UpdateSongDTO extends CreateSongDTO {
    protected final String songId;

    public UpdateSongDTO(String name, String lyricsBy, String producedBy, String arrangedBy, String songId) {
        super(name, lyricsBy, producedBy, arrangedBy);
        this.songId = songId;
    }
}
