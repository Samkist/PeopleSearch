package me.Samkist.People;

import BreezySwing.GBDialog;
import BreezySwing.IntegerField;

import javax.swing.*;

/**
 * Created by Samkist
 * https://github.com/Samkist
 */
public class EditPeople extends GBDialog {

    private JButton addPerson = addButton("Add Person", 1, 1, 1, 1);
    private JButton removePerson = addButton("Remove Person", 1, 2, 1, 1);
    private JLabel nameLabel = addLabel("Name: ", 2, 1, 1,1);
    private JTextField nameField = addTextField("", 2, 2, 1, 1);
    private JLabel ageLabel = addLabel("Age", 3, 1, 1, 1);
    private IntegerField ageField = addIntegerField(0, 3, 2, 1, 1);

    private JList<String> peopleList = addList(0, 3, 1, 3);
    private JTextArea personInfo = addTextArea("", 0,4, 1, 3);

    public EditPeople(JFrame jFrame) {
        super(jFrame);


        personInfo.setEditable(false);
        updateList();
        if(People.getPeople().size() > 0)
            peopleList.setSelectedIndex(0);
        setTitle("Edit People");
        setSize(1200, 400);
        setVisible(true);
    }

    private void updateList() {
        DefaultListModel<String> model = (DefaultListModel<String>) peopleList.getModel();
        model.clear();
        People.getPeople().forEach(p -> model.addElement(p.getName()));
    }
    private void updateInfo(Person p) {
        personInfo.setText(p.toString());
    }

    @Override
    public void listItemSelected(JList<String> jList) {
        if(!jList.equals(peopleList)) return;
        Person p = People.getPeople().get(jList.getSelectedIndex());
        updateInfo(p);
    }

    @Override
    public void listDoubleClicked(JList<String> jList, String s) {
        //
    }

    @Override
    public void buttonClicked(JButton jButton) {

        if(jButton.equals(addPerson)) {
            if(ageField.getNumber() < 0) {
                messageBox("Invalid age");
                return;
            }
            if(nameField.getText() == null) {
                messageBox("Invalid name");
                return;
            }
            People.addPerson(new Person(nameField.getText(), ageField.getNumber()));
            messageBox("Person: " + nameField.getText() + " created with age: " + ageField.getNumber());
            updateList();
        }

        if(jButton.equals(removePerson)) {
            People.removePerson(People.getPeople().get(peopleList.getSelectedIndex()));
            messageBox(peopleList.getSelectedValue() + " has been removed from the people list.");
            updateList();
        }
    }
}
