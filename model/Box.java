package model;


import java.awt.*;

public class Box extends CollisionObject implements Movable{
    public Box(int x, int y) {
        super(x, y);
    }
    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }
    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.drawRect(getX(), getY(), getWidth(), getHeight());
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}
