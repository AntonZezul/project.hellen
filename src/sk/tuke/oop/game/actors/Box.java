package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.Extinguisher;


public class Box extends AbstractActor implements Usable {
    private Animation animation;
    private Extinguisher extinguisher;

    public Box() {
        super("box");
        animation = new Animation("sprites/box_large.png", 16, 16);
        setAnimation(animation);
        animation.stop();
    }

    public boolean intersects(Actor actor) {
        if (((getX() + animation.getWidth()>actor.getX()) && (getX() < actor.getX()+actor.getWidth())) && ((getY() + animation.getHeight()>actor.getY() && getY() < actor.getHeight()+actor.getY()))){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void act() {

    }

    @Override
    public void useBy(Actor actor) {
        getWorld().removeActor(this);
        extinguisher = new Extinguisher();
        extinguisher.setPosition(getX(),getY());
        getWorld().addActor(extinguisher);
    }
}
