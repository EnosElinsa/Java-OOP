package oop.homework.utilrate;

import java.io.*;
import java.util.ArrayList;

public class Input {
    private final String directory;
    private ArrayList<String> input;

    public Input(String directory) {
        this.directory = directory;
        this.input = new ArrayList<>();
        initializeInput();
    }

    private void initializeInput() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(directory));
            String line;
            while ((line = in.readLine()) != null) {
               input.add(line);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    
    public String getDirectory() {
        return directory;
    }

    public ArrayList<String> getInput() {
        return input;
    }
}
