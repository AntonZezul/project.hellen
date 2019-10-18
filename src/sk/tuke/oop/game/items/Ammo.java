package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 * Created by zezul on 05.01.2018.
 */
public class Ammo extends AbstractActor implements Item {
    private Animation animation;

    public Ammo() {
        super("ammo");
        animation = new Animation("sprites/ammo.png", 16, 16);
        setAnimation(animation);
        setPosition(150, 150);
    }

    public void act() {
        for (Actor actor : getWorld()){

            if(actor instanceof Ripley && this.intersects(actor)){
                Ripley ripley = (Ripley) actor;
                if(ripley.getWeapon().getAmmo() < 500){
                    ripley.getWeapon().reload(50);
                    if(ripley.getWeapon().getAmmo() > 500){
                        ripley.getWeapon().setAmmo(500); }
                    this.getWorld().removeActor(this);
                    break;
                }
            }
        }
    }




    @Override
    public boolean intersects(Actor actor) {
        if (((getX() + animation.getWidth()>actor.getX()) && (getX() < actor.getX()+actor.getWidth())) && ((getY() + animation.getHeight()>actor.getY() && getY() < actor.getHeight()+actor.getY()))){
            return true;
        } else {
            return false;
        }
    }

}
