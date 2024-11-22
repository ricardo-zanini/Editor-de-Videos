package Content;

import Alert.UserAlert;
import Input.*;
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

    private JButton         buttonNegative;

    private JButton         buttonResize;

    private JButton         buttonFlipV;
    private boolean         flipedV;

    private JButton         buttonFlipH;
    private boolean         flipedH;


    private JLabel                  labelFileSelector;
    private FileSelector      fileSelector;

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

        setButtonNegative(new JButton("NEGATIVA"));

        setButtonResize(new JButton("REDIMENCIONAR"));

        setButtonFlipV(new JButton("ESPELHAMENTO VERTICAL"));
        setButtonFlipH(new JButton("ESPELHAMENTO HORIZONTAL"));


        setLabelFileSelector(new JLabel("- SALVAR VIDEO -"));
        setFileSelector(new FileSelector(205, new FileNameExtensionFilter("Vídeos", "avi"), "SALVAR"));   
    }

    private void configComponents(){
        try{
            File fontStyle = new File("Fonts/pixelated_fancy_font.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle);
    
            buttonClean.setFont(font.deriveFont(16f));

            sliderGaussian.setFont(font.deriveFont(16f));
            buttonGaussian.setFont(font.deriveFont(16f));

            fieldBrightness.setFont(font.deriveFont(16f));
            buttonBrightness.setFont(font.deriveFont(16f));

            fieldContrast.setFont(font.deriveFont(16f));
            buttonContrast.setFont(font.deriveFont(16f));

            buttonSobel.setFont(font.deriveFont(16f));

            buttonCanny.setFont(font.deriveFont(16f));

            buttonGray.setFont(font.deriveFont(16f));

            buttonNegative.setFont(font.deriveFont(16f));

            buttonResize.setFont(font.deriveFont(16f));

            buttonFlipV.setFont(font.deriveFont(16f));
            buttonFlipH.setFont(font.deriveFont(16f));

            labelFileSelector.setFont(font.deriveFont(16f));

        }catch(Exception e){
            UserAlert userAlert = new UserAlert("ERRO - Erro ao carregar Fonte"); 
        }

        buttonClean.addActionListener(      event -> setVideoChange(null));
        buttonGaussian.addActionListener(   event -> setVideoChange("gaussian", Integer.toString(sliderGaussian.getValue())));
        buttonBrightness.addActionListener( event -> setVideoChange("brightness", fieldBrightness.getText()));
        buttonContrast.addActionListener(   event -> setVideoChange("contrast", fieldContrast.getText()));
        buttonSobel.addActionListener(      event -> setVideoChange("sobel"));
        buttonCanny.addActionListener(      event -> setVideoChange("canny"));
        buttonGray.addActionListener(       event -> setVideoChange("gray"));
        buttonNegative.addActionListener(   event -> setVideoChange("negative"));
        buttonResize.addActionListener(     event -> setVideoChange("resize"));
        buttonFlipV.addActionListener(      event -> setVideoChange("flipV"));
        buttonFlipH.addActionListener(      event -> setVideoChange("flipH"));

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

        buttonNegative.setBounds(20, 570, 345, 40);
        buttonNegative.setBackground(new Color(120, 90,148));
        buttonNegative.setBorder(new LineBorder(new Color(0, 0, 0),0));
        buttonNegative.setFocusable(false);
        buttonNegative.setForeground(Color.WHITE);

        buttonResize.setBounds(20, 630, 345, 40);
        buttonResize.setBackground(new Color(120, 90,148));
        buttonResize.setBorder(new LineBorder(new Color(0, 0, 0),0));
        buttonResize.setFocusable(false);
        buttonResize.setForeground(Color.WHITE);

        buttonFlipV.setBounds(20, 690, 345, 40);
        buttonFlipV.setBackground(new Color(120, 90,148));
        buttonFlipV.setBorder(new LineBorder(new Color(0, 0, 0),0));
        buttonFlipV.setFocusable(false);
        buttonFlipV.setForeground(Color.WHITE);

        buttonFlipH.setBounds(20, 750, 345, 40);
        buttonFlipH.setBackground(new Color(120, 90,148));
        buttonFlipH.setBorder(new LineBorder(new Color(0, 0, 0),0));
        buttonFlipH.setFocusable(false);
        buttonFlipH.setForeground(Color.WHITE);

        //---------------------------------------------------------

        labelFileSelector.setBounds(20, 790, 1000, 50);
        labelFileSelector.setForeground(Color.white);
        fileSelector.setBounds(20, 835, 545, 40);
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

        add(buttonNegative);

        add(buttonResize);

        add(buttonFlipV);
        add(buttonFlipH);

        add(labelFileSelector);
        add(fileSelector);
    }

    private void eventActionSelected(String evento){
        setVideoChange(evento);
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


    public JButton getButtonNegative() {
        return buttonNegative;
    }
    public void setButtonNegative(JButton buttonNegative) {
        this.buttonNegative = buttonNegative;
    }


    public JButton getButtonResize() {
        return buttonResize;
    }
    public void setButtonResize(JButton buttonResize) {
        this.buttonResize = buttonResize;
    }


    public JButton getButtonFlipV() {
        return buttonFlipV;
    }
    public void setButtonFlipV(JButton buttonFlipV) {
        this.buttonFlipV = buttonFlipV;
    }

    public JButton getButtonFlipH() {
        return buttonFlipH;
    }
    public void setButtonFlipH(JButton buttonFlipH) {
        this.buttonFlipH = buttonFlipH;
    }


    public boolean getFlipedV() {
        return flipedV;
    }
    public void setFlipedV(boolean flipedV) {
        this.flipedV = flipedV;
    }

    public boolean getFlipedH() {
        return flipedH;
    }
    public void setFlipedH(boolean flipedH) {
        this.flipedH = flipedH;
    }


    public String getVideoChange() {
        return videoChange;
    }
    public void setVideoChange(String videoChange) {
        if(videoChange == null){
            this.videoChange = "";    
        }else if(this.videoChange == null || this.videoChange.equals("")){
            this.videoChange = videoChange;
        }else{
            this.videoChange = this.videoChange + ";" + videoChange;
        }
        System.out.println(this.videoChange);
    }
    public void setVideoChange(String videoChange, String value) {
        if(videoChange == null){
            this.videoChange = "";    
        }else if(this.videoChange == null){
            this.videoChange = videoChange;
        }else{
            this.videoChange = this.videoChange + ";" + videoChange + ":" + value;
        }
        System.out.println(this.videoChange);
    }


    public JLabel getLabelFileSelector() {
        return labelFileSelector;
    }
    public void setLabelFileSelector(JLabel labelFileSelector) {
        this.labelFileSelector = labelFileSelector;
    }



    public FileSelector getFileSelector() {
        return fileSelector;
    }
    public void setFileSelector(FileSelector fileSelector) {
        this.fileSelector = fileSelector;
    }
}
