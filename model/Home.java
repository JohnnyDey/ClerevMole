package model;

import java.awt.*;

public class Home extends GameObject{
    public Home(int x, int y) {
        super(x, y, 2, 2);

    }
    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.drawOval(getX() + (FIELD_SELL_SIZE - getWidth())/2, getY() +(FIELD_SELL_SIZE - getHeight())/2 , getWidth(), getHeight());
    }
}
