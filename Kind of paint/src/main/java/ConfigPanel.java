import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConfigPanel extends JPanel {
        final MainFrame frame;
        JLabel sidesLabel;
        JSpinner sidesField;
        JComboBox colorCombo;
        JButton selectShape;
        String theShape="polygon";
        JFrame f;
        int delete=0;

        public ConfigPanel(MainFrame frame) {
            this.frame = frame;
            init();
        }
        private void init() {
            selectShape=new JButton("Select Shape");
            JButton deleteShape=new JButton("Delete");
            sidesLabel = new JLabel("Number of sides:");
            sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
            sidesField.setValue(6);
            String[] str={"Random","Black"};
            colorCombo=new JComboBox(str);
            selectShape.addActionListener(this::chooseShape);
            deleteShape.addActionListener(this::deleteShp);
            add(selectShape);
            add(colorCombo);
            add(deleteShape);
            if(theShape=="polygon"){
            add(sidesLabel);
            add(sidesField);}


        }
        private void deleteShp(ActionEvent e)
        {
           if(delete==0)
               delete=1;
           else
               delete=0;


        }
        private void chooseShape(ActionEvent e)
        {
             f=new JFrame("Choose Shape");
            JPanel p=new JPanel();
            JButton b = new JButton("Elipse");
            JButton b1 = new JButton("Regular Polygon");
            b.addActionListener(this::elipse);
            b1.addActionListener(this::pol);
            p.add(b);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            p.add(b1);
            f.setSize(300, 300);
            f.add(p);
            f.show();


        }
        private void elipse(ActionEvent e)//modific config panel
        {
            theShape="elipse";
            frame.configPanel.removeAll();
           frame.configPanel.init();
            frame.revalidate();
            frame.repaint();
            f.dispose();

        }
    private void pol(ActionEvent e)
    {
        theShape="polygon";
        frame.configPanel.removeAll();
        frame.configPanel.init();
        frame.revalidate();
        frame.repaint();
        f.dispose();

    }}


