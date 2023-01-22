import java.awt.Font;

import javax.swing.JFrame;
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

    public static JTextField deadField = new JTextField();

    public static int y = 50;
    public static int y2 = 50;

    public Window(){
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        myFrame.setSize(2000, 800);

        initializeMeasurementLabels(c12Field);
        initializeMeasurementLabels(c13Field);
        initializeMeasurementLabels(c23Field);
        initializeMeasurementLabels(R1Field);
        initializeMeasurementLabels(R2Field);
        initializeMeasurementLabels(R3Field);
        initializeMeasurementLabels(angle1Field);
        initializeMeasurementLabels(angle2Field);
        initializeMeasurementLabels(angle3Field);

        
        initializeMeasurementValues(c12Entry);
        initializeMeasurementValues(c13Entry);
        initializeMeasurementValues(c23Entry);
        initializeMeasurementValues(R1Entry);
        initializeMeasurementValues(R2Entry);
        initializeMeasurementValues(R3Entry);
        initializeMeasurementValues(angle1Entry);
        initializeMeasurementValues(angle2Entry);
        initializeMeasurementValues(angle3Entry);

        initializeMeasurementLabels(deadField);

        myFrame.remove(deadField);
        
        myFrame.setVisible(true);   

    }

    public void initializeMeasurementLabels(JTextField textField){
        textField.setText("Hoya Robotics");
        textField.setOpaque(false);
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 30));
        textField.setBounds(80, y, 220, 40);
        textField.setEditable(false);
        
        myFrame.add(textField); 
        
        y += 50;
    }

    public void initializeMeasurementValues(JTextField textField){
        textField.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 30));
        textField.setBounds(300, y2, 220, 40);
        textField.setText("TESTSET");
        myFrame.add(textField); 
        y2 += 50;
    }
    
}
