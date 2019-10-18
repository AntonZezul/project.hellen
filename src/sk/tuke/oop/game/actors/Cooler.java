package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;


public class Cooler extends AbstractActor implements Usable {
    private Animation animation;
    private boolean repair;

    public Cooler() {
        super("cooler");
        animation = new Animation("sprites/fan.png",32,32,200);
        setAnimation(animation);
        repair = false;
    }


    @Override
    public boolean intersects(Actor actor) {
        if (((getX() + animation.getWidth() > actor.getX()) && (getX() < actor.getX()+actor.getWidth())) && ((getY() + animation.getHeight()>actor.getY() && getY() < actor.getHeight()+actor.getY()))){
            return true;
        }
        return false;
    }
    public void act() {
        if(this.repair){
            animation.start();
        }else {
            animation.stop();
        }
    }



    @Override
    public void useBy(Actor actor) {
        repair = true;
    }
}
