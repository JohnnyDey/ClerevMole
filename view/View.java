package view;

import controller.Controller;
import controller.EventListener;
import model.GameObjects;

import javax.swing.*;

public class View extends JFrame {
    private Controller controller;
    private Field field;

    public View(Controller controller) {
        this.controller = controller;

        setResizable(false);
    }

    public void setEventListener(EventListener eventListener){
        field.setEventListener(eventListener);
    }

    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);
        setTitle("Мудрый крот");
        setVisible(true);
    }
    public void update(){
        field.repaint();
    }
    public GameObjects getGameObjects(){
        return controller.getGameObjects();
    }
    public void completed(int level){
        update();
        JOptionPane.showMessageDialog(this, "Уровень " + level + " пройден!");
        controller.startNextLevel();
    }
}
