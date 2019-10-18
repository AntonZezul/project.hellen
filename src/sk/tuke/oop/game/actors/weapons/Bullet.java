package sk.tuke.oop.game.actors.weapons;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actions.Move;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Alive;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.enemies.Enemy;

public class Bullet extends AbstractActor implements Fireable,Movable {
    private Animation animation;
    private Move move;
    private boolean rocket;

    public Bullet(String name) {
        super(name);
        rocket = false;
        animation = new Animation("sprites/bullet.png", 16, 16);
        setAnimation(animation);
    }

    public Bullet() {
        super("bullet");
        rocket = false;
        animation = new Animation("sprites/bullet.png", 16, 16);
        setAnimation(animation);
    }

    @Override
    public Move setDirection(int angle) {
        if (angle == 135) {
            move = new Move(this, 4, 1, 1);
        }
        if (angle == 45) {
            move = new Move(this, 4, 1, -1);
        }
        if (angle == 225) {
            move = new Move(this, 4, -1, 1);
        }
        if (angle == 315) {
            move = new Move(this, 4, -1, -1);
        }
        if (angle == 180) {
            move = new Move(this, 4, 0, 1);
        }
        if (angle == 0) {
            move = new Move(this, 4, 0, -1);
        }
        if (angle == 90) {
            move = new Move(this, 4, 1, 0);
        }
        if (angle == 270) {
            move = new Move(this, 4, -1, 0);
        }
        return null;
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
    public void collidedWithWall(){

    }
    @Override
    public void act(){
        if(move == null){
            move = new Move(this,0,0,0);
            move.execute();
        }else{
            for (Actor actor : getWorld()) {
                if (actor instanceof Enemy && this.intersects(actor)) {
                    Alive alive = (Alive) actor;
                    if(rocket){
                        alive.getHealth().drain(100);
                    }else {
                        alive.getHealth().drain(25);
                    }
                    getWorld().removeActor(this);
                    break;
                }
            }
            if (this.getWorld().intersectWithWall(this)) {
                this.getWorld().removeActor(this);
                this.collidedWithWall();
            }
        }
        move.execute();
    }
}
