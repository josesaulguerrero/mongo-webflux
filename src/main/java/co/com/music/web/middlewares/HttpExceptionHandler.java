package co.com.music.web.middlewares;

import co.com.music.infrastructure.exception.HttpException;
import co.com.music.infrastructure.exception.models.HttpExceptionModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
@Slf4j
public class HttpExceptionHandler {
    @ExceptionHandler(value = {HttpException.class})
    public ResponseEntity<HttpExceptionModel> handleConflict(HttpException exception) {
        HttpExceptionModel responseBody = HttpExceptionModel.builder()
                .message(exception.getMessage())
                .status(exception.getHttpStatus())
                .build();

        log.error(exception.getMessage() + " ------ " + Arrays.toString(exception.getStackTrace()));
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(responseBody);
    }
}
