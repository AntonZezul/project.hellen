package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;

/**
 * Created by zezul on 05.01.2018.
 */
public interface Usable extends Actor {
    void useBy(Actor actor);
}
