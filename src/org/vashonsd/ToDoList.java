package org.vashonsd;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static ArrayList<String> toDoList = new ArrayList<>();

    public ToDoList(){
    }
    public void MakeToDoList() {
        Scanner input = new Scanner(System.in);
        System.out.println("What do want me to put on your to do list? Say \"stop\" to stop.");
        String temp = "";
        while (!temp.equals("stop")) {
            temp = input.nextLine();
            toDoList.add(temp);
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            for (String i : toDoList) {
                writer.write(i + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void ViewList() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        System.out.println("Here is your to do list:");
        String line;
        int num = 1;
        while ((line = reader.readLine()) != null && !line.equals("stop")) {
            System.out.println(num + ". " + line);
            num++;
        }
        reader.close();
    }

    public void RemoveListItem() {
        Scanner input = new Scanner(System.in);
        System.out.println("What line would you like to remove?");
        int line = input.nextInt();
        toDoList.remove(line - 1);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            for (String i : toDoList) {
                writer.write(i + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void DeleteList() {
        int num = 0;
        for(String ignored : toDoList){
            toDoList.remove(num);
            num++;
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}