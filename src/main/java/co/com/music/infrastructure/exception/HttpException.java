package co.com.music.infrastructure.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@ToString
public class HttpException extends RuntimeException {
    private final String message;
    private final HttpStatus httpStatus;
}
