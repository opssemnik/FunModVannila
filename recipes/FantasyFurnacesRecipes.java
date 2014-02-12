package FunMod.recipes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FantasyFurnacesRecipes
{
    private static final FantasyFurnacesRecipes smeltingBase = new FantasyFurnacesRecipes();
    private Map<ItemStack,ItemStack> smeltingList = new HashMap<ItemStack,ItemStack>();
    private Map<ItemStack,Float> experienceList = new HashMap<ItemStack,Float>();
    private Map<ItemStack,ItemStack> metaSmeltingList = new HashMap<ItemStack,ItemStack>();
    public static final FantasyFurnacesRecipes smelting()
    {
        return smeltingBase;
    }
    private FantasyFurnacesRecipes()
    {
        this.addSmelting(Blocks.iron_ore, new ItemStack(Items.iron_ingot), 1.1F);
        this.addSmelting(Blocks.gold_ore, new ItemStack(Items.gold_ingot), 1.4F);
        this.addSmelting(Blocks.diamond_ore, new ItemStack(Items.diamond), 0.1F);
        this.addSmelting(Blocks.sand, new ItemStack(Blocks.glass), 0.5F);
        this.addSmelting(Items.porkchop, new ItemStack(Items.cooked_porkchop), 0.7F);
        this.addSmelting(Items.beef, new ItemStack(Items.cooked_beef), 0.7F);
        this.addSmelting(Items.chicken, new ItemStack(Items.cooked_chicken), 0.4F);
        this.addSmelting(Items.fish, new ItemStack(Items.cooked_fished), 0.8F);
        this.addSmelting(Blocks.cobblestone, new ItemStack(Blocks.stone), 0.3F);
        this.addSmelting(Items.clay_ball, new ItemStack(Items.brick), 0.5F);
        this.addSmelting(Blocks.cactus, new ItemStack(Items.gunpowder, 1, 2), 0.4F);
        this.addSmelting(Blocks.log, new ItemStack(Items.coal, 1, 1), 0.0F);
        this.addSmelting(Blocks.emerald_ore, new ItemStack(Items.emerald), 1.4F);
        this.addSmelting(Blocks.coal_ore, new ItemStack(Items.coal), 0.0F);
        this.addSmelting(Blocks.redstone_ore, new ItemStack(Items.redstone), 1.1F);
        this.addSmelting(Blocks.lapis_ore, new ItemStack(Items.gunpowder, 1, 4), 0.2F);
           
    
    }
    public void addSmelting(Block par1, ItemStack par2ItemStack, float par3)
    {
    	 this.smeltingList.put(new ItemStack(par1), par2ItemStack);
        this.experienceList.put(par2ItemStack, Float.valueOf(par3));
    }
    public void addSmelting(Item par1, ItemStack par2ItemStack, float par3)
    {
        this.smeltingList.put(new ItemStack(par1), par2ItemStack);
        this.experienceList.put(par2ItemStack, Float.valueOf(par3));
    }
    public Map<ItemStack,ItemStack> getSmeltingList()
    {
        return this.smeltingList;
    }
    public float func_77601_c(ItemStack par1ItemStack)
    {
        return this.experienceList.containsKey(par1ItemStack) ? ((Float)this.experienceList.get(par1ItemStack)).floatValue() : 0.0F;
    }
 
    public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(item);
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)smeltingList.get(item);
    }
}
