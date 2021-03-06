package micdoodle8.mods.galacticraft.core.nei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIGalacticraftConfig implements IConfigureNEI
{
    private static HashMap<ArrayList<PositionedStack>, PositionedStack> rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
    private static HashMap<PositionedStack, PositionedStack> refineryRecipes = new HashMap<PositionedStack, PositionedStack>();

    @Override
    public void loadConfig()
    {
        this.registerRecipes();
        API.hideItems(GalacticraftCore.hiddenItems);
        API.registerRecipeHandler(new RocketT1RecipeHandler());
        API.registerUsageHandler(new RocketT1RecipeHandler());
        API.registerRecipeHandler(new RefineryRecipeHandler());
        API.registerUsageHandler(new RefineryRecipeHandler());
    }

    @Override
    public String getName()
    {
        return "Galacticraft NEI Plugin";
    }

    @Override
    public String getVersion()
    {
        return GalacticraftCore.LOCALMAJVERSION + "." + GalacticraftCore.LOCALMINVERSION + "." + GalacticraftCore.LOCALBUILDVERSION;
    }

    public void registerRocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output)
    {
        NEIGalacticraftConfig.rocketBenchRecipes.put(input, output);
    }

    public void registerRefineryRecipe(PositionedStack input, PositionedStack output)
    {
        NEIGalacticraftConfig.refineryRecipes.put(input, output);
    }

    public static Set<Entry<ArrayList<PositionedStack>, PositionedStack>> getRocketBenchRecipes()
    {
        return NEIGalacticraftConfig.rocketBenchRecipes.entrySet();
    }

    public static Set<Entry<PositionedStack, PositionedStack>> getRefineryRecipes()
    {
        return NEIGalacticraftConfig.refineryRecipes.entrySet();
    }

    public void registerRecipes()
    {
        final int changey = 23;

        this.registerRefineryRecipe(new PositionedStack(new ItemStack(GCCoreItems.oilCanister, 1, 1), 2, 3), new PositionedStack(new ItemStack(GCCoreItems.fuelCanister, 1, 1), 148, 3));

        final ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.rocketNoseCone), 45, -8 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.heavyPlating), 36, -6 + 0 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.heavyPlating), 36, -6 + 1 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.heavyPlating), 36, -6 + 2 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.heavyPlating), 36, -6 + 3 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.heavyPlating), 54, -6 + 0 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.heavyPlating), 54, -6 + 1 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.heavyPlating), 54, -6 + 2 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.heavyPlating), 54, -6 + 3 * 18 + 16 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.rocketEngine), 45, 82 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.rocketFins), 18, 64 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.rocketFins), 18, 82 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.rocketFins), 72, 64 + changey));
        input1.add(new PositionedStack(new ItemStack(GCCoreItems.rocketFins), 72, 82 + changey));
        this.registerRocketBenchRecipe(input1, new PositionedStack(new ItemStack(GCCoreItems.spaceship, 1, 0), 139, 69 + changey));

        final ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>();
        input2.add(new PositionedStack(new ItemStack(GCCoreItems.rocketNoseCone), 45, -8 + changey));
        input2.add(new PositionedStack(new ItemStack(GCCoreItems.heavyPlating), 36, -6 + 0 * 18 + 16 + changey));
        input2.add(new PositionedStack(new ItemStack(GCCoreItems.heavyPlating), 36, -6 + 1 * 18 + 16 + changey));
        input2.add(new PositionedStack(new ItemStack(GCCoreItems.heavyPlating), 36, -6 + 2 * 18 + 16 + changey));
        input2.add(new PositionedStack(new ItemStack(GCCoreItems.heavyPlating), 36, -6 + 3 * 18 + 16 + changey));
        input2.add(new PositionedStack(new ItemStack(GCCoreItems.heavyPlating), 54, -6 + 0 * 18 + 16 + changey));
        input2.add(new PositionedStack(new ItemStack(GCCoreItems.heavyPlating), 54, -6 + 1 * 18 + 16 + changey));
        input2.add(new PositionedStack(new ItemStack(GCCoreItems.heavyPlating), 54, -6 + 2 * 18 + 16 + changey));
        input2.add(new PositionedStack(new ItemStack(GCCoreItems.heavyPlating), 54, -6 + 3 * 18 + 16 + changey));
        input2.add(new PositionedStack(new ItemStack(GCCoreItems.rocketEngine), 45, 82 + changey));
        input2.add(new PositionedStack(new ItemStack(GCCoreItems.rocketFins), 18, 64 + changey));
        input2.add(new PositionedStack(new ItemStack(GCCoreItems.rocketFins), 18, 82 + changey));
        input2.add(new PositionedStack(new ItemStack(GCCoreItems.rocketFins), 72, 64 + changey));
        input2.add(new PositionedStack(new ItemStack(GCCoreItems.rocketFins), 72, 82 + changey));
        input2.add(new PositionedStack(new ItemStack(Block.chest), 90 + 0 * 23, -15 + changey));
        this.registerRocketBenchRecipe(input2, new PositionedStack(new ItemStack(GCCoreItems.spaceship, 1, 1), 139, 69 + changey));
    }
}
