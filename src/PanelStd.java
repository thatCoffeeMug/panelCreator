import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
class PanelStd extends JPanel{
private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);

JPanel questPanel;
    JLabel questLabel;
    JTextField questText;

JTabbedPane tp;

JScrollPane scrollAns;
JPanel ansPanelGroup;
        JPanel[] ansPanel = new JPanel[10];
            JLabel[] rightLabel = new JLabel[10];
            JTextField[] rightText = new JTextField[10];

JScrollPane scrollWrg;
JPanel wrgPanelGroup;
    JPanel[] wrgPanel = new JPanel[6];
    JLabel[] wrgLabel = new JLabel[6];
    JTextField[] wrgText = new JTextField[6];


Dimension dims = new Dimension(5,28);

    // Creates a new JPanel with a double buffer and a flow layout.
    public PanelStd(){
        this(new FlowLayout(), true);
    }

    // Creates a new JPanel with a double buffer and a flow layout.
    public PanelStd(boolean isDoubleBuffered){
        this(new FlowLayout(), isDoubleBuffered);
    }

    // Creates a new JPanel with a double buffer and a flow layout.
    public PanelStd(LayoutManager layout){
        this(layout, true);
    }

    // Creates a new JPanel with a double buffer and a flow layout.
    public PanelStd(LayoutManager layout, boolean isDoubleBuffered){
        super(layout, isDoubleBuffered);

        questPanel = new JPanel();
        questPanel.setLayout(new GridBagLayout());
            questLabel = new JLabel("Pregunta:");
            questText = new JTextField(30);
            questText.setPreferredSize(dims);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;

        c.gridx = 0;
        c.gridy = 0;
        questPanel.add(questLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        questPanel.add(questText,c);

        tp = new JTabbedPane();

        ansPanelGroup = new JPanel(new GridBagLayout());
        scrollAns = new JScrollPane(ansPanelGroup);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.insets = WEST_INSETS;
            for(int i = 0; i < rightLabel.length; i++){
                    rightLabel[i] = new JLabel((i+1) + ":");
                    rightText[i] = new JTextField(20);
                    rightText[i].setPreferredSize(dims);

                c.gridx = 0;
                c.gridy = i;
                ansPanelGroup.add(rightLabel[i], c);

                c.gridx = 1;
                c.gridy = i;
                ansPanelGroup.add(rightText[i], c);
            }

        wrgPanelGroup = new JPanel(new GridBagLayout());
        scrollWrg = new JScrollPane(wrgPanelGroup);

        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.insets = WEST_INSETS;
            for(int i = 0; i < wrgPanel.length; i++){
                wrgPanel[i] = new JPanel(new FlowLayout(FlowLayout.CENTER, 7, 7));

                wrgLabel[i] = new JLabel((i+1) + ":");
                wrgText[i] = new JTextField(20);

                wrgText[i].setPreferredSize(dims);

                c.gridx = 0;
                c.gridy = i;
                wrgPanelGroup.add(wrgLabel[i], c);

                c.gridx = 1;
                c.gridy = i;
                wrgPanelGroup.add(wrgText[i], c);
            }
        tp.add("Correctas", scrollAns);
        tp.add("Incorrectas", scrollWrg);

        this.add(BorderLayout.NORTH, questPanel);
        this.add(BorderLayout.CENTER, tp);
    }

    public void save(){
        
    }
}
