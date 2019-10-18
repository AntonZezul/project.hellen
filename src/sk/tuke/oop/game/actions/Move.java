package sk.tuke.oop.game.actions;

import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.weapons.Bullet;


/**
 * Created by zezul on 28.12.2017.
 */
public class Move implements Action {
    private Movable actor;
    private int step,dx,dy;


    public Move(Movable actor, int step, int dx, int dy){
        this.actor=actor;
        this.step=step;
        this.dx=dx;
        this.dy=dy;
    }

    public void izmeneniePovorota(int rotation){
        if(actor.getAnimation().getRotation()!=rotation)
            actor.getAnimation().setRotation(rotation);
    }


    public void execute() {
        int x = actor.getX();
        int y = actor.getY();
        actor.setPosition(actor.getX() + dx * step, actor.getY() + dy * step);
        if (dx == 1 && dy == 1) {
            izmeneniePovorota(135);

            actor.getAnimation().start();
        } else if (dx == 1 && dy == -1) {
            izmeneniePovorota(45);

            actor.getAnimation().start();
        } else if (dx == -1 && dy == 1) {
            izmeneniePovorota(225);

            actor.getAnimation().start();
        } else if (dx == -1 && dy == -1) {
            izmeneniePovorota(315);

            actor.getAnimation().start();
        } else if (dx == 0 && dy == 1) {
            izmeneniePovorota(180);
            actor.getAnimation().start();
        } else if (dx == 0 && dy == -1) {
            izmeneniePovorota(0);

            actor.getAnimation().start();
        } else if (dx == 1 && dy == 0) {
            izmeneniePovorota(90);

            actor.getAnimation().start();
        } else if (dx == -1 && dy == 0) {
            izmeneniePovorota(270);

            actor.getAnimation().start();
        }


            if (dx == 0 && dy == 0) {
                actor.getAnimation().stop();
            }

        if(actor.getWorld().intersectWithWall(actor) && !(actor instanceof Bullet)){
            actor.setPosition(actor.getX() - step * dx, actor.getY() - step * dy);
        }
        }



}
