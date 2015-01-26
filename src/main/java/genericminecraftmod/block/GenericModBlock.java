package genericminecraftmod.block;

import genericminecraftmod.GenericMinecraftMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * Created by AndrewD on 23/01/2015.
 */

public class GenericModBlock extends Block {

    public int originalLight;

    public GenericModBlock(Material par2Material) {
        super(par2Material);
        if(registerInCreative())
            setCreativeTab(GenericMinecraftMod.TAB);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        blockIcon = par1IconRegister.registerIcon(GenericMinecraftMod.MODID + ":" + this.getUnlocalizedName().substring(5));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return blockIcon;
    }

    boolean registerInCreative() {
        return true;
    }


}