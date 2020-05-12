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
            questTF = new JTextField(15);
            questTF.setPreferredSize(dims);

            c.gridx = 0;
            c.gridy = 0;
            c.anchor = GridBagConstraints.WEST;
            questPanel.add(questL, c);

            c.gridy = 1;
            questPanel.add(questTF, c);


        mlayout.putConstraint(SpringLayout.NORTH, questPanel,
                              10,
                              SpringLayout.NORTH, this);
        mlayout.putConstraint(SpringLayout.WEST, questPanel,
                              10,
                              SpringLayout.WEST, this);

        this.add(questPanel);


    }




}
