package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewsRepositoryImpl;

import java.util.List;

public class VideoServiceImpl implements VideoService {
    private final VideoRepositoryImpl videoRepository;
    private final ViewsRepositoryImpl viewsRepository;

    public VideoServiceImpl(VideoRepositoryImpl videoRepository, ViewsRepositoryImpl viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }


    @Override
    public List<Video> findAll() throws VideoNotFoundException {
    List<Video> videos = videoRepository.findAll();
    if (videos.isEmpty()) {
        throw new VideoNotFoundException("No videos found");
    }
    return videos;
}

    @Override
    public Video save(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public View save(View view) {
        return viewsRepository.save(view);
    }
}