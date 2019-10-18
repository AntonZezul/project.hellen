package sk.tuke.oop.game.actors;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zezul on 02.01.2018.
 */
public abstract class AbstractActor implements Actor {
    private World world;
    private int x, y;
    private Animation animation;
    private String name;

    public AbstractActor(String name){
        this.name = name;
    }


    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return animation.getWidth();
    }

    @Override
    public int getHeight() {
        return animation.getHeight();
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Actor> getIntersectingActors(){
        List<Actor> actors = new ArrayList<>();
        for (Actor actor : getWorld()){
            if(this.intersects(actor))
                actors.add(actor);
        }
        return actors;
    }

    @Override
    public Animation getAnimation() {
        return animation;
    }

    @Override
    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    @Override
    public void act() {

    }

    public void addedToWorld(World world) {
        this.world = world;
    }

    public World getWorld() {
        return world;
    }

    @Override
    public String getName() {
        return name;
    }

    public String toString() {
        return getName() + " " + getWidth() + " " + getHeight();
    }


}
