package uniquee.enchantments.unique;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.MendingEnchantment;
import net.minecraft.enchantment.UnbreakingEnchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import uniquee.enchantments.UniqueEnchantment;
import uniquee.enchantments.type.IGraceEnchantment;
import uniquee.utils.DoubleStat;

public class EnchantmentWarriorsGrace extends UniqueEnchantment implements IGraceEnchantment
{
	public static DoubleStat DURABILITY_GAIN = new DoubleStat(1.1D, "durability_gain");

	public EnchantmentWarriorsGrace()
	{
		super(new DefaultData("warriorsgrace", Rarity.VERY_RARE, true, 22, 2, 30), EnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
	}
	
	@Override
	public int getMaxLevel()
	{
		return 1;
	}
	
	@Override
	protected boolean canApplyToItem(ItemStack stack)
	{
		return stack.getItem() instanceof AxeItem;
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench)
	{
		return ench instanceof UnbreakingEnchantment || ench instanceof MendingEnchantment || ench instanceof EnchantmentAlchemistsGrace || ench instanceof EnchantmentNaturesGrace || ench instanceof EnchantmentEcological ? false : super.canApplyTogether(ench);
	}

	@Override
	public void loadData(Builder config)
	{
		DURABILITY_GAIN.handleConfig(config);
	}
	
}
