package co.com.music.web.controllers;

import co.com.music.domain.dto.album.AlbumCreationDTO;
import co.com.music.domain.dto.album.AlbumDetailDTO;
import co.com.music.domain.service.implementation.AlbumServiceImpl;
import co.com.music.persistence.entities.Album;
import co.com.music.web.mappers.AlbumMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("albums")
@AllArgsConstructor
public class AlbumController {
    private final AlbumServiceImpl albumService;
    private final AlbumMapper albumMapper;

    @GetMapping("all")
    public ResponseEntity<Flux<AlbumDetailDTO>> getAll() {
        Flux<AlbumDetailDTO> dtos = this.albumService.findAll()
                .flatMap(album -> Flux.just(this.albumMapper.entityToDetailDTO(album)));
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Mono<AlbumDetailDTO>> getById(@PathVariable("id") String id) {
        Mono<AlbumDetailDTO> dto = this.albumService.findById(id)
                .flatMap(album -> Mono.just(this.albumMapper.entityToDetailDTO(album)));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("post")
    public ResponseEntity<Mono<AlbumDetailDTO>> post(@RequestBody AlbumCreationDTO dto) {
        Album album = this.albumMapper.creationDTOToEntity(dto);
        Mono<AlbumDetailDTO> mappedDTO = this.albumService.save(album)
                .map(this.albumMapper::entityToDetailDTO);
        return new ResponseEntity<>(mappedDTO, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Mono<AlbumDetailDTO>> put(@PathVariable("id") String id, @RequestBody AlbumCreationDTO dto) {
        Album album = this.albumMapper.creationDTOToEntity(dto);
        album.setAlbumId(id);
        Mono<AlbumDetailDTO> mappedDTO = this.albumService.update(album)
                .map(this.albumMapper::entityToDetailDTO);
        return new ResponseEntity<>(mappedDTO, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Mono<AlbumDetailDTO>> delete(@PathVariable("id") String id) {
        Mono<AlbumDetailDTO> dto = this.albumService.delete(id)
                .flatMap(album -> Mono.just(this.albumMapper.entityToDetailDTO(album)));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
