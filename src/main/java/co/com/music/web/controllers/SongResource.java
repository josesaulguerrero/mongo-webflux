package co.com.music.web.controllers;

import co.com.music.domain.dto.song.SongDetailDTO;
import co.com.music.domain.dto.song.SongSaveDTO;
import co.com.music.domain.service.ISongService;
import co.com.music.persistence.entities.Song;
import co.com.music.web.mappers.SongMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("songs")
@AllArgsConstructor
public class SongResource {
    private final ISongService songService;
    private final SongMapper songMapper;

    @GetMapping("all")
    public ResponseEntity<Flux<SongDetailDTO>> getAll() {
        Flux<SongDetailDTO> dtos = this.songService.findAll()
                .flatMap(song -> Flux.just(this.songMapper.entityToDetailDTO(song)));
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Mono<SongDetailDTO>> getById(@PathVariable("id") String id) {
        Mono<SongDetailDTO> dto = this.songService.findById(id)
                .flatMap(song -> Mono.just(this.songMapper.entityToDetailDTO(song)));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("post")
    public ResponseEntity<Mono<SongDetailDTO>> post(@RequestBody SongSaveDTO dto) {
        Song song = this.songMapper.saveDTOToEntity(dto);
        Mono<SongDetailDTO> mappedDTO = this.songService.save(song)
                .map(this.songMapper::entityToDetailDTO);
        return new ResponseEntity<>(mappedDTO, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Mono<SongDetailDTO>> put(@PathVariable("id") String id, @RequestBody SongSaveDTO dto) {
        Song song = this.songMapper.saveDTOToEntity(dto);
        song.setSongId(id);
        Mono<SongDetailDTO> mappedDTO = this.songService.update(song)
                .map(this.songMapper::entityToDetailDTO);
        return new ResponseEntity<>(mappedDTO, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Mono<SongDetailDTO>> delete(@PathVariable("id") String id) {
        Mono<SongDetailDTO> dto = this.songService.delete(id)
                .flatMap(song -> Mono.just(this.songMapper.entityToDetailDTO(song)));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
