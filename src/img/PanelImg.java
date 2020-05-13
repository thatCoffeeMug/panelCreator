package img;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

@SuppressWarnings("serial")
public class PanelImg extends JPanel{
Dimension dims = new Dimension(5,28);

SpringLayout mlayout;

JPanel questPanel;
    JLabel questL;
    JTextField questTF;

JLabel ansL;

JTabbedPane tp; // Tabbed panels (lists of right and wrong asnwers)
    JPanel rightP;
        JPanel[] rightImgP = new JImageLocation[10];

    JPanel wrongP;
        JLabel[] wrongImgL = new JLabel[6];
        JTextField[] wrongImgTF = new JTextField[6];
        JButton[] wrongImgBtn = new JButton[10];

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
        // c.anchor = GridBagConstraints.CENTER;
        // c.insets = new Insets(0,0,0,0);
        // c.ipadx = 200;
        // c.ipady = 50;
        // c.gridwidth = 4;

        // for(int i = 0; i < rightImgP.length; i++){
        for(int i = 0; i < 1; i++){
            rightImgP[i] = new JImageLocation(i+1);
            c.gridy = i;

            rightP.add(rightImgP[i], c);

        }




        wrongP = new JPanel(new GridBagLayout());
        JScrollPane wrongpscroll = new JScrollPane(wrongP);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;

        for(int i = 0; i < wrongImgL.length; i++){



            wrongImgL[i] = new JLabel("Imagen " + (i+1) + ":");
            wrongImgTF[i] = new JTextField(20);
            wrongImgTF[i].setPreferredSize(dims);
            wrongImgBtn[i] = new JButton("...");

            c.weightx = 0;
            c.weighty = 0;
            c.insets = new Insets(0,0,5,0);
            c.gridx = 0;
            c.gridy = i;
            c.gridwidth = 1;
            wrongP.add(wrongImgL[i], c);

            c.weightx = 0;
            c.weighty = 0;
            c.insets = new Insets(0,10,5,0);
            c.gridx = 1;
            c.gridy = i;
            c.gridwidth = 2;
            wrongP.add(wrongImgTF[i], c);

            c.weightx = 0;
            c.weighty = 0;
            c.insets = new Insets(0,10,5,0);
            c.gridx = 4;
            c.gridy = i;
            c.gridwidth = 2;
            wrongP.add(wrongImgBtn[i], c);
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




}
