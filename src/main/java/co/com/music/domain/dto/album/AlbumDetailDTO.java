package co.com.music.domain.dto.album;

import lombok.*;


@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class AlbumDetailDTO {
    private final String albumId;
    private final String name;
    private final String artist;
    private final String releaseYear;
}