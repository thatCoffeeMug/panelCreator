//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// JButton b=new JButton(new ImageIcon("D:\\icon.png"));
class panelCreator implements ActionListener{

    // Select type of panel to create
    final static String[] types = {"Estándar", "De imágenes"};

    // General layout for window
    JFrame frame;
    CardLayout card;                        // Layout Manager to switch between
                                            // different types of panels in the
                                            // show

    JMenuBar mb;                            // Top menu bar

    JPanel mPanel;                          // Buttons and components to create
                                            // a panel
        JPanel chooserPanel;
            JLabel typeLabel;
            JComboBox<String> optionsTypes; // Selects type of panel
        JPanel creatorPanel;

            PanelStd stdPanel;              // Standard type of panel

            JPanel imgPanel;                // Images type of panel

    JPanel saveClosePanel;                  // Bottom buttons to save or close
        JButton saveB;
        JButton closeB;

    public static void main(String args[]) {
        new panelCreator();                 // New instance of frame
    }

    public panelCreator(){

        //Creating the Frame
        frame = new JFrame("Create panel");                     // Make frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // "X" to close
        frame.setSize(400, 650);                                // Set size
        frame.setLocationRelativeTo(null);                      // Center frame

        card = new CardLayout();

        //Creating the MenuBar and adding components
        mb = new JMenuBar();

            JMenu m1 = new JMenu("FILE");

                JMenuItem m11 = new JMenuItem("Open");
                m1.add(m11);
                JMenuItem m22 = new JMenuItem("Save as");
                m1.add(m22);

            JMenu m2 = new JMenu("Help");

        mb.add(m1);
        mb.add(m2);

        // Panel type selector
        mPanel = new JPanel();
        mPanel.setLayout(new BoxLayout (mPanel, BoxLayout.Y_AXIS));
            chooserPanel = new JPanel();
                typeLabel = new JLabel("Tipo:");
                optionsTypes = new JComboBox<String>(types);
                optionsTypes.addActionListener(this);
            chooserPanel.add(typeLabel);
            chooserPanel.add(optionsTypes);

            // Panel creator
            creatorPanel = new JPanel(card);

                stdPanel = new PanelStd(new BorderLayout());

                imgPanel = new JPanel();

            creatorPanel.add(types[0], stdPanel);
            creatorPanel.add(types[1], imgPanel);

        mPanel.add(chooserPanel);
        mPanel.add(creatorPanel);

        // Save and close options at bottom
        saveClosePanel = new JPanel();
            saveB = new JButton("Save");
            saveB.addActionListener(this);

            closeB = new JButton("Close");
            closeB.addActionListener(this);

        saveClosePanel.add(saveB);
        saveClosePanel.add(closeB);

        //Creating the panel at bottom and adding components
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, mPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, saveClosePanel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
            if(e.getSource() == saveB){ // saveB
                // stdPanel.save((String) optionsTypes.getSelectedItem());
                String label = (String) optionsTypes.getSelectedItem();
                if(label == types[0]){
                    stdPanel.save();
                } else {
                    
                }
            }
            else if(e.getSource() == closeB){ // closeB
                frame.dispose();
            }
            else if(e.getSource() == optionsTypes){
                card.show(creatorPanel, (String) optionsTypes.getSelectedItem());
            }

    }
}
