import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame{
    JFrame myFrame = new JFrame("Triple Pulley Belt");

    public static JTextField c12Field = new JTextField();
    public static JTextField c13Field = new JTextField();
    public static JTextField c23Field = new JTextField();
    public static JTextField R1Field = new JTextField();
    public static JTextField R2Field = new JTextField();
    public static JTextField R3Field = new JTextField();
    public static JTextField angle1Field = new JTextField();
    public static JTextField angle2Field = new JTextField();
    public static JTextField angle3Field = new JTextField();

    public static JTextField c12Entry = new JTextField();
    public static JTextField c13Entry = new JTextField();
    public static JTextField c23Entry = new JTextField();
    public static JTextField R1Entry = new JTextField();
    public static JTextField R2Entry = new JTextField();
    public static JTextField R3Entry = new JTextField();
    public static JTextField angle1Entry = new JTextField();
    public static JTextField angle2Entry = new JTextField();
    public static JTextField angle3Entry = new JTextField();

    public static JTextField lengthOutput = new JTextField();

    public static JTextField deadField = new JTextField();

    JButton calculateButton = new JButton("Calculate Length");
    ImageIcon imageIcon = new ImageIcon("src/Screenshot 2023-01-22 180456.png");
    Image image = imageIcon.getImage();
    Image newimg = image.getScaledInstance(450, 360,  java.awt.Image.SCALE_SMOOTH);
    

    public static int y = 50;
    public static int y2 = 50;
    double[] values = new double[9];

    public Window(){
        imageIcon = new ImageIcon(newimg);
        JLabel myLabel = new JLabel(imageIcon);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        myFrame.setSize(1000, 800);
        

        initializeMeasurementLabels(c12Field);
        initializeMeasurementLabels(c13Field);
        initializeMeasurementLabels(c23Field);
        initializeMeasurementLabels(R1Field);
        initializeMeasurementLabels(R2Field);
        initializeMeasurementLabels(R3Field);
        initializeMeasurementLabels(angle1Field);
        initializeMeasurementLabels(angle2Field);
        initializeMeasurementLabels(angle3Field);
        setLabelTexts();

        
        initializeMeasurementValues(c12Entry);
        initializeMeasurementValues(c13Entry);
        initializeMeasurementValues(c23Entry);
        initializeMeasurementValues(R1Entry);
        initializeMeasurementValues(R2Entry);
        initializeMeasurementValues(R3Entry);
        initializeMeasurementValues(angle1Entry);
        initializeMeasurementValues(angle2Entry);
        initializeMeasurementValues(angle3Entry);

        myLabel.setBounds(495,270,450,360);
        myLabel.setOpaque(false);
        myLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        myFrame.add(myLabel);
        buttonSetup();
        setupLengthOutput(lengthOutput);

        initializeMeasurementLabels(deadField);


        myFrame.remove(deadField);
        myFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        myFrame.setVisible(true);   

    }

    public void initializeMeasurementLabels(JTextField textField){
        textField.setOpaque(false);
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField.setFont(new Font("Serif", Font.PLAIN, 30));
        textField.setBounds(20, y, 80, 40);
        textField.setEditable(false);
        
        myFrame.add(textField); 
        
        y += 50;
    }

    public void initializeMeasurementValues(JTextField textField){
        textField.setFont(new Font("Serif", Font.PLAIN, 30));
        textField.setBounds(160, y2, 300, 40);
        textField.setText("0");
        myFrame.add(textField); 
        y2 += 50;
    }

    public void setLabelTexts(){
        c12Field.setText("C12:");
        c13Field.setText("C13:");
        c23Field.setText("C23:");
        R1Field.setText("R1:");
        R2Field.setText("R2:");
        R3Field.setText("R3:");
        angle1Field.setText("a1:");
        angle2Field.setText("a2:");
        angle3Field.setText("a3:");
    }


    public void setupLengthOutput(JTextField textField){
        textField.setFont(new Font("Serif", Font.PLAIN, 30));
        textField.setBounds(550, 150, 345, 40);
        textField.setText("Length....");
        myFrame.add(textField);
    }


    public void buttonSetup(){
        calculateButton.setBounds(165, 530, 180, 80);
        calculateButton.setOpaque(false);
        calculateButton.setContentAreaFilled(true);
        calculateButton.setBorderPainted(true);
        myFrame.add(calculateButton);

        calculateButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                try {
                values[0] = Double.parseDouble(c12Entry.getText());
                values[1] = Double.parseDouble(c13Entry.getText());
                values[2] = Double.parseDouble(c23Entry.getText());
                values[3] = Double.parseDouble(R1Entry.getText());
                values[4] = Double.parseDouble(R2Entry.getText());
                values[5] = Double.parseDouble(R3Entry.getText());
                values[6] = Double.parseDouble(angle1Entry.getText());
                values[7] = Double.parseDouble(angle2Entry.getText());
                values[8] = Double.parseDouble(angle3Entry.getText());
                lengthOutput.setText("" + calculateLength());
                } catch (Exception f) {
                    //f.printStackTrace();
                    lengthOutput.setText("Enter Only Numbers.");
                }
                

            } 
                });
    }
    public double calculateLength(){
        return (values[0] + values[1] + values[2]) + 
        ((1/2) * 
        (   (Math.pow(values[4] - values[3], 2)/values[0]) +
            (Math.pow(values[5] - values[3], 2)/values[1]) +
            (Math.pow(values[5] - values[4], 2)/values[2]))
        ) + 
        (Math.PI*(values[3] + values[4] + values[5])) -
        (
            (values[6]*values[3]) + (values[7]*values[4]) + (values[8]*values[5])
        )
            ;
        

    }
    
}
