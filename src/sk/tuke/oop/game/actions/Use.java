package sk.tuke.oop.game.actions;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.Usable;
import sk.tuke.oop.game.actors.openables.Openable;

/**
 * Created by zezul on 05.01.2018.
 */
public class Use implements Action {

    private Actor actor;
    private Actor actuator;

    public Use(Actor actor, Actor actuator) {
        this.actor = actor;
        this.actuator = actuator;
    }

    public void execute() {
        if (actor instanceof Usable) {
            ((Usable) actor).useBy(actuator);
        }
        if(actor instanceof Openable){
            Openable openable = (Openable) this.actor;
            if(((Openable) actor).isOpen()){
                openable.open();
            }else {
                openable.close();
            }
        }
    }
}
