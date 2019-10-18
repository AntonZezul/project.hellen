package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Health;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 * Created by zezul on 02.01.2018.
 */
public class Energy extends AbstractActor implements Item {
    private Animation animation;

    public Energy() {
        super("energy");
        animation = new Animation("sprites/energy.png", 16, 16);
        setAnimation(animation);
    }


    public void act() {
        for (Actor actor : getWorld()) {
            if(actor instanceof Ripley && this.intersects(actor)) {
                Ripley ripley = (Ripley) actor;
                if (ripley.getHealth().getValue() < 100) {
                    ripley.getHealth().restore();
                    this.getWorld().removeActor(this);
                    break;
                }
            }

        }
    }

    @Override
    public boolean intersects(Actor actor) {

        if (((getX() + animation.getWidth() > actor.getX()) && (getX() < actor.getX()+actor.getWidth())) && ((getY() + animation.getHeight()>actor.getY() && getY() < actor.getHeight()+actor.getY()))){
            return true;
        }
        return false;
    }
}