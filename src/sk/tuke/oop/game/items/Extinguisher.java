package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Usable;

public class Extinguisher  extends AbstractActor implements Usable, Item {
    private Animation animation;


    public Extinguisher () {
        super("extinguisher ");
        animation = new Animation("sprites/extinguisher.png",16,16);
        setAnimation(animation);

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

    }
}
