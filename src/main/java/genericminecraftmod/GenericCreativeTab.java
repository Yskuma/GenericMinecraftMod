package genericminecraftmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GenericCreativeTab extends CreativeTabs
{

        public GenericCreativeTab(String par2Str)
        {
            super(par2Str);
        }

        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(GenericMinecraftMod.blockGenericModOre);
        }

}
