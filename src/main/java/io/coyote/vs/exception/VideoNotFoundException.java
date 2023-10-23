package io.coyote.vs.exception;

public class VideoNotFoundException extends Exception {
    public VideoNotFoundException() {
        super("Video Not found!");
    }
}
