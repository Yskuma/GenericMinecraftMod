package genericminecraftmod.item.armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import genericminecraftmod.GenericMinecraftMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Created by AndrewD on 27/01/2015.
 */
public class ItemGenericArmor extends ItemArmor {

    String texture;

    public ItemGenericArmor(int type, String name) {
        this(type, name, GenericMinecraftMod.genericArmorMaterial);
    }

    public ItemGenericArmor(int type, String name, ArmorMaterial mat) {
        super(mat, 0, type);
        setCreativeTab(GenericMinecraftMod.TAB);
        setUnlocalizedName(name);
        texture = GenericMinecraftMod.MODID + ":" + "textures/models/armor/" + mat.name().toLowerCase() + "_layer_" + (type == 2 ? 2 : 1) + ".png";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(GenericMinecraftMod.MODID + ":" + getUnlocalizedName());
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return texture;
    }
}
