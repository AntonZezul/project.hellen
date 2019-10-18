package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;


public class AccessCard extends AbstractActor implements Item, Usable {
private Animation animation;


    public AccessCard(){
        super("card");
        animation = new Animation("sprites/key.png",16,16);
        setAnimation(animation);
    }




    @Override
    public void useBy(Actor actor) {

    }

    @Override
    public boolean intersects(Actor actor) {
        if (((getX() + animation.getWidth() > actor.getX()) && (getX() < actor.getX()+actor.getWidth())) && ((getY() + animation.getHeight()>actor.getY() && getY() < actor.getHeight()+actor.getY()))){
            return true;
        }
        return false;
    }
}
