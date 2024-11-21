package Content;

import Alert.UserAlert;
import Input.*;
import Screen.CameraScreen;
import Util.*;
import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class HomeScreenContent extends JPanel{

    private JLabel          imageIcon;

    private JButton         buttonClean;

    private JSlider         sliderGaussian;
    private JButton         buttonGaussian;

    private JTextField      fieldBrightness;
    private JButton         buttonBrightness;

    private JTextField      fieldContrast;
    private JButton         buttonContrast;

    private JButton         buttonSobel;

    private JButton         buttonCanny;

    private JButton         buttonGray;

    private String          videoChange;

    public HomeScreenContent(int width, int height){

        setLayout(null);
        setPreferredSize( new Dimension (400,1880 ) );
        setBackground(new Color(38,38,38));

        createComponents();
        configComponents();
        addComponents();

    }

    private void createComponents(){

        setImageIcon(new JLabel(new ImageIcon(ImageFunctions.imageResized("img/AppIcon.png", 90, 90, 1))));

        setButtonClean(new JButton("LIMPAR"));

        setSliderGaussian(new JSlider(JSlider.HORIZONTAL, 1, 101, 1));
        setButtonGaussian(new JButton("GAUSSIANO"));

        setFieldBrightness(new JTextField(""));
        setButtonBrightness(new JButton("BRILHO"));

        setFieldContrast(new JTextField(""));
        setButtonContrast(new JButton("CONTRASTE"));

        setButtonSobel(new JButton("SOBEL"));

        setButtonCanny(new JButton("CANNY"));

        setButtonGray(new JButton("TONS DE CINZA"));

    }

    private void configComponents(){
        try{
            File fontStyle = new File("Fonts/pixelated_fancy_font.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle);
    
            buttonClean.setFont(font.deriveFont(16f));
            buttonClean.addActionListener(event -> eventActionSelected(""));

            sliderGaussian.setFont(font.deriveFont(16f));
            buttonGaussian.setFont(font.deriveFont(16f));
            buttonGaussian.addActionListener(event -> eventActionSelected("gaussian"));

            fieldBrightness.setFont(font.deriveFont(16f));
            buttonBrightness.setFont(font.deriveFont(16f));
            buttonBrightness.addActionListener(event -> eventActionSelected("brightness"));

            fieldContrast.setFont(font.deriveFont(16f));
            buttonContrast.setFont(font.deriveFont(16f));
            buttonContrast.addActionListener(event -> eventActionSelected("contrast"));

            buttonSobel.setFont(font.deriveFont(16f));
            buttonSobel.addActionListener(event -> eventActionSelected("sobel"));

            buttonCanny.setFont(font.deriveFont(16f));
            buttonCanny.addActionListener(event -> eventActionSelected("canny"));

            buttonGray.setFont(font.deriveFont(16f));
            buttonGray.addActionListener(event -> eventActionSelected("gray"));

        }catch(Exception e){
            UserAlert userAlert = new UserAlert("ERRO - Erro ao carregar Fonte"); 
        }

        //---------------------------------------------------------

        imageIcon.setBounds(155, 30, 90, 90);
        imageIcon.setHorizontalAlignment(JLabel.CENTER);

        //---------------------------------------------------------

        buttonClean.setBounds(20, 150, 345, 40);
        buttonClean.setBackground(new Color(175, 62, 94));
        buttonClean.setBorder(new LineBorder(new Color(0, 0, 0),0));
        buttonClean.setFocusable(false);
        buttonClean.setForeground(Color.WHITE);

        sliderGaussian.setBounds(20, 210, 172, 40);
        sliderGaussian.setBackground(new Color(33, 33, 33));
        sliderGaussian.setBorder(new LineBorder(new Color(0, 0, 0),0));
        sliderGaussian.setFocusable(false);
        sliderGaussian.setForeground(Color.WHITE);
       
        buttonGaussian.setBounds(192, 210, 173, 40);
        buttonGaussian.setBackground(new Color(120, 90,148));
        buttonGaussian.setBorder(new LineBorder(new Color(0, 0, 0),0));
        buttonGaussian.setFocusable(false);
        buttonGaussian.setForeground(Color.WHITE);

        //---------------------------------------------------------

        fieldBrightness.setBounds(20, 270, 172, 40);
        fieldBrightness.setBackground(new Color(33, 33, 33));
        fieldBrightness.setBorder(new LineBorder(new Color(33, 33, 33),10));
        fieldBrightness.setForeground(new Color(204, 204, 204));

        buttonBrightness.setBounds(192, 270, 173, 40);
        buttonBrightness.setBackground(new Color(120, 90,148));
        buttonBrightness.setBorder(new LineBorder(new Color(0, 0, 0),0));
        buttonBrightness.setFocusable(false);
        buttonBrightness.setForeground(Color.WHITE);

        //---------------------------------------------------------

        fieldContrast.setBounds(20, 330, 172, 40);
        fieldContrast.setBackground(new Color(33, 33, 33));
        fieldContrast.setBorder(new LineBorder(new Color(33, 33, 33),10));
        fieldContrast.setForeground(new Color(204, 204, 204));

        buttonContrast.setBounds(192, 330, 173, 40);
        buttonContrast.setBackground(new Color(120, 90,148));
        buttonContrast.setBorder(new LineBorder(new Color(0, 0, 0),0));
        buttonContrast.setFocusable(false);
        buttonContrast.setForeground(Color.WHITE);

        //-----------------------------------------------------

        
        buttonSobel.setBounds(20, 390, 345, 40);
        buttonSobel.setBackground(new Color(120, 90,148));
        buttonSobel.setBorder(new LineBorder(new Color(0, 0, 0),0));
        buttonSobel.setFocusable(false);
        buttonSobel.setForeground(Color.WHITE);

        buttonCanny.setBounds(20, 450, 345, 40);
        buttonCanny.setBackground(new Color(120, 90,148));
        buttonCanny.setBorder(new LineBorder(new Color(0, 0, 0),0));
        buttonCanny.setFocusable(false);
        buttonCanny.setForeground(Color.WHITE);

        buttonGray.setBounds(20, 510, 345, 40);
        buttonGray.setBackground(new Color(120, 90,148));
        buttonGray.setBorder(new LineBorder(new Color(0, 0, 0),0));
        buttonGray.setFocusable(false);
        buttonGray.setForeground(Color.WHITE);

    }

    private void addComponents(){

        add(imageIcon);

        add(buttonClean);
        
        add(sliderGaussian);
        add(buttonGaussian);

        add(fieldBrightness);
        add(buttonBrightness);

        add(fieldContrast);
        add(buttonContrast);

        add(buttonSobel);

        add(buttonCanny);

        add(buttonGray);
    }

    private void eventActionSelected(String evento){
        setVideoChange(evento);
        System.out.println(evento);
    }

    public JLabel getImageIcon() {
        return imageIcon;
    }
    public void setImageIcon(JLabel imageIcon) {
        this.imageIcon = imageIcon;
    }



    public JButton getButtonClean() {
        return buttonClean;
    }
    public void setButtonClean(JButton buttonClean) {
        this.buttonClean = buttonClean;
    }

    public JSlider getSliderGaussian() {
        return sliderGaussian;
    }
    public void setSliderGaussian(JSlider sliderGaussian) {
        this.sliderGaussian = sliderGaussian;
    }



    public JButton getButtonGaussian() {
        return buttonGaussian;
    }
    public void setButtonGaussian(JButton buttonGaussian) {
        this.buttonGaussian = buttonGaussian;
    }


    public JTextField getFieldBrightness() {
        return fieldBrightness;
    }
    public void setFieldBrightness(JTextField fieldBrightness) {
        this.fieldBrightness = fieldBrightness;
    }


    public JButton getButtonBrightness() {
        return buttonBrightness;
    }
    public void setButtonBrightness(JButton buttonBrightness) {
        this.buttonBrightness = buttonBrightness;
    }


    public JTextField getFieldContrast() {
        return fieldContrast;
    }
    public void setFieldContrast(JTextField fieldContrast) {
        this.fieldContrast = fieldContrast;
    }


    public JButton getButtonContrast() {
        return buttonContrast;
    }
    public void setButtonContrast(JButton buttonContrast) {
        this.buttonContrast = buttonContrast;
    }


    public JButton getButtonSobel() {
        return buttonSobel;
    }
    public void setButtonSobel(JButton buttonSobel) {
        this.buttonSobel = buttonSobel;
    }


    public JButton getButtonCanny() {
        return buttonCanny;
    }
    public void setButtonCanny(JButton buttonCanny) {
        this.buttonCanny = buttonCanny;
    }


    public JButton getButtonGray() {
        return buttonGray;
    }
    public void setButtonGray(JButton buttonGray) {
        this.buttonGray = buttonGray;
    }


    public String getVideoChange() {
        return videoChange;
    }
    public void setVideoChange(String videoChange) {
        this.videoChange = videoChange;
    }
   
}
