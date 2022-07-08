package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;



//  Project : 5NotesToTxt

public class Main
{
    public static void main(String[] args) throws IOException {
        
        // User-input and Scanner Class. Needed for dynamic note creation.
        /*
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Scanner scr = new Scanner(System.in);
        */
        NoteMgr noteMgr = new NoteMgr();
        FileMgr fileMgr = new FileMgr();

        // Create notes
        noteMgr.createNote("dolor", "amet, consetetur  dolor sit amet, consetetur  Lorem Lorem");
        noteMgr.createNote("Lorem", "consetetur  dolor sit amet, consetetur  LoremLorem ipsu");
        noteMgr.createNote("amet", "ipsum dolor ");
        noteMgr.createNote("consetetur", "dolor sit amet, dolor sit amet, consetetur  Lorem consetetur ");
        noteMgr.createNote("sit amet", "ipsum dolor dolor sit amet, consetetur  Lorem");
        noteMgr.createNote("Lirum larum", "Lorem ipsum dolor sit amet, consetetur  Lorem ipsum dolor sit amet.");

        // Read Notes

        ArrayList<Note> fileNotes;
        fileNotes = noteMgr.getNote_list();

        // Create files
        
        for (int i = 1; i < fileNotes.size(); i++) 
        {
            fileMgr.createFile(i);
            String temp_timestamp = fileNotes.get(i).getTimestamp().toString();
            temp_timestamp = temp_timestamp.substring(0, 16); // Cutting our seconds
            fileMgr.writeToFile(i, fileNotes.get(i));
        }
        
        /*
        // Delete files
        
        int delete_id = 3
        fileMgr.DeleteFile(delete_id);
        System.out.println();
        System.out.println(" -------- File " + delete_id + " deleted -------- ");
*/
        
        // File infos
        System.out.println();
        for (int i = 1; i < fileNotes.size(); i++) {

            System.out.println(" ---------------------File_" + i + " -------- ");
            fileMgr.readFile(i);
            fileMgr.GetFileInfo(i);
            System.out.println(" ------------------------- ");
            System.out.println();
            System.out.println();

        }


    }// main function

    }// class main






