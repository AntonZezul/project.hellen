package sk.tuke.oop.game.actors.enemies;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actions.Move;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Alive;
import sk.tuke.oop.game.actors.Health;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.ripley.Ripley;

import java.util.Random;

/**
 * Created by zezul on 27.12.2017.
 */
public class SpitAlien extends AbstractActor implements Movable,Enemy,Alive {
    private Animation animation;
    private Health health;
    private int i;
    private int number;
    private Random random;


    public SpitAlien(){
        super("SpitAlien");
        animation = new Animation("sprites/spit_alien.png", 32, 32, 100);
        setAnimation(animation);
        i = 0;
        number = 2;
        random = new Random();
        setPosition(200,200);
        health = new Health(100);
    }



    @Override
    public void act() {

        if (i != 100) {
            animation.stop();
            i++;
            if (number == 0) {
                Move move = new Move(this, 1, 0, -1);
                move.execute();
            }
            if (number == 1) {
                Move move = new Move(this, 1, 0, 1);
                move.execute();
            }
            if (number == 2) {
                Move move = new Move(this, 1, 1, 0);
                move.execute();
            }
            if (number == 3) {
                Move move = new Move(this, 1, -1, 0);
                move.execute();
            }
        } else {
            number = random.nextInt(4);
            i = 0;
        }

        for(Actor actor : getWorld()){
            if(actor instanceof Ripley && this.intersects(actor)) {
                Ripley ripley = (Ripley) actor;
                ripley.getHealth().drain(1);
                break;
            }
        }
        if(getHealth().getValue() < 1){
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
    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    @Override
    public void collidedWithWall() {

    }
}
