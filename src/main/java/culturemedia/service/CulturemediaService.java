package culturemedia.service;

import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CulturemediaService {
    List<Video> listarTodos();
    Video save(Video video);
    View save(View view);
}
