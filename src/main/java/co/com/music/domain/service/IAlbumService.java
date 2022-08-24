package co.com.music.domain.service;

import co.com.music.persistence.entities.Album;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Transactional
public interface IAlbumService {
    Flux<Album> findAll();
    Mono<Album> findById(String id);
    Mono<Album> save(Album album);
    Mono<Album> update(Album album);
    Mono<Album> delete(String id);
}
