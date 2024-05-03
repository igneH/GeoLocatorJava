package windows;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    JButton button;
    JTextField textField;
    JTextPane textPane;
    public MainWindow(){
        // Colors
        Color backgroundColor = new Color(0x152238);

        // Buttons
        button = new JButton();
        button.setBounds(150,60,100,25);
        button.setText("Ok");
        button.addActionListener(e -> {
            APICall geoData = new APICall(textField.getText());
            textPane.setText(geoData.getGeoLocation());
        });

        // TextFields
        textField = new JTextField();
        textField.setBounds(150,30,100,25);

        // JLists
        textPane = new JTextPane();
        textPane.setBounds(75,90,250,250);

        // Labels
        JLabel label = new JLabel();
        label.setBounds(0,0,400,400);
        label.setText("HAHAHAHAHA");
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.add(textField);
        label.add(button);
        label.add(textPane);

        // Frame settings
        this.setTitle("GeoLocator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(400,400);
        this.setVisible(true);
        this.setLayout(null);

        this.add(label);
        this.getContentPane().setBackground(backgroundColor);
    }
}
