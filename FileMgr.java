package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileMgr
{                           // The FileMgr class -    handles creating, deleting, reading text files which contain the note-topic,note-text,note-timestamp
                            //                                       -    gets  the file infos for debug-information

    private ArrayList<File> fileList;    // internal 'File' ArrayList for operating with text-files
    private Boolean needsSplit2;        // boolean in  limiting the line-lenght per text-file

    // Konstruktor

    public FileMgr()
    {
        this.fileList = new ArrayList<File>();
    }

    // GETTER / SETTER



    // Methoden

    public void createFile(int in_i)   // Creates a text file inside the main folder. Try-catch for pointing out problems.
    {
                //
        try
        {
            File myFile = new File("Note"+in_i+".txt");
            if (myFile.createNewFile())
            {
                System.out.println("FileMgr: File created: " + myFile.getName());
            } else {
                System.out.println("FileMgr: File : " + "Note"+ in_i +".txt" + " already exists.");
            }
        } catch (IOException e) {
            System.out.println("FileMgr: Lookup < 'FileMgr.java', method 'createFile()' >");
            e.printStackTrace();
        }
    }
    public void readAllFiles() // Reads all files from current fileList
    {
        try
        {
            for(int i = 0; i < this.fileList.size(); i++)
            {
                System.out.println("-----------------------------------");
                readFile(i+1);
                System.out.println("-----------------------------------");
            }

        }catch (Exception e)
        {
            {
                System.out.println("FileMgr: Lookup < 'Filemanager.java', method 'readAllFiles()' >");
                e.printStackTrace();
            }
        }
    }
    public void readFile(int in_i)
    {
        try
        {
            File myObj = new File("Note"+ in_i +".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("FileMgr: An error occurred. Lookup < 'Filemanager.java', method 'readFile()' >");
            e.printStackTrace();
        }
    }
    public void writeToFile(int in_i,Note in_Note) // Writes Topic,
    {
        try
        {

            FileWriter myWriter = new FileWriter("Note"+in_i+".txt"); // FileWriter class handles the writing operations.

            myWriter.write("Topic: " + in_Note.getTopic() + "                    " + "Date: " + in_Note.getTimestamp().toString().substring(0, 16));
            myWriter.write("\n");
            myWriter.write("\n");
            // implementing check for string length, cutting string using whitespaces for formatting the textfile we are writing in
            ArrayList<String> cut_Strings = new ArrayList<>();
            String tmp_in_Note_text = in_Note.getTxt();

            myWriter.write("Note: " + in_Note.getTxt());
            myWriter.close();
            System.out.println("FileMgr: Successfully wrote to the file.");
        } catch (IOException e)
        {
            System.out.println("FileMgr: An error occurred. Lookup < 'Filemanager.java', method 'writeToFile()' > '");
        }
    }
    public void GetFileInfo(int in_i) {
            File myObj = new File("Note"+in_i+".txt");
            if (myObj.exists()) {
                System.out.println("File name: " + myObj.getName());
                System.out.println("Absolute path: " + myObj.getAbsolutePath());
                System.out.println("Writeable: " + myObj.canWrite());
                System.out.println("Readable " + myObj.canRead());
                System.out.println("File size in bytes " + myObj.length());
            } else {
                System.out.println("FileMgr: The file does not exist.");
            }
        }
    public void DeleteFile(int in_i)
    {

            File myObj = new File("Note"+in_i+".txt");
            if (myObj.delete()) {
                System.out.println("FileMgr: Deleted the file: " + myObj.getName());
            } else {
                System.out.println("FileMgr: Failed to delete the file.");
            }
    }

    // Getter / Setter

}
