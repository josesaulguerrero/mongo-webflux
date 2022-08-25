package co.com.music.domain.dto.album;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class AlbumCreationDTO {
    protected final String name;
    protected final String artist;
    protected final LocalDate releaseYear;
}
