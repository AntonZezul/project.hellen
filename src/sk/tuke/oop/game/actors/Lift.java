package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Message;
import sk.tuke.oop.game.actors.ripley.Ripley;


public class Lift extends AbstractActor {
    private Message message;
    private Animation animation;


    public Lift() {
        super("lift");
        animation = new Animation("sprites/lift.png", 48, 48);
        setAnimation(animation);
    }

    @Override
    public void act() {
        for (Actor actor : getWorld()) {
            if (actor instanceof Ripley && this.intersects(actor)) {
                setMessage(new Message("WIN!!!", 100, 100));
                this.getWorld().showMessage(getMessage());


            }
        }
    }

    @Override
    public boolean intersects(Actor actor) {
        if (((getX() + animation.getWidth()>actor.getX()) && (getX() < actor.getX()+actor.getWidth())) && ((getY() + animation.getHeight()>actor.getY() && getY() < actor.getHeight()+actor.getY()))){
            return true;
        } else {
            return false;
        }
    }



    public Message getMessage() {
        return message;
    }


    public void setMessage(Message message) {
        this.message = message;
    }
}
