import org.netbeans.validation.api.builtin.stringvalidation.MayusculaValidator;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.ui.swing.ValidationPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Locale;

public class TestView extends JFrame {
    private JPanel panel1;
    private JTextField nombreField;
    private JPanel userSection;
    private JPanel passSection;
    private JPanel submitSection;
    private JButton button1;
    private JTextField edadField;
    private ValidationPanel validationPanel;

    public TestView(){
        super("TestForm");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setContentPane(panel1);

        ValidationGroup group = validationPanel.getValidationGroup();

        group.add(nombreField, StringValidators.REQUIRE_NON_EMPTY_STRING, new MayusculaValidator());
        group.add(edadField, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER);

        validationPanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                button1.setEnabled(validationPanel.getProblem() == null);
            }
        });

    }

    public static void main(String[] args) {
        EventQueue.invokeLater( () -> {
            Locale.setDefault(new Locale("es", "ES"));
            new TestView().setVisible(true);
        });
    }
}
