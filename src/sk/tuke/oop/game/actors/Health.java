package sk.tuke.oop.game.actors;

import java.util.ArrayList;
import java.util.List;

public class Health {
    private int health, maxHealth;
    private List<ExhaustionEffect> list;

    public Health(int health, int maxHealth){
        this.health = health;
        this.maxHealth = maxHealth;
        list = new ArrayList<ExhaustionEffect>();
    }
    public Health(int health){
        this.health = health;
        this.maxHealth = health;
    }

    public int getValue(){return health;}

    void refill(int amount){
        setHealth(getValue() + amount);
        if(getValue() > getMaxHealth()){
            setHealth(getMaxHealth());
        }
    }

    public void restore(){
        setHealth(getMaxHealth());
    }

    public void drain(int amount){
        if((getValue() - amount) < 0){
            setHealth(0);
            for(ExhaustionEffect callback: list ){
                callback.apply();
            }
        }else {
            setHealth(getValue() - amount);
        }
    }
    void exhaust(){
        this.health = 0;
        for(ExhaustionEffect callback: list ){
            callback.apply();
        }
    }

    @FunctionalInterface
    public interface ExhaustionEffect {
        void apply();
    }

    public void onExhaustion(ExhaustionEffect callback){
        list.add(callback);
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
