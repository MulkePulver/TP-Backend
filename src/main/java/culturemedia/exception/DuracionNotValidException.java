package culturemedia.exception;

import culturemedia.model.View;

public class DuracionNotValidException extends Exception {
    public DuracionNotValidException(String titulo, Double duracion) {
        super("La duración del video " + titulo + " (" + duracion + " minutos) no es válida");
    }
}
