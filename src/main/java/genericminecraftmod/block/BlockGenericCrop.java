package genericminecraftmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by andrewd on 28/01/2015.
 */
public class BlockGenericCrop extends BlockBush implements IGrowable {
/*
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.iconArray = new IIcon[this.getNumGrowthStages() + 1];

        for(int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = iconRegister.registerIcon(this.getTextureName() + "_stage_" + i);
        }

    }
*/
    @Override
    public boolean func_149851_a(World world, int i, int i1, int i2, boolean b) {
        return false;
    }

    @Override
    public boolean func_149852_a(World world, Random random, int i, int i1, int i2) {
        return false;
    }

    @Override
    public void func_149853_b(World world, Random random, int i, int i1, int i2) {

    }
}
