package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.ripley.Ripley;


public class Desk extends AbstractActor implements Usable {
private Animation animation;
    private int uses = 1;

    public Desk() {
        super("desk");
        animation = new Animation("sprites/desk.png", 48    , 48);
        setAnimation(animation);
    }

    @Override
    public void useBy(Actor actor) {

       AccessCard accessCard = new AccessCard();
        if(actor instanceof Ripley && uses > 0){
            actor.getWorld().addActor(accessCard);
            accessCard.setPosition(getX()+16, getY());
            uses--;
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
}
