package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.*;

import sk.tuke.oop.game.items.*;

public class Computer extends AbstractActor implements Usable, Observable {
    private Animation animation;
    private boolean turn;

    public Computer() {
        super("computer");
        setTurn(false);
        animation = new Animation("sprites/computer.png", 80, 48, 100);
        setAnimation(animation);
        animation.stop();
    }

    @Override
    public void useBy(Actor actor) {
        if(isTurn()){
            animation.stop();
            setTurn(false);
        }else{
            animation.start();
            setTurn(true);
        }
    }

    @Override
    public void act() {

    }

    @Override
    public boolean intersects(Actor actor) {
        if (((getX() + animation.getWidth() > actor.getX()) && (getX() < actor.getX()+actor.getWidth())) && ((getY() + animation.getHeight()>actor.getY() && getY() < actor.getHeight()+actor.getY()))){
            return true;
        }
        return false;

    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    @Override
    public void addObserver(Observer observer) {
        observer.giveNotice();
    }

    @Override
    public void removeObserver(Observer observer) {

    }
}
