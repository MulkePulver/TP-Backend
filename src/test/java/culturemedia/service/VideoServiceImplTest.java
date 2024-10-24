package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewsRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VideoServiceImplTest {
    private VideoService videoService;
    private VideoRepositoryImpl videoRepository;

    @BeforeEach
    void init(){
        videoRepository = mock(VideoRepositoryImpl.class);
        ViewsRepositoryImpl viewsRepository = mock(ViewsRepositoryImpl.class);
        videoService = new VideoServiceImpl(videoRepository, viewsRepository);
    }

    @Test
    void findAll() throws VideoNotFoundException {
        List<Video> videos = videoService.findAll();
        assertNotNull(videos);
        assertEquals(6, videos.size());
    }

    @Test
    void saveVideo() {
        Video video = new Video("01", "Clic", "----", 4.5);
        Video savedView = videoService.save(video);
        assertNotNull(savedView);
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        List<Video> videos = videoService.findAll();
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        when(videoRepository.findAll()).thenReturn(Collections.emptyList());
        assertThrows(VideoNotFoundException.class, () -> videoService.findAll());
    }
}