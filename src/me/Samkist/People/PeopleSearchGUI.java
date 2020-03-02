package me.Samkist.People;

import BreezySwing.GBFrame;
import me.Samkist.ArrayList.ArrayList;
import me.Samkist.Sort.BinarySearch;
import me.Samkist.Sort.Sorter;

import javax.swing.*;

/**
 * Created by Samkist
 * https://github.com/Samkist
 */
public class PeopleSearchGUI extends GBFrame {
    private static JFrame frame = new PeopleSearchGUI();
    private JButton editPeople = addButton("Edit People", 1, 1, 1, 1);
    private JButton searchPeople = addButton("Search People", 2, 1, 1,1);
    private JButton printPeople = addButton("Print People", 3, 1, 1, 1);


    public static void main(String[] args) {
        frame.setSize(400, 400);
        frame.setTitle("People Search");
        frame.setVisible(true);
    }

    @Override
    public void buttonClicked(JButton jButton) {
        if(jButton.equals(editPeople))
            new EditPeople(frame);
        if(jButton.equals(searchPeople))
            new Search(frame);
        if(jButton.equals(printPeople))
            new Print(frame);
    }
}
