import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    //create all buttons (Load, Reset, Exit)
    JButton loadBtn =new JButton("Load");
    JButton resetBtn=new JButton("Reset");
    JButton exitBtn=new JButton("Exit");


    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //add all buttons
        add(saveBtn);
        add(exitBtn);
        add(resetBtn);
        add(loadBtn);

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load) ;
        exitBtn.addActionListener(this::exit);
        resetBtn.addActionListener(this::reset);

    }

    private void reset(ActionEvent e)//buton reset
    {
       frame.canvas.graphics.setColor(Color.WHITE);
       frame.canvas.graphics.fill(new Rectangle(800,600));
       frame.canvas.repaint();



    }
    private void exit(ActionEvent e) {//exit
            System.exit(0);
    }

    private void load(ActionEvent e) {//load cu filechooser

        try { JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();

            BufferedImage image = ImageIO.read(new File(selectedFile.getAbsolutePath()));
            frame.canvas.graphics.drawImage(image, 0, 0, null);
           frame.repaint();}
        } catch (IOException ex) { System.err.println(ex); }

    }

    private void save(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
            ImageIO.write(frame.canvas.image, "PNG",
                    new FileOutputStream(selectedFile.getAbsolutePath()));}
        } catch (IOException ex) { System.err.println(ex); }
    }

}


