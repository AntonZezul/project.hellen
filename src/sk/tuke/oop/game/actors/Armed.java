package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.weapons.AbstractWeapon;

public interface Armed extends Actor {
    AbstractWeapon getWeapon();
    void setWeapon(AbstractWeapon weapon);
}
