package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.*;
import sk.tuke.oop.game.actors.enemies.Enemy;

public class BlockedDoor extends AbstractActor implements Enemy, Alive {
    private Animation animation;
    private Health health;


    public BlockedDoor() {
        super("blocked door");
        animation = new Animation("sprites/vdoor.png",16,32,100);
        setAnimation(animation);
        health = new Health(100);

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
        if(getHealth().getValue() > 1){
            this.getWorld().setWall(this.getX() / 16,this.getY() / 16,true);
        }

        else{
            this.getWorld().setWall(this.getX() / 16,this.getY() / 16,false );
            getWorld().removeActor(this);

        }
    }



    @Override
    public Health getHealth() {
        return health;
    }
}
