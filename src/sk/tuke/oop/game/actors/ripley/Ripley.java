package sk.tuke.oop.game.actors.ripley;


import sk.tuke.oop.framework.*;
import sk.tuke.oop.game.actions.*;
import sk.tuke.oop.game.actors.*;
import sk.tuke.oop.game.actors.openables.*;
import sk.tuke.oop.game.actors.weapons.AbstractWeapon;
import sk.tuke.oop.game.actors.weapons.RipleyGun;
import sk.tuke.oop.game.items.Backpack;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.items.Extinguisher;
import sk.tuke.oop.game.items.Hammer;

import java.awt.*;


/**
 * Created by zezul on 23.12.2017.
 */
//public znamena ze v lubovolnej inej triede alebo objekte mozme vyuzivat totu premennu alebo metod
//private znamena ze len v tejto triede alebo objekte mozme vyuzivat totu premennu alebo metod,bude jednoducho nedostupný z iných tried a objektov.

// extends rozsiruje realizaciu nejakej existujecej triedy.
// Nová trieda je vytvorená na základe existujúcej triedy a táto nová trieda rozširuje možnosti staršej triedy.

//implements určené na implementáciu rozhrania (interface).
//v rozhraní môžete iba špecifikovať metódy, ale neimplementovať ich.

//@Override je kľúčové slovo, ktoré umožňuje v podradenej triede znovu vytvorit implementáciu metódy rodičovskej(materskej) triedy .
//this predstavuje aktuálnu inštanciu triedy, zatiaľ čo super predstavuje aktuálnu inštanciu rodičovskej(materskej) triedy.

//Pomocou operátora instanceof môžete zistiť, z ktorej triedy vznikol objekt.
// Tento operátor má dva argumenty. Vľavo je odkaz na objekt a vpravo je názov typu, pre kompatibilitu, s ktorou je objekt kontrolovaný.

//intersects() Metóda vracia hodnotu true v prípade, ak aktuálna inštancia je v kolízii (dotýka sa) s inštanciou.V opačnom prípade vracia metóda hodnotu false.

public class Ripley extends AbstractActor implements Movable, Alive, Armed {
    private Animation animation, animation_die;
    private int width, height, step,dy,dx, energy, ammo;
    private World world;
    private Input input;
    private Ripley player;
    private Health health;
    private Message message;
    private boolean running;
    private RipleyState ripleyState;
    private Backpack backpack;
    private AbstractWeapon weapon;


    public Ripley() {
        super("ripley");
        animation_die = new Animation("sprites/player_die.png", 32, 32,100);
        animation = new Animation("sprites/player.png", 32, 32, 100);
        setRunning(true);
        setAnimation(animation);
        setRunning(true);
        health = new Health(100);
        weapon = new RipleyGun(100, 500);
        setPosition(100,200);
        step = 2;
        setBackpack(new Backpack(10));
        ripleyState = new Running(this);

    }

    @Override
    public void act() {
        Input input = Input.getInstance();
        if (input.isKeyDown(Input.Key.DOWN)) {dy = 1;}
        else if (input.isKeyDown(Input.Key.UP)) {dy = -1;} else dy = 0;
        if (input.isKeyDown(Input.Key.RIGHT)) {dx = 1;}
        else if (input.isKeyDown(Input.Key.LEFT)) {dx = -1;} else dx = 0;
        Move move = new Move(this, step, dx, dy);
        move.execute();


        if( (getHealth().getValue()) == 0){
            setAnimation(animation_die);
            ripleyState = new Dying(this);
            //System.exit(0);
        }
        if(getHealth().getValue() < 0){
            new Health(0);

        }
       setMessage(new Message("HP " + this.getHealth().getValue()+"    " + "Ammo " + this.getWeapon().getAmmo(), 100, 10, Color.white ));
       this.getWorld().showMessage(getMessage());

        if(input.isKeyPressed(Input.Key.ESCAPE)) {
        System.exit(0);
        }

        if(input.isKeyPressed(Input.Key.E)) {
            for (Actor actor : getWorld()) {
                Use use = new Use(actor, this);
                 if (actor instanceof Body && actor.intersects(this)){
                    use.execute();
                    break;
                }
                if (actor instanceof Cooler && backpack.peek() instanceof Hammer && actor.intersects(this)) {
                    use.execute();
                    break;
                }
                if (actor instanceof Computer && backpack.peek() instanceof Hammer && actor.intersects(this)) {
                    use.execute();
                    break;
                }
                if(actor instanceof Locker && actor.intersects(this)){
                    use.execute();
                    break;
                }
                if(actor instanceof Desk && actor.intersects(this)){
                    use.execute();
                    break;
                }
                if(actor instanceof SmallFire && backpack.peek() instanceof Extinguisher && actor.intersects(this)){
                    use.execute();
                    break;
                }
                if (actor instanceof Ventilator && actor.intersects(this)) {
                    use.execute();
                    break;
                }
                if(actor instanceof LockedDoor && actor.intersects(this) && backpack.peek() instanceof AccessCard){
                    use.execute();
                    break;
                }

                if(actor instanceof Door && actor.intersects(this)){
                    use.execute();
                    break;
                }
                if(actor instanceof Box && backpack.peek() instanceof Hammer && actor.intersects(this)){
                    use.execute();
                    break;
                }
                if(actor instanceof RepairDoor && actor.intersects(this)){
                    use.execute();
                    break;
                }
            }
        }
        if(input.isKeyPressed(Input.Key.ENTER)){

            for (Actor actor : getWorld()) {
                if (actor instanceof Item && actor.intersects(this)) {
                    Take<Item> take = new Take<Item>(getBackpack(), (Item) actor);
                    take.execute();
                    break;
                }
            }
        }
        if(input.isKeyPressed(Input.Key.BACK) && !backpack.getContent().isEmpty()){
            Drop<Item> drop = new Drop<Item>(backpack,getWorld(),getX(),getY());
            drop.execute();
        }

        if(input.isKeyPressed(Input.Key.S) && !backpack.getContent().isEmpty()){
            Shift<Item> shift = new Shift<Item>(backpack);
            shift.execute();

        }

        if(input.isKeyPressed(Input.Key.SPACE)){
            Fire fire = new Fire(this);
            fire.execute();
        }


        }


    @Override
    public boolean intersects(Actor actor) {
        if (((getX() + player.getWidth()>actor.getX()) && (getX() < actor.getX()+actor.getWidth())) && ((getY() + player.getHeight()>actor.getY() && getY() < actor.getHeight()+actor.getY()))){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void addedToWorld(World world) {
        super.addedToWorld(world);
        world.showActorContainer(backpack);
        world.centerOn(this);

    }




    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Backpack getBackpack(){return this.backpack; }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public Message getMessage() {
        return message;
    }


    public void setMessage(Message message) {
        this.message = message;
    }


    @Override
    public void collidedWithWall() {

    }

    @Override
    public Health getHealth() {
        return health;
    }

    @Override
    public AbstractWeapon getWeapon() {
        return weapon;
    }

    @Override
    public void setWeapon(AbstractWeapon weapon) {
        this.weapon = weapon;
    }
}
