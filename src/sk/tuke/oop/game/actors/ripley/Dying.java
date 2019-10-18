package sk.tuke.oop.game.actors.ripley;

public class Dying implements RipleyState {
    private Ripley player;

    public Dying(Ripley player){
        this.player = player;
    }


    @Override
    public void act() {
        System.exit(0);
    }
}
