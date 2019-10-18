package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.Hammer;

public class Locker extends AbstractActor implements Usable{
    private int uses = 1;
    private Animation animation;

    public Locker(){
        super("locker");
        animation = new Animation("sprites/locker.png", 16, 16);
        setAnimation(animation);
        setPosition(100,100);
    }
    @Override
    public void useBy(Actor actor) {
        Hammer hammer = new Hammer();
        if(actor instanceof Ripley && uses > 0){
            actor.getWorld().addActor(hammer);
            hammer.setPosition(this.getX()+16, this.getY());
            uses--;
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