package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.*;

public class Door extends AbstractActor implements Openable,Usable, Observable {
private Animation animation;
private boolean open;


    public Door(String name, boolean vertical) {
        super(name);
        open = false;
        if(vertical){
            animation = new Animation("sprites/vdoor.png",16, 32, 100);
        }
        else {
            animation = new Animation("sprites/hdoor.png", 32, 16, 100);
        }
        setAnimation(animation);
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

    @Override
    public void useBy(Actor actor) {
        if(open)close();
        else open();
    }

    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }
}
