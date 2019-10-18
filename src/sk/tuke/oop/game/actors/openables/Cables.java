package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Alive;
import sk.tuke.oop.game.actors.Health;
import sk.tuke.oop.game.actors.enemies.Enemy;

public class Cables extends AbstractActor implements Enemy,Alive,Openable {
    private Animation animation;
    private Health health;
    private boolean open;


    public Cables() {
        super("cables");
        animation = new Animation("sprites/cables.png", 48, 16);
        setAnimation(animation);
        health = new Health(100);
        open = false;

    }


    @Override
    public Health getHealth() {
        return health;
    }
    public void act(){

        if(getHealth().getValue() > 1){
            this.getWorld().setWall(this.getX() / 16,this.getY() / 16,true);
        }

        else{
            this.getWorld().setWall(this.getX() / 16,this.getY() / 16,false );
            getWorld().removeActor(this);

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

    }

    @Override
    public void close() {

    }

    @Override
    public boolean isOpen() {
        return open;
    }
}
