package io.coyote.vs.service;

import io.coyote.vs.data.Video;
import io.coyote.vs.exception.VideoNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    Video getVideo(String name) throws VideoNotFoundException;

    void saveVideo(MultipartFile file, String name) throws IOException;

    List<String> getAllVideoNames();
}
