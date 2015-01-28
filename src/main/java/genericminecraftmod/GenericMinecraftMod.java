package genericminecraftmod;

import cpw.mods.fml.common.SidedProxy;
import genericminecraftmod.block.BlockGenericOre;
import genericminecraftmod.block.BlockGenericFurnace;
import cpw.mods.fml.common.registry.GameRegistry;
import genericminecraftmod.item.ItemGenericIngot;
import genericminecraftmod.item.armor.ItemGenericBoots;
import genericminecraftmod.item.armor.ItemGenericChest;
import genericminecraftmod.item.armor.ItemGenericHelm;
import genericminecraftmod.item.armor.ItemGenericLegs;
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
import net.minecraftforge.oredict.OreDictionary;
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

    public static Item itemGenericIngot;

    public static Item itemGenericAxe;
    public static Item itemGenericPickaxe;
    public static Item itemGenericShovel;
    public static Item itemGenericHoe;
    public static Item itemGenericSword;

    public static Item itemGenericHelm;
    public static Item itemGenericChestplate;
    public static Item itemGenericLegs;
    public static Item itemGenericBoots;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        RegisterOres();
        RegisterItems();

        RegisterOreDict();

        RegisterMachines();

        RegisterCraftingRecipes();
        RegisterSmeltingRecipes();
    }

    private static void RegisterOres() {
        //Register
        blockGenericModOre = new BlockGenericOre();
        GameRegistry.registerBlock(blockGenericModOre, blockGenericModOre.getUnlocalizedName());
    }

    private static void RegisterItems() {

        //Ingot
        itemGenericIngot = new ItemGenericIngot();
        GameRegistry.registerItem(itemGenericIngot, itemGenericIngot.getUnlocalizedName());

        //Tools
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

        //Armor
        itemGenericHelm = new ItemGenericHelm();
        GameRegistry.registerItem(itemGenericHelm, itemGenericHelm.getUnlocalizedName());

        itemGenericChestplate = new ItemGenericChest();
        GameRegistry.registerItem(itemGenericChestplate, itemGenericChestplate.getUnlocalizedName());

        itemGenericLegs= new ItemGenericLegs();
        GameRegistry.registerItem(itemGenericLegs, itemGenericLegs.getUnlocalizedName());

        itemGenericBoots = new ItemGenericBoots();
        GameRegistry.registerItem(itemGenericBoots, itemGenericBoots.getUnlocalizedName());
    }

    private static void RegisterOreDict() {
        //Register
        OreDictionary.registerOre("oreGeneric", new ItemStack(blockGenericModOre, 1));
        OreDictionary.registerOre("ingotGeneric", new ItemStack(itemGenericIngot, 1));
    }

    private static void RegisterMachines() {
        blockGenericModFurnace = new BlockGenericFurnace();
        GameRegistry.registerBlock(blockGenericModFurnace, blockGenericModFurnace.getUnlocalizedName());
    }

    private static void RegisterCraftingRecipes(){
        //Tools
        GameRegistry.addRecipe(new ShapedOreRecipe(itemGenericAxe, "II ", "IS ", " S ", 'I', "ingotGeneric", 'S', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(itemGenericHoe, "II ", " S ", " S ", 'I', "ingotGeneric", 'S', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(itemGenericPickaxe, "III", " S ", " S ", 'I', "ingotGeneric", 'S', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(itemGenericShovel, " I ", " S ", " S ", 'I', "ingotGeneric", 'S', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(itemGenericSword, " I ", " I ", " S ", 'I', "ingotGeneric", 'S', "stickWood"));

        //Armor
        GameRegistry.addRecipe(new ShapedOreRecipe(itemGenericHelm, "III", "I I", "   ", 'I', "ingotGeneric"));
        GameRegistry.addRecipe(new ShapedOreRecipe(itemGenericChestplate, "I I", "III", "III", 'I', "ingotGeneric"));
        GameRegistry.addRecipe(new ShapedOreRecipe(itemGenericLegs, "III", "I I", "I I", 'I', "ingotGeneric"));
        GameRegistry.addRecipe(new ShapedOreRecipe(itemGenericBoots, "   ", "I I", "I I", 'I', "ingotGeneric"));

    }

    private static void RegisterSmeltingRecipes(){
        GameRegistry.addSmelting(blockGenericModOre, new ItemStack(itemGenericIngot), 1);
    }





}
