package jpanelimagen;

import java.io.File;
import java.io.Serializable;

public class ImagenFondo implements Serializable {

    private File rutaImagen;
    private Float opacidad;

    public ImagenFondo(File rutaImagen, Float opacidad){
        this.rutaImagen = rutaImagen;
        this.opacidad = opacidad;
    }

    public File getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(File rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Float getOpacidad() {
        return opacidad;
    }

    public void setOpacidad(Float opacidad) {
        this.opacidad = opacidad;
    }
}
