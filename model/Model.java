package model;

import controller.EventListener;
import static model.GameObject.FIELD_SELL_SIZE;

import java.nio.file.Paths;

public class Model {
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("src\\res\\levels.txt"));

    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level){
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart(){
        restartLevel(currentLevel);
    }

    public void startNextLevel(){
        restartLevel(++currentLevel);
    }

    public void move(Direction direction){
        if(checkWallCollision(gameObjects.getPlayer() ,direction)) return;
        if(checkBoxCollision(direction)) return;
        switch (direction){
            case LEFT:
                gameObjects.getPlayer().move(-FIELD_SELL_SIZE, 0);
                break;
            case RIGHT:
                gameObjects.getPlayer().move(FIELD_SELL_SIZE, 0);
                break;
            case DOWN:
                gameObjects.getPlayer().move(0, FIELD_SELL_SIZE);
                break;
            case UP:
                gameObjects.getPlayer().move(0, -FIELD_SELL_SIZE);
                break;
        }
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        for(Wall wall : gameObjects.getWalls()){
            if(gameObject.isCollision(wall, direction)) return true;
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction){
        Box stopBox = null;
        for(Box box : gameObjects.getBoxes()){
            if(gameObjects.getPlayer().isCollision(box, direction)) stopBox = box;
        }
        if(stopBox == null) return false;
        if(checkWallCollision(stopBox, direction)) return true;
        for(Box box : gameObjects.getBoxes()){
            if(stopBox.isCollision(box, direction)) return true;
        }
        switch (direction) {
            case LEFT:
                stopBox.move(-FIELD_SELL_SIZE, 0);
                break;
            case RIGHT:
                stopBox.move(FIELD_SELL_SIZE, 0);
                break;
            case UP:
                stopBox.move(0, -FIELD_SELL_SIZE);
                break;
            case DOWN:
                stopBox.move(0, FIELD_SELL_SIZE);
                break;
        }
        return false;
    }

    public void checkCompletion(){
wal:    for(Home w : getGameObjects().getHomes()){
            for(Box b: getGameObjects().getBoxes()){
                if(w.getX() == b.getX() && w.getY() == b.getY()) {
                    continue wal;
                }
            }
            return;
        }
        eventListener.levelCompleted(currentLevel);
    }
}
