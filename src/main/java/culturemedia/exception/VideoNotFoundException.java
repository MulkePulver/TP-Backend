package culturemedia.exception;

import culturemedia.model.Video;

public class VideoNotFoundException extends Exception {
    public VideoNotFoundException() {
        super("El video no ha sido encontrado");
    }
    public VideoNotFoundException(String title) {
        super("El video con el título " + title + " no ha sido encontrado");
    }
}
