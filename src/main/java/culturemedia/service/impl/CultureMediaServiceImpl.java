package culturemedia.service.impl;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.CulturemediaService;
import culturemedia.exception.VideoNotFoundException;

import java.text.MessageFormat;
import java.util.List;

public class CultureMediaServiceImpl implements CulturemediaService {
    private VideoRepository videoRepository;
    private ViewsRepository viewsRepository;

    public CultureMediaServiceImpl(VideoRepository videoRepository, Object o) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }


    public List <Video> find(String title) throws VideoNotFoundException {
        var video =videoRepository.find(title);
        try {
            if (video.isEmpty()) {
                throw new VideoNotFoundException();
            }
            return video;
        }catch(Exception e){
            throw new VideoNotFoundException(MessageFormat.format("video not found with the tittle: {0}, Error: {1} " + title,e));
        }
    }

    public List <Video> find(Double fromDuration, Double toDuration)throws VideoNotFoundException {
        var video = videoRepository.find(fromDuration, toDuration);
        try {
            if (video.isEmpty()) {
                throw new VideoNotFoundException();
            }
            return video;
        }catch(Exception e) {
            throw new VideoNotFoundException();
        }
    }
    public List<Video> findAll() throws VideoNotFoundException {
        var videos = videoRepository.findAll();
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("No videos found.");
        }
        return videos;
    }

    public Video save(Video video)  {
        return videoRepository.save(video);
    }

    public View save(View view)  {
        return viewsRepository.save(view);
    }

}