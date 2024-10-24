package culturemedia.repository.impl;
import java.util.ArrayList;
import java.util.List;

import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;

public class VideoRepositoryImpl implements VideoRepository {

	private final List<Video> videos;

	public VideoRepositoryImpl() {
		videos = new ArrayList<>();
		videos.add(new Video("01", "Clic", "----", 4.5));
        videos.add(new Video("02", "Clic", "----", 5.5));
        videos.add(new Video("03", "Título 3", "----", 4.4));
        videos.add(new Video("04", "Título 4", "----", 3.5));
        videos.add(new Video("05", "Clic 5", "----", 5.7));
        videos.add(new Video("06", "Clic 6", "----", 5.1));
	}

	@Override
	public List<Video> findAll() {
		return videos;
	}

	@Override
	public Video save(Video video) {
		this.videos.add( video );
		return video;
	}

	@Override
	public List<Video> find(String title) {
		List<Video> filteredVideos = null;
		for ( Video video : videos ) {
			if(title.equals( video.title() )){
				if(filteredVideos == null){
					filteredVideos = new ArrayList<Video>();
				}
				filteredVideos.add(video);
			}
		}
		return filteredVideos;
	}

	@Override
	public List<Video> find(Double fromDuration, Double toDuration) {
		List<Video> filteredVideos = new ArrayList<Video>();
		for ( Video video : videos ) {
			if(video.duration()> fromDuration && video.duration()< toDuration){
				filteredVideos.add(video);
			}
		}
		return filteredVideos;
	}
}