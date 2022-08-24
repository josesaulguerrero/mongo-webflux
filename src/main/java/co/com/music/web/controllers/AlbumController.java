package co.com.music.web.controllers;

import co.com.music.domain.dto.album.DetailedAlbumDTO;
import co.com.music.domain.service.implementation.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AlbumResource {
    @Autowired
    private AlbumServiceImpl albumService;

    //GET
    @GetMapping("/findAlbum/{id}")
    private Mono<ResponseEntity<DetailedAlbumDTO>> getAlbumById(@PathVariable String id){
        return albumService.findAlbumById(id);
    }
}
