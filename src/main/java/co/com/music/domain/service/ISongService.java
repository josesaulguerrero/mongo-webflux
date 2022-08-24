package co.com.music.domain.service;

import co.com.music.persistence.entities.Song;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Transactional
public interface ISongService {
    Flux<Song> findAll();
    Mono<Song> findById(String id);
    Mono<Song> save(Song song);
    Mono<Song> update(Song song);
    Mono<Song> delete(String id);
}
