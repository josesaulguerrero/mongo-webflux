package co.com.music.domain.service;

import co.com.music.domain.dto.album.CreateAlbumDTO;
import co.com.music.domain.dto.album.UpdateAlbumDTO;
import co.com.music.persistence.entities.Album;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAlbumService {
    Flux<Album> findAll();
    Mono<Album> findById(String id);
    Mono<Album> save(CreateAlbumDTO albumDTO);
    Mono<Album> update(UpdateAlbumDTO albumDTO);
    Mono<Album> delete(String id);
}
