package io.coyote.vs.service;

import io.coyote.vs.data.Video;
import io.coyote.vs.exception.VideoAlreadyExistsException;
import io.coyote.vs.exception.VideoNotFoundException;
import io.coyote.vs.repo.VideoRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService{
    private VideoRepo repo;


    @Override
    public Video getVideo(String name) throws VideoNotFoundException {
        if (!repo.existsByName(name)) {
            throw new VideoNotFoundException();
        }

        return repo.findByName(name);
    }

    @Override
    public void saveVideo(MultipartFile file, String name) throws IOException {
        if (repo.existsByName(name)) {
            throw new VideoAlreadyExistsException();
        }

        Video newVid = new Video(name, file.getBytes());
        repo.save(newVid);
    }

    @Override
    public List<String> getAllVideoNames() {
        return repo.getAllEntryNames();
    }
}
