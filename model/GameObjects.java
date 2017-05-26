package model;

import java.util.HashSet;
import java.util.Set;

public class GameObjects {
    private Set<Wall> walls;
    private Set<Box> boxes;
    private Set<Home> homes;
    private Player player;

    public GameObjects(Set<Wall> walls, Set<Box> boxes, Set<Home> homes,Player player) {
        this.walls = walls;
        this.homes = homes;
        this.boxes = boxes;
        this.player = player;
    }
    public Set<Wall> getWalls() {
        return walls;
    }
    public Set<Home> getHomes() {
        return homes;
    }
    public Set<Box> getBoxes() {
        return boxes;
    }
    public Player getPlayer() {
        return player;
    }
    public Set<GameObject> getAll(){
        Set<GameObject> set = new HashSet<>();
        set.addAll(walls);
        set.addAll(boxes);
        set.addAll(homes);
        set.add(player);
        return set;
    }
}
