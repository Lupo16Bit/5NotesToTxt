package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;



//  Project : 5NotesToTxt

public class Main
{
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);


        NoteMgr noteMgr = new NoteMgr();
        Scanner scr = new Scanner(System.in);
        FileMgr fileMgr = new FileMgr();

        // Notes erstellen
        noteMgr.createNote("dolor", "amet, consetetur  dolor sit amet, consetetur  Lorem Lorem");
        noteMgr.createNote("Lorem", "consetetur  dolor sit amet, consetetur  LoremLorem ipsu");
        noteMgr.createNote("amet", "ipsum dolor ");
        noteMgr.createNote("consetetur", "dolor sit amet, dolor sit amet, consetetur  Lorem consetetur ");
        noteMgr.createNote("sit amet", "ipsum dolor dolor sit amet, consetetur  Lorem");
        noteMgr.createNote("Lirum larum", "Lorem ipsum dolor sit amet, consetetur  Lorem ipsum dolor sit amet.");

        // Notes auslesen

        ArrayList<Note> fileNotes;
        fileNotes = noteMgr.getNote_list();

        // Dateien erstellen
        for (int i = 1; i < fileNotes.size(); i++) {
            fileMgr.createFile(i);
            String temp_timestamp = fileNotes.get(i).getTimestamp().toString();
            temp_timestamp = temp_timestamp.substring(0, 16); // Cutting our seconds
            fileMgr.writeToFile(i, fileNotes.get(i));
        }
        /*
        // Datei loeschen

        System.out.println();
        System.out.println(" -------- File 3 wird geloescht -------- ");
        fileMgr.DeleteFile(3);
        System.out.println(" -------- File ist geloescht ----------- ");
        System.out.println();
*/

        System.out.println("Files-Infos auslesen");
        for (int i = 1; i < fileNotes.size(); i++) {

            System.out.println(" ---------------------File_" + i+ " -------- ");
            fileMgr.readFile(i);
            fileMgr.GetFileInfo(i);
            System.out.println(" ------------------------- ");
            System.out.println();
            System.out.println();

        }


    }// main function

    }// class main






