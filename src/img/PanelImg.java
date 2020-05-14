package img;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;



@SuppressWarnings("serial")
public class PanelImg extends JPanel implements ActionListener{
Dimension dims = new Dimension(5,28);

SpringLayout mlayout;

JPanel questPanel;
    JLabel questL;
    JTextField questTF;

JLabel ansL;

JTabbedPane tp; // Tabbed panels (lists of right and wrong asnwers)
    JPanel rightP;
        JButton rightButton;
        JImageLocation[] rightImgP = new JImageLocation[1];

    JPanel wrongP;
        JButton wrongButton;
        JImageLocation[] wrongImgP = new JImageLocation[1];


    // Creates a new JPanel with a double buffer and a flow layout.
    public PanelImg(){
        this(true);
    }

    // Creates a new JPanel with a double buffer and a flow layout.
    public PanelImg(boolean isDoubleBuffered){
        super(null, isDoubleBuffered);
        mlayout = new SpringLayout();

        this.setLayout(mlayout);

        questPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
            questL = new JLabel("Pregunta:");
            questTF = new JTextField(20);
            questTF.setPreferredSize(dims);

            c.gridx = 0;
            c.gridy = 0;
            c.anchor = GridBagConstraints.WEST;
            questPanel.add(questL, c);

            c.gridy = 1;
            questPanel.add(questTF, c);


        mlayout.putConstraint(SpringLayout.NORTH, questPanel, 10,
                              SpringLayout.NORTH, this);
        mlayout.putConstraint(SpringLayout.WEST, questPanel, 10,
                              SpringLayout.WEST, this);
        this.add(questPanel);

        ansL = new JLabel("Respuestas:");

        mlayout.putConstraint(SpringLayout.NORTH, ansL, 10,
                              SpringLayout.SOUTH, questPanel);
        mlayout.putConstraint(SpringLayout.WEST, ansL, 10,
                              SpringLayout.WEST, this);
        this.add(ansL);


        tp = new JTabbedPane();


        rightP = new JPanel(new GridBagLayout());
        JScrollPane rightpscroll = new JScrollPane(rightP);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(5,0,5,0);

        c.gridy = 0;
        rightButton = new JButton("Abrir imágenes...");
        rightButton.addActionListener(this);
        rightP.add(rightButton, c);

        for(int i = 0; i < rightImgP.length; i++){
            rightImgP[i] = new JImageLocation(i+1);
            c.gridy = i+1;

            rightP.add(rightImgP[i], c);

        }




        wrongP = new JPanel(new GridBagLayout());
        JScrollPane wrongpscroll = new JScrollPane(wrongP);


        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(5,0,5,0);

        c.gridy = 0;
        wrongButton = new JButton("Abrir imágenes...");
        wrongButton.addActionListener(this);
        wrongP.add(wrongButton, c);

        for(int i = 0; i < wrongImgP.length; i++){
            wrongImgP[i] = new JImageLocation(i+1);
            c.gridy = i+1;

            wrongP.add(wrongImgP[i], c);

        }






        tp.add("Correctas", rightpscroll);
        tp.add("Incorrectas", wrongpscroll);


        mlayout.putConstraint(SpringLayout.NORTH, tp, 0,
                              SpringLayout.SOUTH, ansL);
        mlayout.putConstraint(SpringLayout.WEST, tp, 0,
                              SpringLayout.WEST, this);
        mlayout.putConstraint(SpringLayout.EAST, tp, 0,
                              SpringLayout.EAST, this);
        mlayout.putConstraint(SpringLayout.SOUTH, tp, 0,
                              SpringLayout.SOUTH, this);

        this.add(tp);
    }

    public int save(String author){

        if(errorWindow(questTF.getText().equals(""),
                    "¡Falta la pregunta!") < 0){
            return -1;
        }

        for(int i = 0; i < rightImgP.length; i++){
            if(errorWindow(!rightImgP[i].fileExists(),
                        "¡Falta la imagen " + i + " (respuestas correctas) !") < 0)
            {return -1;}
        }

        for(int i = 0; i < wrongImgP.length; i++){
            if(errorWindow(!wrongImgP[i].fileExists(),
                        "¡Falta la imagen " + i + " (respuestas incorrectas) !") < 0)
            {return -1;}
        }

        File[] rightFile = new File[rightImgP.length];
        File[] wrongFile = new File[wrongImgP.length];

        for(int i = 0; i < rightImgP.length; i++){
            rightFile[i] = rightImgP[i].getFile();
        }

        for(int i = 0; i < wrongImgP.length; i++){
            wrongFile[i] = wrongImgP[i].getFile();
        }

        ImgFile gamePanel = new ImgFile(rightFile, wrongFile, questTF.getText(),
                                        author, this);




        gamePanel.saveZip();
        gamePanel.saveTXT();

        return 0;
    }

    private int errorWindow(boolean check, String mess){
        if(check){
            JOptionPane.showMessageDialog(this,
                        mess,
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            return -1;
        } else {
            return 0;
        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == rightButton){
            asignFiles();
        } else if(e.getSource() == wrongButton){

        }
    }

    JFileChooser chooser = new JFileChooser();
    chooser.setMultiSelectionEnabled(true);
    chooser.showOpenDialog(frame);
    File[] files = chooser.getSelectedFiles();

}
