package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Usable;




public class ExitDoor extends AbstractActor implements Openable, Usable {
    private Animation animation;
    private boolean open;

    public ExitDoor() {
        super("exit door");
        open = false;
        animation = new Animation("sprites/vdoor.png",16,32,100);
        setAnimation(animation);
        animation.stop();
    }

    public boolean intersects(Actor actor) {
        if (((getX() + animation.getWidth()>actor.getX()) && (getX() < actor.getX()+actor.getWidth())) && ((getY() + animation.getHeight()>actor.getY() && getY() < actor.getHeight()+actor.getY()))){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Updates the actor.
     */
    @Override
    public void act() {
        if(open){
            this.getWorld().setWall(this.getX() / 16,this.getY() / 16,false);

        }else{
            this.getWorld().setWall(this.getX() / 16,this.getY() / 16,true);
        }
    }

    @Override
    public void open() {
        if(!open) {
            this.open = true;
            animation.setLooping(false);
            animation.start();
        }
    }

    @Override
    public void close() {
        if(open) {
            this.open = false;
            animation.setLooping(false);
            animation.start();
        }
    }

    @Override
    public boolean isOpen() {
        return this.open;
    }

    @Override
    public void useBy(Actor actor) {
        if(open){
            close();
        }else{
            open();
        }
    }


}
