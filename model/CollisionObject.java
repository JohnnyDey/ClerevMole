package model;

public abstract class CollisionObject  extends GameObject{
    public CollisionObject(int x, int y) {
        super(x, y);
    }
    public boolean isCollision(GameObject gameObject, Direction direction){
        switch (direction){
            case LEFT:
                if(getX()  - FIELD_SELL_SIZE == gameObject.getX() && getY() == gameObject.getY()) return true;
                break;
            case RIGHT:
                if(getX() + FIELD_SELL_SIZE  == gameObject.getX() && getY() == gameObject.getY()) return true;
                break;
            case UP:
                if(getY() - FIELD_SELL_SIZE == gameObject.getY() && getX() == gameObject.getX()) return true;
                break;
            case DOWN:
                if(getY() + FIELD_SELL_SIZE == gameObject.getY() && getX() == gameObject.getX()) return true;
                break;
        }
        return false;
    }
}
