package genericminecraftmod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import genericminecraftmod.GenericMinecraftMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemGenericIngot extends Item {

    public ItemGenericIngot() {
        this.setUnlocalizedName("genericIngot");
        this.setCreativeTab(GenericMinecraftMod.TAB);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister par1IconRegister) {
            this.itemIcon = par1IconRegister.registerIcon(GenericMinecraftMod.MODID + ":" + getUnlocalizedName());
    }
}
