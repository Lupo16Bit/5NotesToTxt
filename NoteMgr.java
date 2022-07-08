package com.company;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;


public  class NoteMgr   //  Manages Interactions between User and  application
{
        public static int id_count;
        private ArrayList<Note> note_list;
        public NoteMgr()
        {
            this.note_list = new ArrayList<>();
        }

        // Not in use
        public void menu() // Displays the menu
        {
            System.out.println(" Notiz ...");
            System.out.println(" ...<1>  Notizen zeigen");
            System.out.println(" ...<2>  Notiz erstellen");
            System.out.println(" ...<3>   Notiz löschen ");
            System.out.println(" ...<4>   Beenden.");
            System.out.println(" ...<0>    HotKeys einblenden");
           // System.out.println(" ... 'quit' Beenden");
        }
        public void doWhileSCANNER() // Getting user input
        {
            Scanner scnnr = new Scanner(System.in);
            String input = "";
            do{
                input = scnnr.nextLine();
                System.out.println(input);
            } while(!input.equals("exit"));
            scnnr.close();
        }
        public void readNote_List() // Reads out a Note-List
        {
            try {
                for(int i = 0; i < note_list.size(); i++)
                {

                }
                for (int i = 0; i < getNote_list().size(); i++)
                {
                    note_list.get(i).setId(i);

                    String temp_timestamp = getNoteTimestamp(i).toString();

                    System.out.println(" Timestamp: " + temp_timestamp.substring(0, temp_timestamp.length() - 4) + " | ");
                    System.out.println( " Id : " + "    | " +  i + " | " );
                    System.out.println(" Topic: " + getNote_list().get(i).getTopic());
                    System.out.println(" Text : " + "     > " + getNote_list().get(i).getTxt() + " <\n");
                }
            }
            catch(Exception e)
            {
                System.out.println("NoteMgr: An error occurred. Lookup < 'NoteMgr.java', method 'readNoteList()' >");
            }
        }

        // GETTER & SETTER

        // IDs

        public int getId_count()
        {
            return id_count;
        }

        public void setId_count(int id_count)
        {
            id_count = SuperNote.id_count_SUPER;
        }

        //---------------------------------------------------------------------------------------------------------------------------

        //  ArrayLists

        public ArrayList<Note> getNote_list()
        {
            return this.note_list;
        }

        public void setNote_list(ArrayList<Note> note_list)
        {
            this.note_list = note_list;
        }

    //---------------------------------------------------------------------------------------------------------------------------

    // Methods
        public void createNote(String in_topic, String in_text) // Creates a Note
        {
            try
            {
                Note newNote = new Note(in_topic,in_text);
                note_list.add(newNote);
                System.out.println("NoteMgr: Note created");
            }
            catch(Exception e)
            {
                System.out.println("NoteMgr: An error occurred. Lookup < 'NoteMgr.java', method 'createNote()' >");
            }

        }
        /*
        public void createNote2() // Not used. Just an idea for later
        {
            try
            {
                Scanner scnner = new Scanner(System.in);
                System.out.println("Note-Text eingeben");


                Note newNote = new Note(scnner.nextLine());
                note_list.add(newNote);
                System.out.println(" Note erstellt ");
            }
            catch(Exception e)
            {
                System.out.println(" Erstellen nicht möglich");
            }

        }
*/
        public void removeNote(int in_index)
        {
            note_list.remove(in_index);
        }

        // GETTER / SETTER
        public String getNoteTopic(Note in_Note)
        {
            return in_Note.getTopic();
        }
        public String getNoteTxt(Note in_Note)
        {
            return in_Note.getTxt();
        }
        public Timestamp getNoteTimestamp(int in_id_2)
        {
                return note_list.get(in_id_2).getTimestamp();
        }
}

