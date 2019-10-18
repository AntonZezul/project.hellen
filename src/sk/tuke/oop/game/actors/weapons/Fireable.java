package sk.tuke.oop.game.actors.weapons;

import sk.tuke.oop.game.actions.Move;
import sk.tuke.oop.game.actors.Movable;

public interface Fireable extends Movable {
    Move setDirection(int angle);
}
