package co.com.music.domain.service.implementation;

import co.com.music.infrastructure.exception.HttpException;
import co.com.music.persistence.entities.Album;
import co.com.music.domain.service.IAlbumService;
import co.com.music.persistence.repository.IAlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
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
        return this.albumRepository.save(album);
    }

    @Override
    public Mono<Album> delete(String id) {
        return this.findById(id)
                .doOnNext(this.albumRepository::delete);
    }
}
