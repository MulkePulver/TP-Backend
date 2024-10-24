package culturemedia.service;

import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CulturemediaService {
    List<Video> listAll();
    Video save(Video video);
    View save(View view);
}
