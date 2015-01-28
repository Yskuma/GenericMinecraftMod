package genericminecraftmod.block;

import genericminecraftmod.GenericMinecraftMod;
import net.minecraft.block.material.Material;

public class BlockGenericOre extends BlockGenericMod {

    public BlockGenericOre() {
        super(Material.rock);
        this.setBlockName("genericOre");
        this.setBlockTextureName(GenericMinecraftMod.MODID + ":" + getUnlocalizedName());
        this.setHardness(2f);
    }

}
