package img;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FilenameUtils;

public class ImgFile{

File[] rightFile = new File[10];
File[] wrongFile = new File[6];
String quest;
String author;
PanelImg panel;

FileOutputStream fos = null;
ZipOutputStream zipOut = null;
FileInputStream fis = null;

    public ImgFile(File[] rightFile, File[] wrongFile,
                        String quest, String author, PanelImg panel){
        this.rightFile = rightFile;
        this.wrongFile = wrongFile;
        this.quest = quest;
        this.author = author;
        this.panel = panel;
    }

    public int saveTXT(){

        final String userDir = System.getProperty("user.dir");
        final JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Guardar TXT...");
        fc.setCurrentDirectory(new File(userDir));

        try{
            int returnVal = fc.showSaveDialog(this.panel);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.

                if (FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("txt")) {
                    // filename is OK as-is
                } else {
                    file = new File(file.toString() + ".txt");  // append .xml if "foo.jpg.xml" is OK
                    file = new File(file.getParentFile(), FilenameUtils.getBaseName(file.getName())+".txt"); // ALTERNATIVELY: remove the extension (if any) and replace it with ".xml"
                }

                    if(file.exists()){
                        int a=JOptionPane.showConfirmDialog(this.panel,
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


    public void compileFile(FileWriter myWriter) throws IOException{
        myWriter.write("1.author=" + author + ";\n");
        myWriter.write("1.type=" + "img" + ";\n");

        for(int i = 0; i < rightFile.length; i++){
            myWriter.write("1.item" + (i+1) + "=" + rightFile[i].getName() + "#1;\n");
        }

        for(int i = 0; i < wrongFile.length; i++){
            myWriter.write("1.item" + (i+rightFile.length+1) + "=" + wrongFile[i].getName() + "#0;\n");
        }

    }


    public int saveZip(){
        try {
            final String userDir = System.getProperty("user.dir");
            final JFileChooser fc = new JFileChooser();
             fc.setDialogTitle("Guardar ZIP...");
            fc.setCurrentDirectory(new File(userDir));

            int returnVal = fc.showSaveDialog(this.panel);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File zipFile = fc.getSelectedFile();
                //This is where a real application would open the file.

                if (FilenameUtils.getExtension(zipFile.getName()).equalsIgnoreCase("zip")) {
                    // filename is OK as-is
                } else {
                    zipFile = new File(zipFile.toString() + ".zip");  // append .xml if "foo.jpg.xml" is OK
                    zipFile = new File(zipFile.getParentFile(), FilenameUtils.getBaseName(zipFile.getName())+".zip"); // ALTERNATIVELY: remove the extension (if any) and replace it with ".xml"
                }

                    if(zipFile.exists()){
                        int a=JOptionPane.showConfirmDialog(this.panel,
                            "¿Seguro que quiere sobreescribir este archivo?",
                            "Aviso",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.WARNING_MESSAGE);
                        if(a==JOptionPane.CANCEL_OPTION){
                            return -2;
                        }
                    }
                    zipFile.createNewFile();

                    fos = new FileOutputStream(zipFile);
                    zipOut = new ZipOutputStream(new BufferedOutputStream(fos));


                    addFiles(rightFile);
                    addFiles(wrongFile);

                    zipOut.close();
                    System.out.println("Done... Zipped the files...");
                } else {
                    return -1;
                }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try{
                if(fos != null) fos.close();
            } catch(Exception ex){

            }
        }

        return 0;
        }


    private void addFiles(File[] files) throws IOException, FileNotFoundException{
        for(int i = 0; i < files.length; i++){
            fis = new FileInputStream(files[i]);
            ZipEntry ze = new ZipEntry(files[i].getName());
            System.out.println("Zipping the file: " + files[i].getName());
            zipOut.putNextEntry(ze);
            byte[] tmp = new byte[4*1024];
            int size = 0;
            while((size = fis.read(tmp)) != -1){
                zipOut.write(tmp, 0, size);
            }
            zipOut.flush();
            fis.close();
        }
    }

}
