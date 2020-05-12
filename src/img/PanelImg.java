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
        JLabel[] rightImgL = new JLabel[10];
        JTextField[] rightImgTF = new JTextField[10];
        JButton[] rightImgBtn = new JButton[10];

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
        c.anchor = GridBagConstraints.NORTH;

        for(int i = 0; i < rightImgL.length; i++){


            rightImgL[i] = new JLabel("Imagen " + (i+1) + ":");
            rightImgTF[i] = new JTextField(20);
            rightImgTF[i].setPreferredSize(dims);
            rightImgBtn[i] = new JButton("...");

            c.weightx = 0;
            c.weighty = 0;
            c.insets = new Insets(0,0,5,0);
            c.gridx = 0;
            c.gridy = i;
            c.gridwidth = 1;
            rightP.add(rightImgL[i], c);

            c.weightx = 0;
            c.weighty = 0;
            c.insets = new Insets(0,10,5,0);
            c.gridx = 1;
            c.gridy = i;
            c.gridwidth = 2;
            rightP.add(rightImgTF[i], c);

            c.weightx = 0;
            c.weighty = 0;
            c.insets = new Insets(0,10,5,0);
            c.gridx = 4;
            c.gridy = i;
            c.gridwidth = 2;
            rightP.add(rightImgBtn[i], c);

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
            rightP.add(wrongImgBtn[i], c);
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
