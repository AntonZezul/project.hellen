package sk.tuke.oop.game.items;


import sk.tuke.oop.framework.ActorContainer;
import sk.tuke.oop.framework.Item;

import java.util.*;

public class Backpack implements ActorContainer<Item> {
    private int capacity;
    private String name = "backpack";
    private List<Item> items = new ArrayList<>();


    public Backpack(int capacity){
        this.capacity = capacity;
    }

@Override
public void add(Item actor) {
    if(actor != null && items.size() < getCapacity()){
        peek();
        items.add(actor);
    }else {throw new ArrayIndexOutOfBoundsException();}
}


    public void remove(Item actor) {
        if(!items.contains(actor)){
            throw new NoSuchElementException();
        }else if(actor != null && items.size() > 0) {
            items.remove(actor);
        }
    }


    @Override
    public Item peek() {
        if(this.items.isEmpty()){
            return null;
        }else {
            return this.items.get(items.size() - 1);
        }
    }


    @Override
    public List<Item> getContent() {
        return new ArrayList<>(items);
    }

    @Override
        public void shiftContent() {
            Collections.rotate(items, 1);
            //Collection.rotate/shuffle/reverse/swap/replaceAll/copy/fill
        }


    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }
}
