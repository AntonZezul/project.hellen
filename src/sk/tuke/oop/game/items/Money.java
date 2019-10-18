package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Usable;

public class Money extends AbstractActor implements Usable, Item {
    private Animation animation;

    public Money() {
        super("money");
        animation = new Animation("sprites/money.png",16,16);
        setAnimation(animation);
        setPosition(150,175);
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
