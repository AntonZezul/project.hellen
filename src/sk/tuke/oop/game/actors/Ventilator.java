package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;

/**
 * Created by zezul on 05.01.2018.
 */
public class Ventilator extends AbstractActor implements Usable {
    private boolean repair;
    private Animation animation;

    public Ventilator() {
        super("ventilator");
        animation = new Animation("sprites/ventilator.png", 32, 32,100);
        setAnimation(animation);
        repair = false;
        setPosition(300, 300);
    }


    @Override
    public boolean intersects(Actor actor) {
        if (((getX() + animation.getWidth() > actor.getX()) && (getX() < actor.getX() + actor.getWidth())) && ((getY() + animation.getHeight() > actor.getY() && getY() < actor.getHeight() + actor.getY()))) {
            return true;
        } else {
            return false;
        }
    }

        @Override
        public void useBy(Actor actor) {
            if(repair){
                repair = false;
            }else {
                repair = true;
            }
        }

    public void act() {
        if(repair){
            animation.start();
        }else{
            animation.stop();
        }
    }

}
