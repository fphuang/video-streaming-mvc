package io.coyote.vs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;


@ResponseStatus(value = HttpStatus.CONFLICT, reason="A video with this name already exists")
public class VideoAlreadyExistsException extends RuntimeException {
}
