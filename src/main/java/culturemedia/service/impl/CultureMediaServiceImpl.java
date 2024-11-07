package culturemedia.service.impl;

import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewsRepositoryImpl;
import culturemedia.service.CulturemediaService;

import java.util.List;

public class CultureMediaServiceImpl implements CulturemediaService {
    public CultureMediaServiceImpl(VideoRepositoryImpl videoRepository, ViewsRepositoryImpl viewsRepository) {
    }

    @Override
    public List<Video> findAll() {
        return List.of();
    }

    @Override
    public Video save(Video video) {
        return null;
    }

    @Override
    public View save(View view) {
        return null;
    }
}