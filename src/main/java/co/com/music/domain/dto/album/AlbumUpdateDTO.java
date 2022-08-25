package co.com.music.domain.dto.album;

import lombok.*;

import java.time.LocalDate;
import java.time.Year;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AlbumUpdateDTO extends AlbumCreationDTO {
    protected final String albumId;

    public AlbumUpdateDTO(String name, String artist, LocalDate releaseYear, String albumId) {
        super(name, artist, releaseYear);
        this.albumId = albumId;
    }
}
