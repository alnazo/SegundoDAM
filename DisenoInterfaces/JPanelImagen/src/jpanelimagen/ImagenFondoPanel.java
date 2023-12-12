package jpanelimagen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImagenFondoPanel extends JPanel{
    private JPanel panelBase;
    private JTextField ulrField;
    private JButton searchButton;
    private JSlider opacitySlider;


    public ImagenFondoPanel() {
        ulrField.setEnabled(false);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int resultado = fileChooser.showOpenDialog(ImagenFondoPanel.super.getParent());
                if (resultado == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    ulrField.setText(file.getAbsolutePath());
                }
            }
        });
    }

    public ImagenFondo getSelectValue(){
        File f = new File(ulrField.getText());
        Float opacidad = opacitySlider.getValue()/100f;
        return new ImagenFondo(f, opacidad);
    }




}
