package culturemedia.controllers;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewsRepositoryImpl;
import culturemedia.service.CulturemediaService;
import culturemedia.service.impl.CultureMediaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class CultureMediaController {

    private final CulturemediaService cultureMediaService;

    public CultureMediaController() {
        this.cultureMediaService = new CultureMediaServiceImpl(new VideoRepositoryImpl(), new ViewsRepositoryImpl());
    }


   @GetMapping("/videos")
    public ResponseEntity<List<Video>> findAllVideos()  {
        try {
            return ResponseEntity.status( HttpStatus.OK ).body( cultureMediaService.findAll() );
        } catch (VideoNotFoundException e) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST)
                    .header( "Error-Message", e.getMessage())
                    .body(Collections.emptyList());
        }
    }


    @PostMapping("/videos")
    public ResponseEntity<Video> add(@RequestBody @Valid Video video) {
        return ResponseEntity.status( HttpStatus.OK ).body(cultureMediaService.save(video));
    }

}