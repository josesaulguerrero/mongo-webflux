package co.com.music.domain.service.implementation;

import co.com.music.domain.dto.album.CreateAlbumDTO;
import co.com.music.domain.dto.album.UpdateAlbumDTO;
import co.com.music.persistence.entities.Album;
import co.com.music.domain.service.IAlbumService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlbumServiceImpl implements IAlbumService {
    @Override
    public Flux<Album> findAll() {
        return null;
    }

    @Override
    public Mono<Album> findById(String id) {
        return null;
    }

    @Override
    public Mono<Album> save(CreateAlbumDTO albumDTO) {
        return null;
    }

    @Override
    public Mono<Album> update(UpdateAlbumDTO albumDTO) {
        return null;
    }

    @Override
    public Mono<Album> delete(String id) {
        return null;
    }
}
