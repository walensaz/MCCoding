package me.dragon.test.Item;

import org.bukkit.inventory.ItemStack;

public class CustomGUIItem extends ItemStack {

    private int id;

    public CustomGUIItem(ItemStack stack, int id) throws IllegalArgumentException {
        super(stack);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
