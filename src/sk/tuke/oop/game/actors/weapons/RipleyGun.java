package sk.tuke.oop.game.actors.weapons;

public class RipleyGun extends AbstractWeapon {

    public RipleyGun(int ammo, int maxAmmo) {
        super(ammo, maxAmmo);
    }

    @Override
    protected Fireable createBullet() {
        return new Bullet("bullet");
    }
}
