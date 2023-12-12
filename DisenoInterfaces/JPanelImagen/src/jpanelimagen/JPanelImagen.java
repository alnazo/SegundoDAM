package jpanelimagen;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class JPanelImagen extends JPanel implements Serializable {

    private ImagenFondo imagenFondo;

    public JPanelImagen(){}

    public ImagenFondo getImagenFondo() {
        return imagenFondo;
    }

    public void setImagenFondo(ImagenFondo imagenFondo) {
        this.imagenFondo = imagenFondo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(imagenFondo != null){
            if (imagenFondo.getRutaImagen() != null && imagenFondo.getRutaImagen().exists()){
                ImageIcon imageIcon = new ImageIcon(imagenFondo.getRutaImagen().getAbsolutePath());

                Graphics2D g2d = (Graphics2D)g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, imagenFondo.getOpacidad()));
                g.drawImage(imageIcon.getImage(), 0, 0, null);
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            }

        }

    }
}
