package sk.tuke.oop.game.actors.ripley;



public class Running implements RipleyState {
private Ripley player;

    public Running(Ripley player) {
        this.player = player;
    }

    @Override
    public void act() {
        if(player.getHealth().getValue() > 0 && !(player.isRunning())) {
            player.setRunning(true);
        }

    }
}
