package genericminecraftmod;

import cpw.mods.fml.common.SidedProxy;
import genericminecraftmod.block.GenericOreBlock;
import genericminecraftmod.block.GenericFurnaceBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import genericminecraftmod.item.GenericIngot;
import genericminecraftmod.item.tools.*;
import genericminecraftmod.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.ShapedOreRecipe;

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

    //More durable and slightly better than iron, rubbish for enchanting though.
    public static ArmorMaterial genericArmorMaterial = EnumHelper.addArmorMaterial("GENERIC", 18, new int[]{2, 6, 5, 2}, 8);
    public static ToolMaterial genericToolMaterial = EnumHelper.addToolMaterial("GENERIC", 2, 300, 6.6F, 2.5F, 8);

    public static Block blockGenericModOre;
    public static Block blockGenericModFurnace;

    public static Item itemGenericModIngot;

    public static Item itemGenericAxe;
    public static Item itemGenericPickaxe;
    public static Item itemGenericShovel;
    public static Item itemGenericHoe;
    public static Item itemGenericSword;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        RegisterOres();
        RegisterMachines();
        RegisterItems();
        RegisterCraftingRecipes();
        RegisterSmeltingRecipes();
    }

    private static void RegisterOres() {
        blockGenericModOre = new GenericOreBlock();
        GameRegistry.registerBlock(blockGenericModOre, blockGenericModOre.getUnlocalizedName());
    }

    private static void RegisterItems() {
        itemGenericModIngot = new GenericIngot();
        GameRegistry.registerItem(itemGenericModIngot, itemGenericModIngot.getUnlocalizedName());

        itemGenericAxe = new ItemGenericAxe();
        GameRegistry.registerItem(itemGenericAxe , itemGenericAxe.getUnlocalizedName());

        itemGenericPickaxe = new ItemGenericPick();
        GameRegistry.registerItem(itemGenericPickaxe , itemGenericPickaxe .getUnlocalizedName());

        itemGenericShovel = new ItemGenericShovel();
        GameRegistry.registerItem(itemGenericShovel, itemGenericShovel.getUnlocalizedName());

        itemGenericHoe = new ItemGenericHoe();
        GameRegistry.registerItem(itemGenericHoe, itemGenericHoe.getUnlocalizedName());

        itemGenericSword = new ItemGenericSword();
        GameRegistry.registerItem(itemGenericSword, itemGenericSword.getUnlocalizedName());

    }

    private static void RegisterMachines() {
        blockGenericModFurnace = new GenericFurnaceBlock();
        GameRegistry.registerBlock(blockGenericModFurnace, blockGenericModFurnace.getUnlocalizedName());
    }

    private static void RegisterCraftingRecipes(){
        GameRegistry.addRecipe(new ShapedOreRecipe(itemGenericAxe, "II ", "IS ", " S ", 'I', itemGenericModIngot, 'S', new ItemStack(Items.stick, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(itemGenericHoe, "II ", " S ", " S ", 'I', itemGenericModIngot, 'S', new ItemStack(Items.stick, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(itemGenericPickaxe, "III", " S ", " S ", 'I', itemGenericModIngot, 'S', new ItemStack(Items.stick, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(itemGenericShovel, " I ", " S ", " S ", 'I', itemGenericModIngot, 'S', new ItemStack(Items.stick, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(itemGenericSword, " I ", " I ", " S ", 'I', itemGenericModIngot, 'S', new ItemStack(Items.stick, 1, 0)));

    }

    private static void RegisterSmeltingRecipes(){
        GameRegistry.addSmelting(blockGenericModOre, new ItemStack(itemGenericModIngot), 1);
    }





}
