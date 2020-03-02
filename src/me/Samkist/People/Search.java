package me.Samkist.People;

import BreezySwing.GBDialog;
import me.Samkist.ArrayList.ArrayList;
import me.Samkist.Sort.BinarySearch;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Samkist
 * https://github.com/Samkist
 */
public class Search extends GBDialog {

    private JTextField searchField = addTextField("", 1, 1, 2, 1);
    private JLabel checkCount = addLabel("Checks: 0", 2, 1, 1, 1);

    private ButtonGroup searchTypes = new ButtonGroup();
    private JRadioButton linearSearch = addRadioButton("Linear Search", 1, 3, 1, 1);
    private JRadioButton binarySearch = addRadioButton("Binary Search", 1, 4, 1, 1);
    private JList<String> results = addList(0, 2, 3, 1);

    public Search(JFrame jFrame) {
        super(jFrame);

        searchTypes.add(linearSearch);
        searchTypes.add(binarySearch);
        linearSearch.setSelected(true);
        searchField.addKeyListener(searchFieldKL);

        setSize(600, 400);
        setTitle("Search");
        setVisible(true);
    }

    private void updateList(ArrayList<Person> people) {
        DefaultListModel<String> model = (DefaultListModel<String>) results.getModel();
        model.clear();
        people.stream().map(Person::getNameAge).forEach(s -> model.addElement(s));
    }

    private KeyListener searchFieldKL = new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            ArrayList<Person> peopleResults;
            DefaultListModel<String> model = (DefaultListModel<String>) results.getModel();
            ArrayList<Person> resultArrayList = new ArrayList<>();
            AtomicLong counts = new AtomicLong();
            if(linearSearch.isSelected()) {
                People.getPeople().stream().filter(p -> {
                    boolean b = p.getName().contains(searchField.getText());
                    counts.getAndIncrement();
                    return b;
                }).forEach(resultArrayList::add);
                checkCount.setText("" + counts.get());
                updateList(resultArrayList);
            } else {
                BinarySearch<Person> binarySearch = null;
                try {
                    binarySearch = new BinarySearch<>(
                            People.getPeople(),
                            new Person(searchField.getText(), 0)
                    );
                    resultArrayList.add(binarySearch.get());
                    updateList(resultArrayList);
                    checkCount.setText("" + binarySearch.getChecks() );
                } catch(Exception ex) {

                }
            }
        }

    };
}
