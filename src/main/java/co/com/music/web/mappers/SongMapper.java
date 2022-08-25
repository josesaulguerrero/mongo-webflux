package co.com.music.web.mappers;

import co.com.music.domain.dto.song.SongDetailDTO;
import co.com.music.domain.dto.song.SongSaveDTO;
import co.com.music.persistence.entities.Song;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SongMapper {
    Song saveDTOToEntity(SongSaveDTO dto);

    SongDetailDTO entityToDetailDTO(Song entity);
    List<SongDetailDTO> entitiesToDetailDTOs(List<Song> entities);
}
