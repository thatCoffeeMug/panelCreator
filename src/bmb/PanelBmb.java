package bmb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PanelBmb extends JPanel{
    Dimension dims = new Dimension(5,28);
    final int unitInc_scroll = 16;

    SpringLayout mlayout;

    JPanel questPanel;
        JLabel questL;
        JTextField questTF;

    JLabel ansL;

    JTabbedPane tp; // Tabbed panels (lists of right and wrong asnwers)

    JPanel rightP;
        JBomb rightL[] = new JBomb[8];

    JPanel wrongP;
        JBomb wrongL[] = new JBomb[8];

    public PanelBmb(){
        super();
        mlayout = new SpringLayout();
        setLayout(mlayout);

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

        add(questPanel);
        mlayout.putConstraint(SpringLayout.NORTH, questPanel, 10,
                            SpringLayout.NORTH, this);
        mlayout.putConstraint(SpringLayout.WEST, questPanel, 10,
                            SpringLayout.WEST, this);

        ansL = new JLabel("Respuestas");
        add(ansL);
        mlayout.putConstraint(SpringLayout.NORTH, ansL, 10,
                            SpringLayout.SOUTH, questPanel);
        mlayout.putConstraint(SpringLayout.WEST, ansL, 10,
                            SpringLayout.WEST, this);


        tp = new JTabbedPane();

        rightP = new JPanel(new GridBagLayout());
        JScrollPane rightpscroll = new JScrollPane(rightP);
        rightpscroll.getVerticalScrollBar().setUnitIncrement(unitInc_scroll);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(5,0,5,0);


        wrongP = new JPanel(new GridBagLayout());
        JScrollPane wrongpscroll = new JScrollPane(wrongP);
        wrongpscroll.getVerticalScrollBar().setUnitIncrement(unitInc_scroll);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(5,0,5,0);

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

        add(tp);

    }

    public void save(String author){

    }
}
