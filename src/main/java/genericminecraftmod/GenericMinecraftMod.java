package genericminecraftmod;

import genericminecraftmod.block.GenericOreBlock;
import cpw.mods.fml.common.registry.GameRegistry;
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

    //public static final String RESOURCE_PATH = "/assets/genericminecraftmod/";
    //public static final String TEXTURE_NAME_PREFIX = "genericminecraftmod:";

    //public static final String TEXTURE_DIRECTORY = RESOURCE_PATH + "textures/";
    //public static final String GUI_DIRECTORY = TEXTURE_NAME_PREFIX + "textures/gui/";
    //public static final String BLOCK_TEXTURE_DIRECTORY = TEXTURE_DIRECTORY + "blocks/";
    //public static final String ITEM_TEXTURE_DIRECTORY = TEXTURE_DIRECTORY + "items/";
    //public static final String MODEL_TEXTURE_DIRECTORY = TEXTURE_DIRECTORY + "models/";

    public static final CreativeTabs TAB = new GenericCreativeTab("GenericMinecraftMod");

    //public static final String LANGUAGE_PATH = RESOURCE_PATH + "languages/";
    //private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US"};

    public static Block blockGenericModOre;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        RegisterOres();
    }

    private static void RegisterOres() {
        blockGenericModOre = new GenericOreBlock();
        GameRegistry.registerBlock(blockGenericModOre, blockGenericModOre.getUnlocalizedName().substring(5));
        System.out.println(blockGenericModOre.getItemIconName());
    }


}
