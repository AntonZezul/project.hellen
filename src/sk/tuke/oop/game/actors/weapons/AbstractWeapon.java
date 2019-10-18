package sk.tuke.oop.game.actors.weapons;


public abstract class AbstractWeapon {
private int ammo, maxAmmo;


    public AbstractWeapon(int ammo, int maxAmmo){
        this.ammo = ammo;
        this.maxAmmo = maxAmmo;
    }
public int getAmmo(){
    return ammo;
}

public void reload(int newAmmo){
    setAmmo(getAmmo() + newAmmo);
    if(getAmmo() > maxAmmo){
        setAmmo(maxAmmo);
    }
}
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public Fireable fire(){
    if(getAmmo() == 0){
        return null;
    }else {
        setAmmo(getAmmo() - 1);
        if(getAmmo() <= 0){
            setAmmo(0);
        }

        return createBullet();
    }
    }

    protected abstract Fireable createBullet();

}
