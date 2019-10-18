package sk.tuke.oop.game.actors;


import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.Hammer;
import sk.tuke.oop.game.items.Money;
import sk.tuke.oop.game.items.Wrench;

public class Body extends AbstractActor implements Usable {
    private Animation animation;
    private int uses = 1;

    public Body() {
        super("body");
        animation = new Animation("sprites/body.png", 64, 48);
        setAnimation(animation);
        setPosition(300, 200);
    }

    @Override
    public boolean intersects(Actor actor) {
        if (((getX() + animation.getWidth()>actor.getX()) && (getX() < actor.getX()+actor.getWidth())) && ((getY() + animation.getHeight()>actor.getY() && getY() < actor.getHeight()+actor.getY()))){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void useBy(Actor actor) {
        Wrench wrench = new Wrench();
        Money money = new Money();
        if(actor instanceof Ripley && uses > 0){
            actor.getWorld().addActor(wrench);
            actor.getWorld().addActor(money);
            wrench.setPosition(getX()+16, getY()+16);
            money.setPosition(getX()+16, getY());
            uses--;
        }
    }
}
