package model;

import java.awt.*;

public class Wall extends CollisionObject {

    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.drawRect(getX(), getY(), getWidth(), getHeight());
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}
