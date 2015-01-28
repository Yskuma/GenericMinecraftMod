package genericminecraftmod.block;

import net.minecraft.block.material.Material;


public class BlockGenericFurnace extends BlockGenericMod {

    public BlockGenericFurnace() {

        super(Material.rock);
        this.setBlockName("genericFurnace");
        this.setHardness(2f);

    }

}
