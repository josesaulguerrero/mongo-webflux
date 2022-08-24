package co.com.music.domain.service;

import co.com.music.domain.dto.AlbumDTO;
import co.com.music.persistence.entities.Album;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAlbumService {
    Mono<ResponseEntity<Flux<AlbumDTO>>> findAllAlbums();
    Mono<ResponseEntity<AlbumDTO>> findAlbumById(String id);
    Mono<ResponseEntity<AlbumDTO>> saveAlbum(AlbumDTO albumDTO);

    //ModelMapper functions
    Album DTOToEntity (AlbumDTO albumDTO);
    AlbumDTO entityToDTO(Album album);

}
