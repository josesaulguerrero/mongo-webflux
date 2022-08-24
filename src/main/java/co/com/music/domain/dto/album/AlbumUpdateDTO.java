package co.com.music.domain.dto.album;

import lombok.*;

import java.time.Year;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AlbumUpdateDTO extends AlbumCreationDTO {
    protected final String albumId;

    public AlbumUpdateDTO(String name, String artist, Year releaseYear, String albumId) {
        super(name, artist, releaseYear);
        this.albumId = albumId;
    }
}
