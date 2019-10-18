package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Usable;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class SmallFire extends AbstractActor implements Openable,Usable {
    private Animation animation;
    private boolean open;

    public SmallFire() {
        super("small_fire");
        animation = new Animation("sprites/small_explosion.png",16,16,100);
        setAnimation(animation);
        setPosition(200,200);
        open = false;
    }

    public void act() {
        if(open){
            this.getWorld().setWall(this.getX() / 16,this.getY() / 16,false);
        }else{
            this.getWorld().setWall(this.getX() / 16,this.getY() / 16,true);
        }
    }


    @Override
    public void useBy(Actor actor) {

        if(actor instanceof Ripley) {
            this.getWorld().removeActor(this);
            open();

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

    @Override
    public void open() {
        open=true;
        getAnimation().stop();
    }

    @Override
    public void close() {

    }

    public boolean isOpen() {
        return open;
    }
}
