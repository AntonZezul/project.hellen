package sk.tuke.oop.game.actions;

import sk.tuke.oop.framework.Actor;

import sk.tuke.oop.framework.ActorContainer;

public class Take <A extends Actor> implements Action {
    private ActorContainer<A> container;
    private A actor;


    public Take(ActorContainer<A> container, A actor){
        //referencia na object containera - container
        this.container = container;
        this.actor = actor;
    }

    @Override
    public void execute() {
        container.add(actor);
        actor.getWorld().removeActor(actor);
    }
}
