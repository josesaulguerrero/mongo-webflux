package co.com.music.infrastructure.exception.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@AllArgsConstructor
public class HttpExceptionModel {
    private final String message;
    private final HttpStatus status;
}
