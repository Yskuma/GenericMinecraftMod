package genericminecraftmod;

import cpw.mods.fml.common.SidedProxy;
import genericminecraftmod.block.GenericOreBlock;
import genericminecraftmod.block.GenericFurnaceBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import genericminecraftmod.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = GenericMinecraftMod.MODID, version = GenericMinecraftMod.VERSION)
public class GenericMinecraftMod
{
    public static final String MODID = "genericminecraftmod";
    public static final String VERSION = "0.2";

    @SidedProxy(clientSide="genericminecraftmod.proxy.ClientProxy", serverSide="genericminecraftmod.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static final CreativeTabs TAB = new GenericCreativeTab("GenericMinecraftMod");

    //public static final String LANGUAGE_PATH = RESOURCE_PATH + "languages/";
    //private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US"};

    public static Block blockGenericModOre;
    public static Block blockGenericModFurnace;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        RegisterOres();
        RegisterMachines();
    }

    private static void RegisterOres() {
        blockGenericModOre = new GenericOreBlock();
        GameRegistry.registerBlock(blockGenericModOre, blockGenericModOre.getUnlocalizedName());
        System.out.println(blockGenericModOre.getItemIconName());
    }

    private static void RegisterMachines() {
        blockGenericModFurnace = new GenericFurnaceBlock();
        GameRegistry.registerBlock(blockGenericModFurnace, blockGenericModFurnace.getUnlocalizedName());
        System.out.println(blockGenericModFurnace.getItemIconName());
    }

}
