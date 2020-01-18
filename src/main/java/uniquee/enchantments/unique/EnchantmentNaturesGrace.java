package uniquee.enchantments.unique;

import java.util.function.Predicate;

import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import uniquee.enchantments.UniqueEnchantment;
import uniquee.enchantments.type.IGraceEnchantment;
import uniquee.utils.DoubleLevelStats;
import uniquee.utils.IntStat;

public class EnchantmentNaturesGrace extends UniqueEnchantment implements IGraceEnchantment
{
	public static final DoubleLevelStats HEALING = new DoubleLevelStats("healing", 0.2, 0.4);
	public static IntStat DELAY = new IntStat(100, "delay");
	public static Predicate<BlockState> FLOWERS = new Predicate<BlockState>(){
		@Override
		public boolean test(BlockState t)
		{
			return BlockTags.SMALL_FLOWERS.contains(t.getBlock()) || t.getBlock() instanceof DoublePlantBlock || BlockTags.LEAVES.contains(t.getBlock());
		}
	};	
	public EnchantmentNaturesGrace()
	{
		super(new DefaultData("naturesgrace", Rarity.VERY_RARE, true, 22, 4, 22), EnchantmentType.ARMOR_CHEST, new EquipmentSlotType[]{EquipmentSlotType.CHEST});
	}
	
	@Override
	public int getMaxLevel()
	{
		return 2;
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench)
	{
		return ench instanceof EnchantmentAresBlessing || ench instanceof EnchantmentAlchemistsGrace || ench instanceof EnchantmentWarriorsGrace ? false : super.canApplyTogether(ench);
	}

	@Override
	public void loadData(Builder config)
	{
		HEALING.handleConfig(config);
		DELAY.handleConfig(config);
	}
}
