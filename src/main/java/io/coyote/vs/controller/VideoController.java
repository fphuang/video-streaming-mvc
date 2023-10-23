package io.coyote.vs.controller;

import io.coyote.vs.exception.VideoNotFoundException;
import io.coyote.vs.service.VideoService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("video")
@AllArgsConstructor
public class VideoController {
    private VideoService videoService;

    @PostMapping()
    public ResponseEntity<String> saveVideo(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name
    ) throws IOException {
        videoService.saveVideo(file, name);
        return ResponseEntity
                .ok("Video saved successfully");
    }

    @GetMapping("{name}")
    public ResponseEntity<Resource> getVideoByName(@PathVariable("name") String name) throws VideoNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(videoService.getVideo(name).getData())
        );
    }

    @GetMapping("all")
    public ResponseEntity<List<String>> getAllVideoNames() {
        return ResponseEntity
                .ok(videoService.getAllVideoNames());
    }
}
