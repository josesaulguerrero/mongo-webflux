package co.com.music.domain.service.implementation;

import co.com.music.infrastructure.exception.HttpException;
import co.com.music.persistence.entities.Album;
import co.com.music.domain.service.IAlbumService;
import co.com.music.persistence.repository.IAlbumRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class AlbumServiceImpl implements IAlbumService {
    private final IAlbumRepository albumRepository;

    @Override
    public Flux<Album> findAll() {
        return this.albumRepository.findAll();
    }

    @Override
    public Mono<Album> findById(String id) {
        return this.albumRepository.findById(id)
                .switchIfEmpty(
                        Mono.error(
                                HttpException.builder()
                                        .message("The album with the given id cannot be found.")
                                        .httpStatus(HttpStatus.NOT_FOUND)
                                        .build()
                        )
                );
    }

    @Override
    public Mono<Album> save(Album album) {
        return this.albumRepository.save(album);
    }

    @Override
    public Mono<Album> update(Album album) {
        return this.findById(album.getAlbumId())
                .map(entityFromDB -> album)
                .flatMap(this.albumRepository::save);
    }

    @Override
    @Transactional
    public Mono<Album> delete(String id) {
        return this.findById(id)
                .doOnNext(
                        album -> this.albumRepository
                                .deleteById(album.getAlbumId())
                                .subscribe()
                );
    }
}
