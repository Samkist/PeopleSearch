package me.Samkist.People;

import BreezySwing.GBDialog;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import me.Samkist.Sort.Sorter;

import javax.swing.*;

/**
 * Created by Samkist
 * https://github.com/Samkist
 */
public class Print extends GBDialog {
    private JList<String> list = addList(0, 0, 1, 1);

    public Print(JFrame jFrame) {
        super(jFrame);

        DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
        new Sorter<Person>(People.getPeople(), "normal").get().forEach(
                p -> model.addElement(p.getName() + " - " + p.getAge())
        );

        setTitle("Print People");
        setSize(400, 400);
        setVisible(true);
    }
}
