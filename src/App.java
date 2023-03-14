import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bangunruang.Cuboid;

import java.awt.event.*;

import java.awt.*;

public class App extends JFrame implements ActionListener {

    JLabel lTitle,lLength,lWidth,lHeight,lResult,lArea,lCircumference,lVolume,lSurfaceArea;
    JTextField lengthTextField, widthTextField,heightTextField;
    JButton countButton,resetButton;
    public App(){

        //JLabel Components
        lTitle = new JLabel("Cuboid Calculator");
        lLength = new JLabel("Length");
        lWidth = new JLabel("Width");
        lHeight = new JLabel("Height");
        lResult = new JLabel("Result :");
        lArea = new JLabel();
        lCircumference = new JLabel();
        lVolume = new JLabel();
        lSurfaceArea = new JLabel();
        

        //JLabel Settings
        lTitle.setBounds(220,30,200,30);
        lTitle.setPreferredSize(new Dimension(0,80));
        lTitle.setFont(new Font(null, Font.BOLD, 16));
        
        lLength.setBounds(80, 110, 100, 40);
        lLength.setFont(new Font(null, Font.BOLD, 16));

        lWidth.setBounds(80, 175, 100, 40);
        lWidth.setFont(new Font(null, Font.BOLD, 16));
        
        lHeight.setBounds(80, 240, 100, 40);
        lHeight.setFont(new Font(null, Font.BOLD, 16));
        
        lResult.setBounds(207, 275, 100, 40);
        lResult.setFont(new Font(null, Font.BOLD, 16));

        lArea.setBounds(80, 325, 400, 40);
        lArea.setFont(new Font(null, Font.BOLD, 14));
        
        lCircumference.setBounds(80, 370,400, 40);
        lCircumference.setFont(new Font(null, Font.BOLD, 14));

        lVolume.setBounds(80, 413, 400, 40);
        lVolume.setFont(new Font(null, Font.BOLD, 14));

        lSurfaceArea.setBounds(80, 455, 400, 40);
        lSurfaceArea.setFont(new Font(null, Font.BOLD, 14));
        
        //JTextField Components
        lengthTextField = new JTextField();
        widthTextField = new JTextField();
        heightTextField = new JTextField();

        //JTextField Settings
        lengthTextField.setBounds(200,120,240,25);
        widthTextField.setBounds(200,183,240,25);
        heightTextField.setBounds(200,250,240,25);
        

        //JButton Components
        countButton = new JButton("Count");
        resetButton = new JButton("Reset");

        //JButton Settings
        countButton.setBounds(185,540,100,23);
        resetButton.setBounds(295,540,100,23);
        
        
        //JFrame Settings
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(570,610);
        setLocationRelativeTo(null);
        setLayout(null);

        //Adding Components to Frame
        add(lTitle);
        add(lLength);
        add(lWidth);
        add(lHeight);
        add(lArea);
        add(lCircumference);
        add(lVolume);
        add(lSurfaceArea);
        add(lengthTextField);
        add(widthTextField);
        add(heightTextField);
        add(lResult);
        add(countButton);
        add(resetButton);

        //Adding Event Handling to Components
        countButton.addActionListener(this);
        resetButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == countButton){
            try {
                double l =  Double.parseDouble(lengthTextField.getText());
                double w =  Double.parseDouble(widthTextField.getText());
                double h =  Double.parseDouble(heightTextField.getText());
                Cuboid block = new Cuboid(l, w, h);

                lArea.setText(String.format("Rectangle Area                   : %.2f",block.getArea()));
                lCircumference.setText(String.format("Rectangle Circumference : %.2f", block.getCircumference()));
                lVolume.setText(String.format("Cuboid Volume                   : %.2f", block.getVolume()));
                lSurfaceArea.setText(String.format("Cuboid Surface Area          : %.2f", block.getSurfaceArea()));
                
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, nfe.getMessage(), "Message", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Unknown Error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(ae.getSource() == resetButton){
            lengthTextField.setText(null);
            widthTextField.setText(null);
            heightTextField.setText(null);
            lArea.setText(null);
            lCircumference.setText(null);
            lVolume.setText(null);
            lSurfaceArea.setText(null);
        }

    }
    
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");  //clearing the terminal
        new App();

    }
}
