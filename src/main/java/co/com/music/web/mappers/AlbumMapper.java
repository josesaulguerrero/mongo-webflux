package co.com.music.web.mappers;

import co.com.music.domain.dto.album.AlbumCreationDTO;
import co.com.music.domain.dto.album.AlbumDetailDTO;
import co.com.music.domain.dto.album.AlbumUpdateDTO;
import co.com.music.persistence.entities.Album;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlbumMapper {
    Album creationDTOToEntity(AlbumCreationDTO dto);
    Album updateDTOToEntity(AlbumUpdateDTO dto);

    AlbumDetailDTO entityToDetailDTO(Album entity);
    List<AlbumDetailDTO> entitiesToDetailDTOs(List<Album> entities);
}
