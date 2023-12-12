package jpanelimagen;

import java.awt.*;
import java.beans.PropertyEditorSupport;

public class ImagenFondoPropertyEditorSupport extends PropertyEditorSupport {

    private ImagenFondoPanel imagenFondoPanel = new ImagenFondoPanel();

    @Override
    public Object getValue() {
        return imagenFondoPanel.getSelectValue();
    }

    @Override
    public String getJavaInitializationString() {
        ImagenFondo imagenFondo = imagenFondoPanel.getSelectValue();

        String ruta = imagenFondo.getRutaImagen().getAbsolutePath();
        ruta = ruta.replace('\\', '/');

        return "new jpanelimagen.ImagenFondo("+"new java.io.File(\""+ruta+"\"),"+imagenFondo.getOpacidad()+"f)";
    }

    @Override
    public Component getCustomEditor() {
        return imagenFondoPanel;
    }

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }
}
