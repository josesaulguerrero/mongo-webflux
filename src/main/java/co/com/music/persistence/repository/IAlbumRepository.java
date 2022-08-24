package co.com.music.persistence.repository;

import co.com.music.persistence.entities.Album;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlbumRepository extends ReactiveMongoRepository<Album, String> {
}
