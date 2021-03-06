package uniquee.enchantments.unique;

import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.common.config.Configuration;
import uniquee.enchantments.UniqueEnchantment;
import uniquee.utils.IntLevelStats;

public class EnchantmentCloudwalker extends UniqueEnchantment
{
	public static final String TIMER = "cloud";
	public static final IntLevelStats TICKS = new IntLevelStats("duration", 8, 28);

	public EnchantmentCloudwalker()
	{
		super(new DefaultData("cloudwalker", Rarity.RARE, true, 16, 3, 16), EnumEnchantmentType.ARMOR_FEET, new EntityEquipmentSlot[]{EntityEquipmentSlot.FEET});
	}
	
	@Override
	public int getMaxLevel()
	{
		return 4;
	}
	
	@Override
	public void loadData(Configuration config)
	{
		TICKS.handleConfig(config, getConfigName());
	}
}
