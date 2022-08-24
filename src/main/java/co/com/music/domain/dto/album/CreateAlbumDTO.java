package co.com.music.domain.dto.album;

import lombok.*;

import java.time.Year;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class CreateAlbumDTO {
    protected final String name;
    protected final String artist;
    protected final Year releaseYear;
}
