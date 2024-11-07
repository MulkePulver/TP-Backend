package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.service.CulturemediaService;
import culturemedia.service.impl.CultureMediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class CultureMediaServiceImplTest {

    CulturemediaService cultureMediaService;
    VideoRepository mockVideoRepository;


    @BeforeEach
    void init(){
        mockVideoRepository = Mockito.mock(VideoRepository.class);
        cultureMediaService = new CultureMediaServiceImpl(mockVideoRepository, null);

    }
    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        List<Video> expectedVideos = new ArrayList<>();
        expectedVideos.add(new Video("01", "Título 1", "Pelicula", 3.5));
        expectedVideos.add(new Video("02", "Título 2", "Serie", 4.0));
        when(mockVideoRepository.findAll()).thenReturn(expectedVideos);
        List<Video> actualVideos = cultureMediaService.findAll();
        assertEquals(expectedVideos.size(), actualVideos.size());
    }
    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws VideoNotFoundException{
        when(mockVideoRepository.findAll()).thenReturn(Collections.emptyList());
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.findAll();
        });
    }
    @Test
    void when_FindByTittle_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws VideoNotFoundException{
        when(mockVideoRepository.find("Movie")).thenReturn(Collections.emptyList());
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.find("Movie");
        });

    }

    @Test
    void when_FindByTittle_videos_should_be_returned_successfully() throws VideoNotFoundException {
        Video video = new Video("4", "Los años viejos", "Pelicula", 3.5);
        List<Video> videos = new ArrayList<>();
        videos.add(video);
        when(mockVideoRepository.find("Los años viejos")).thenReturn(videos);
        cultureMediaService.save(video);
        List<Video> foundVideos = cultureMediaService.find("Los años viejos");
        assertEquals(1, foundVideos.size());
    }
    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws VideoNotFoundException{
        when(mockVideoRepository.find(1.5, 2.0)).thenReturn(Collections.emptyList());
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.find(1.5, 2.0);
        });
    }
    @Test
    void when_FindByDuration_videos_should_be_returned_successfully() throws VideoNotFoundException {
        Video video = new Video("4", "Los años viejos", "Pelicula", 3.5);
        List<Video> videos = new ArrayList<>();
        videos.add(video);
        when(mockVideoRepository.find(2.5, 3.5)).thenReturn(videos);
        cultureMediaService.save(video);
        List<Video> foundVideos = cultureMediaService.find(2.5, 3.5);
        assertEquals(1, foundVideos.size());

    }

}
