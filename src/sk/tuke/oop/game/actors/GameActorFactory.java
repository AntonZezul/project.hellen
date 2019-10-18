package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorFactory;
import sk.tuke.oop.game.actors.enemies.*;
import sk.tuke.oop.game.actors.openables.*;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.Ammo;
import sk.tuke.oop.game.items.Energy;


/**
 * Created by Tomash on 16.12.2017
 */
public class GameActorFactory implements ActorFactory{

    public GameActorFactory(){
    }



    public Actor create(String type, String name) {
        switch (name)
        {
            case "Ripley":
                return new Ripley();
            case "Alien":
                return new Alien();
            case "AlienMother":
                return new AlienMother();
            case "SpitAlien":
                return new SpitAlien();
            case "Lurker":
                return new Lurker();
              case "Monster":
                  return new Monster();
            case "Energy":
                 return new Energy();
            case "Ammo":
                return new Ammo();
            case "Door":
                return new Door("Door", true);
            case "Door1":
                return new Door("Door1", false);
            case "RepairDoor":
                return new RepairDoor();
            case "Locker":
                return new Locker();
            case "LockedDoor":
                return new LockedDoor();
            case "Box":
                return new Box();
            case "Body":
                return new Body();
            case "Computer":
                return new Computer();
            case "SmallFire":
                return new SmallFire();
            case "Cables":
                return new Cables();
            case "BlockedDoor":
                return new BlockedDoor();
            case "Desk":
                return new Desk();
            case "Lift":
                return new Lift();




        }
        return null;
    }
}
