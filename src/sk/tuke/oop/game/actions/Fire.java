package sk.tuke.oop.game.actions;

import sk.tuke.oop.game.actors.Armed;
import sk.tuke.oop.game.actors.weapons.AbstractWeapon;
import sk.tuke.oop.game.actors.weapons.Bullet;

public class Fire implements Action {
    private Armed armed;
    private AbstractWeapon weapon;
    private boolean shot;


    public Fire(Armed armed){
        this.armed = armed;
        weapon = armed.getWeapon();
    }


    @Override
    public void execute() {
        Bullet bullet = (Bullet) weapon.fire();
        if (bullet != null) {
            bullet.setDirection(armed.getAnimation().getRotation());
            bullet.setPosition(armed.getX() + bullet.getX() + 8, armed.getY() + bullet.getY() + 8);
            armed.getWorld().addActor(bullet);
        } else {
            return;
        }

    }
}
