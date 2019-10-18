package sk.tuke.oop.game.actors.enemies;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actions.Move;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Alive;
import sk.tuke.oop.game.actors.Health;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.openables.RepairDoor;
import sk.tuke.oop.game.actors.ripley.Ripley;

import java.util.Random;

public class Monster extends AbstractActor implements Movable,Enemy,Alive {
    private Animation animation;
    private Health health;
    private int i;
    private int number;
    private Random random;
    private boolean hunt;

    public Monster() {
        super("monster");
        animation = new Animation("sprites/monster.png", 72, 128, 100);
        setAnimation(animation);
        i = 0;
        number = 2;
        setHunt(false);
        random = new Random();
        setPosition(400,200);
        health = new Health(200);
    }


    @Override
    public void act() {
        for(Actor actor : getWorld()){
            if(actor instanceof RepairDoor){
                RepairDoor repairDoor = (RepairDoor) actor;
                setHunt(repairDoor.isOpen());
            }
        }
//        for(Actor actor : getWorld()){
//            if(actor instanceof Ripley && this.intersects(actor)){
//                    ((Ripley) actor).getHealth().drain(1);
//                }
//                if( isHunt()) {
//                    Ripley ripley = (Ripley)actor;
//                    if (ripley.getX() > getX()) {
//                        Move move = new Move(this, 1,1,0);
//                        move.execute();
//                        break;
//                    }
//                    if (ripley.getX() < getX()) {
//                        Move move = new Move(this, 1,-1,0);
//                        move.execute();
//                        break;
//                    }
//                    if (ripley.getY() > getY()) {
//                        Move move = new Move(this, 1,0,1);
//                        move.execute();
//                        break;
//                    }
//                    if (ripley.getY() < getY()) {
//                        Move move = new Move(this, 1,0,-1);
//                        move.execute();
//                        break;
//                    }
//                }else{
                    if (i != 100  ) {
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
//                }
//        }
        if(getHealth().getValue() < 1){
            getWorld().removeActor(this);
        }

    }
    @Override
    public Health getHealth() {
        return health;
    }

    @Override
    public boolean intersects(Actor actor) {
        if (((getX() + animation.getWidth()>actor.getX()) && (getX() < actor.getX()+actor.getWidth())) && ((getY() + animation.getHeight()>actor.getY() && getY() < actor.getHeight()+actor.getY()))){
            return true;
        } else {
            return false;
        }
    }

    public boolean isHunt() {
        return hunt;
    }

    public void setHunt(boolean hunt) {
        this.hunt = hunt;
    }
}
