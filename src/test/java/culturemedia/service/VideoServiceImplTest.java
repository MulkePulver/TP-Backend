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
    @Test
    void when_FindByTitle_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown() {
        when(videoRepository.find("Nonexistent Title")).thenReturn(Collections.emptyList());
        assertThrows(VideoNotFoundException.class, () -> videoService.findByTitle("Nonexistent Title"));
    }

    @Test
    void when_FindByTitle_finds_videos_they_should_be_returned() throws VideoNotFoundException {
        List<Video> videos = List.of(new Video("01", "Title", "Description", 4.5));
        when(videoRepository.find("Title")).thenReturn(videos);
        List<Video> result = videoService.findByTitle("Title");
        assertEquals(1, result.size());
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown() {
        when(videoRepository.find(1.0, 2.0)).thenReturn(Collections.emptyList());
        assertThrows(VideoNotFoundException.class, () -> videoService.findByDuration(1.0, 2.0));
    }

    @Test
    void when_FindByDuration_finds_videos_they_should_be_returned() throws VideoNotFoundException {
        List<Video> videos = List.of(new Video("01", "Title", "Description", 4.5));
        when(videoRepository.find(4.0, 5.0)).thenReturn(videos);
        List<Video> result = videoService.findByDuration(4.0, 5.0);
        assertEquals(1, result.size());
    }
}