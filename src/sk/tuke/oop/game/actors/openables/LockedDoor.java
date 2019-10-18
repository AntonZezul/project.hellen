package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Usable;

public class LockedDoor extends AbstractActor implements Usable,Openable {
    private Animation animation;
    private boolean locked;
    private boolean open;

    public LockedDoor() {
        super("locked door");
        animation = new Animation("sprites/vdoor.png", 16, 32, 100);
        setAnimation(animation);
        locked = true;
        open = false;
        animation.stop();
    }

    @Override
    public boolean intersects(Actor actor) {
        if (((getX() + animation.getWidth()>actor.getX()) && (getX() < actor.getX()+actor.getWidth())) && ((getY() + animation.getHeight()>actor.getY() && getY() < actor.getHeight()+actor.getY()))){
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void useBy(Actor actor) {
        if(open)close();
        else open();
    }


    public void lock(){
        locked = true;
    }

    public void unlock(){
        locked = false;
    }

    public boolean isLocked(){
        return locked;
    }

    public void act() {
        if(open){
            this.getWorld().setWall(this.getX() / 16,this.getY() / 16,false);
        }else{
            this.getWorld().setWall(this.getX() / 16,this.getY() / 16,true);
        }
    }

    @Override
    public void open() {
        open=true;
        getAnimation().start();
        getAnimation().stopAt(3);
    }

    @Override
    public void close() {
        open=false;
        getAnimation().start();
        getAnimation().stopAt(0);
    }

    @Override
    public boolean isOpen() {
        return open;
    }
}