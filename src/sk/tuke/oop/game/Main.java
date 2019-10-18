package sk.tuke.oop.game;

import sk.tuke.oop.framework.SlickWorld;
import sk.tuke.oop.game.actors.*;
import sk.tuke.oop.game.actors.openables.Door;
import sk.tuke.oop.game.actors.openables.SmallFire;
import sk.tuke.oop.game.actors.ripley.Ripley;


public class Main {

    /**
     * The application's entry point.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SlickWorld world = new SlickWorld("Aliens", 800, 600);
        GameActorFactory actorFactory = new GameActorFactory();
//        Ripley ripley = new Ripley();
//       world.addActor(ripley);
//        Alien alien = new Alien();
//        world.addActor(alien);
//          AlienMother alienMother = new AlienMother();
//          world.addActor(alienMother);
//        SpitAlien spitAlien = new SpitAlien();
//        world.addActor(spitAlien);
//        world.addActor(alien);
//        Energy energy = new Energy();
//        world.addActor(energy);
       // Ammo ammo = new Ammo();
       // world.addActor(ammo);
//       Hammer hammer = new Hammer();
//        world.addActor(hammer);
////        Wrench wrench = new Wrench();
////        world.addActor(wrench);
//        Ventilator ventilator = new Ventilator();
//        world.addActor(ventilator);
//        Body body = new Body();
//        world.addActor(body);
//        Locker2 locker = new Locker2();
//        world.addActor(locker);
//        SmallFire smallFire = new SmallFire();
//        world.addActor(smallFire);
//        Door door = new Door("door",true);
//        world.addActor(door);

        world.setFactory(actorFactory);
        world.setMap("levels/map.tmx");
        world.run();



    }



}
