package sk.tuke.oop.game.actors;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}
