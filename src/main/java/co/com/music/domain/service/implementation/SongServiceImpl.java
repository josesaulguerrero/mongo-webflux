package co.com.music.domain.service.implementation;

import co.com.music.domain.service.ISongService;
import co.com.music.infrastructure.exception.HttpException;
import co.com.music.persistence.entities.Song;
import co.com.music.persistence.repository.ISongRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SongServiceImpl implements ISongService {
    private final ISongRepository songRepository;

    @Override
    public Flux<Song> findAll() {
        return this.songRepository.findAll();
    }

    @Override
    public Mono<Song> findById(String id) {
        return this.songRepository.findById(id)
                .switchIfEmpty(
                        Mono.error(HttpException.builder()
                                .message("The Song with the given id does not exist or cannot be found.")
                                .httpStatus(HttpStatus.NOT_FOUND)
                                .build())
                );
    }

    @Override
    public Mono<Song> save(Song song) {
        song.setTimestamp(LocalDateTime.now());
        return this.songRepository.save(song);
    }

    @Override
    public Mono<Song> update(Song song) {
        return this.findById(song.getSongId())
                .map(songFromDB -> {
                    songFromDB.setName(song.getName());
                    songFromDB.setLyricsBy(song.getLyricsBy());
                    songFromDB.setArrangedBy(song.getArrangedBy());
                    songFromDB.setProducedBy(song.getProducedBy());
                    return songFromDB;
                })
                .flatMap(this.songRepository::save);
    }

    @Override
    public Mono<Song> delete(String id) {
        return this.findById(id)
                .flatMap(
                        song -> this.songRepository.delete(song)
                                .thenReturn(song)
                );
    }
}
