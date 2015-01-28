package genericminecraftmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import genericminecraftmod.GenericMinecraftMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by andrewd on 28/01/2015.
 */
public class BlockGenericCropCore extends BlockBush implements IGrowable {

    protected int maxGrowth = 5;

    @SideOnly(Side.CLIENT)
    protected IIcon[] iIcon;

    public BlockGenericCropCore()
    {
        // Basic block setup
        setTickRandomly(true);
        float f = 0.5F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        setCreativeTab(GenericMinecraftMod.TAB);
        setHardness(0.0F);
        setStepSound(soundTypeGrass);
        disableStats();
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random parRand, int parFortune)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public int getRenderType()
    {
        return 1; // Cross like flowers
    }
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
    protected boolean canPlaceBlockOn(Block block) {
        return block == Blocks.farmland;
    }

    //Bonemeal allowed
    @Override
    public boolean func_149851_a(World world, int x, int y, int z, boolean b) {

        return world.getBlockMetadata(x, y, z) != maxGrowth;
    }

    @Override
    public boolean func_149852_a(World world, Random random, int i, int i1, int i2) {
        return true;
    }

    @Override
    public void func_149853_b(World world, Random random, int x, int y, int z) {
        incrementGrowth(world, random, x, y, z);
    }

    public void incrementGrowth(World world, Random parRand, int x, int y, int z) {
        int growStage = world.getBlockMetadata(x, y, z) +
                MathHelper.getRandomIntegerInRange(parRand, 2, 5);

        if (growStage > maxGrowth) {
            growStage = maxGrowth;
        }

        world.setBlockMetadataWithNotify(x, y, z, growStage, 2);
    }

    @Override
    public void updateTick(World parWorld, int parX, int parY, int parZ, Random parRand)
    {
        super.updateTick(parWorld, parX, parY, parZ, parRand);
        int growStage = parWorld.getBlockMetadata(parX, parY, parZ) + 1;

        if (growStage > maxGrowth)
        {
            growStage = maxGrowth;
        }

        parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
    }
}
