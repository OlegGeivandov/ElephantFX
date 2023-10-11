package com.example.elephantfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class HelloController {

    @FXML private Label el1;
    @FXML private Label el2;
    @FXML private Label el3;
    @FXML private Label el4;
    @FXML private Label el5;
    @FXML private Label el6;
    @FXML private Label el7;
    @FXML private Label el8;

    @FXML private Label hu1;
    @FXML private Label hu2;
    @FXML private Label hu3;
    @FXML private Label hu4;
    @FXML private Label hu5;
    @FXML private Label hu6;
    @FXML private Label hu7;

    @FXML
    Button btnLoad;

    @FXML
    public ArrayList<ArrayList> loadPairs() throws IOException {
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(null);
        List<String> list = Files.readAllLines(file.toPath());
        list.remove(0);
        ArrayList<ArrayList> listOfPairs = new ArrayList<>();
        for (String s: list     ) {
            String[] words = s.split(", ");
            Elephant el = new Elephant(words[0], Integer.parseInt(words[1]),
                    words[2], Integer.parseInt(words[3]));
            Human chel = new Human(words[4], words[5], Integer.parseInt(words[6]));
            ArrayList pair = new ArrayList();
            pair.add(el);
            pair.add(chel);
            listOfPairs.add(pair);
        }
        searchForDoubleHumanForElephant(listOfPairs);
        return listOfPairs;
    }

    private void searchForDoubleHumanForElephant(ArrayList<ArrayList> pairs) {
        HashMap<Elephant, Human> elHuMap = new HashMap<>();
        for (ArrayList pair: pairs) {
            Elephant el = (Elephant) pair.get(0);
            Human chel = (Human)pair.get(1);
            if(elHuMap.containsKey(el) && !elHuMap.get(el).equals(chel) )
                System.out.println("кажется, у слона "+el+" не один владелец");
            else
                elHuMap.put(el, chel);
        }
        searchForUniqueElephantAndHuman(elHuMap);
    }

    private void searchForUniqueElephantAndHuman(HashMap<Elephant, Human> elHuMap){
        ArrayList<Elephant> uniqueElephantList = new ArrayList<>(elHuMap.keySet());
        el1.setText(uniqueElephantList.get(0).toString());
        el2.setText(uniqueElephantList.get(1).toString());
        el3.setText(uniqueElephantList.get(2).toString());
        el4.setText(uniqueElephantList.get(3).toString());
        el5.setText(uniqueElephantList.get(4).toString());
        el6.setText(uniqueElephantList.get(5).toString());
        el7.setText(uniqueElephantList.get(6).toString());
        el8.setText(uniqueElephantList.get(7).toString());

        HashSet<Human> humanHashSet = new HashSet<>(elHuMap.values());
        ArrayList<Human> uniqueHumanList = new ArrayList<>(humanHashSet);
        hu1.setText(uniqueHumanList.get(0).toString());
        hu2.setText(uniqueHumanList.get(1).toString());
        hu3.setText(uniqueHumanList.get(2).toString());
        hu4.setText(uniqueHumanList.get(3).toString());
        hu5.setText(uniqueHumanList.get(4).toString());
        hu6.setText(uniqueHumanList.get(5).toString());
        hu7.setText(uniqueHumanList.get(6).toString());
    }
}