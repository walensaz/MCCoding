package me.DragonSlayer.Wars;

import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.MerchantRecipe;
import net.minecraft.server.v1_8_R3.MerchantRecipeList;

public abstract interface IMerchant
{
    /**
     * Sets the EntityHuman the 'villager' is trading with
     * I guess a simple EntityHuman field which you set with
     * this would suffice
     */
    public abstract void a_(EntityHuman paramEntityHuman);
 
    /**
     *  Returns the EntityHuman the 'villager' is trading with.
     *  Should just be the player that was set with the previous
     *  method.
     */
    public abstract EntityHuman b();
    
    MerchantRecipeList offer = new MerchantRecipeList();
    
 
    /**
     *  This is where the fun starts.
     *  1.  Start off by creating a MerchantRecipeList
     *  2.  Create MerchantRecipes and add them to the MerchantRecipeList
     *      (note: it extends ArrayList, so just invoke add(recipe))
     *  2a. The constructor for MerchantRecipe is slot 0, slot 1, slot 2
     *      (where slot 2 is the result. Also, they are all NMS ItemStacks (duh))
     *  2b. There is a max amount of uses. Override public void f() to prevent
     *      that from happening
     *  3b. Simply return the MerchantRecipeList. Or, if you want progress per player
     *      add some crazy mechanics by extending the class :3.
     */
    public abstract MerchantRecipeList getOffers(EntityHuman paramEntityHuman);
 
    /**
     * These last two seem to be entity specific and wouldn't really
     * be useful for your cause
     */
    public abstract void a(MerchantRecipe paramMerchantRecipe);
 
    public abstract void a_(ItemStack paramItemStack);
}
