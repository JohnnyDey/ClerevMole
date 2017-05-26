package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class Player extends CollisionObject implements Movable{
    public Player(int x, int y) {
        super(x, y);
    }
    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }
    @Override
    public void draw(Graphics graphics) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File("src/res/pl.png"));
            graphics.drawImage(bufferedImage, getX(), getY(),getWidth(),getHeight(), null);
        } catch (IOException e) {
            e.printStackTrace();
            graphics.setColor(Color.BLACK);
            graphics.drawOval(getX(), getY(), getWidth(), getHeight());
            graphics.setColor(Color.YELLOW);
            graphics.fillOval(getX(), getY(), getWidth()-1, getHeight()-1);
        }
    }
}
