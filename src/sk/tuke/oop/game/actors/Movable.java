package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;

/**
 * Created by zezul on 27.12.2017.
 */
public interface Movable extends Actor {
    default void collidedWithWall() {

    }
}
