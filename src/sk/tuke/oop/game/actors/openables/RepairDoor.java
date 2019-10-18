package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.*;

public class RepairDoor extends AbstractActor implements Openable,Usable, Observable {
    private Animation animation;
    private boolean open;
    private boolean isTurn;


    public RepairDoor() {
        super("RepairDoor");
        open = false;
        animation = new Animation("sprites/vdoor.png",16, 32, 100);
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
        for(Actor actor : getWorld()){
            if(actor instanceof Computer){
                Computer computer = (Computer) actor;
                setTurn(computer.isTurn());
            }
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
        if (isTurn()) {
            if (open) close();
            else open();
        }
    }

    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }
    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }
}
