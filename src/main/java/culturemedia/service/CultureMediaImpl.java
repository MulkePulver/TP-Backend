package culturemedia.service;

import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewsRepositoryImpl;

import java.util.List;

public class CultureMediaImpl implements CulturemediaService {
    public CultureMediaImpl(VideoRepositoryImpl videoRepository, ViewsRepositoryImpl viewsRepository) {
    }

    @Override
    public List<Video> listAll() {
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