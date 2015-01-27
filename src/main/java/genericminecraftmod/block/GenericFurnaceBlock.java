package genericminecraftmod.block;

import genericminecraftmod.GenericMinecraftMod;
import net.minecraft.block.material.Material;


public class GenericFurnaceBlock extends GenericModBlock {

    public GenericFurnaceBlock() {

        super(Material.rock);
        this.setBlockName("furnaceGenericMod");
        this.setHardness(2f);

    }

}
