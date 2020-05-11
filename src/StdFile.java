import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class StdFile{
    String[] correct_items = new String[10];
    String[] wrong_items = new String[6];
    final String type = "std";

    public StdFile(){}

    public StdFile(String[] correct_items,
                   String[] wrong_items){

        if(correct_items.length == this.correct_items.length){
            this.correct_items = correct_items;
        }

        if(wrong_items.length == this.wrong_items.length){
            this.wrong_items = wrong_items;
        }
    }

    public int set_correct(String[] correct_items){
        for(int i = 0; i < correct_items.length; i++){
            if(correct_items[i].equals("")){return -1;}
        }

        if(correct_items.length == this.correct_items.length){
            this.correct_items = correct_items;
            return 0;
        } else {return -1;}
    }

    public int set_wrong(String[] wrong_items){
        for(int i = 0; i < wrong_items.length; i++){
            if(wrong_items[i].equals("")){return -1;}
        }

        if(wrong_items.length == this.wrong_items.length){
            this.wrong_items = wrong_items;
            return 0;
        } else {return -1;}
    }

    public int saveFile(JFrame f){
        final String userDir = System.getProperty("user.dir");
        final JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(userDir));

        try{
            int returnVal = fc.showSaveDialog(f);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.

                    if(file.exists()){
                        int a=JOptionPane.showConfirmDialog(f,
                            "¿Seguro que quiere sobreescribir este archivo?",
                            "Aviso",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.WARNING_MESSAGE);
                        if(a==JOptionPane.CANCEL_OPTION){
                            return 0;
                        }
                    }
                    file.createNewFile();

                    FileWriter myWriter = new FileWriter(file);
                    compileFile(myWriter);
                    myWriter.close();


            } else {
                // Open command cancelled by user
                return 0;
            }
        } catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return 0;
    }

    public void compileFile (FileWriter myWriter) throws IOException{
        for(int i = 0; i < correct_items.length; i++){
            myWriter.write("item" + (i+1) + "=" + correct_items[i] + "#1;\n");
        }

        for(int i = 0; i < wrong_items.length; i++){
            myWriter.write("item" + (i+11) + "=" + wrong_items[i] + "#0;\n");
        }

    }
}
