package uniquee.enchantments.curse;

import java.util.UUID;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import uniquee.enchantments.UniqueEnchantment;

public class EnchantmentDeathsOdium extends UniqueEnchantment
{
	public static final String CURSE_STORAGE = "curse_storage";
	public static final UUID REMOVE_UUID = UUID.fromString("1a74e7ff-3914-4e57-8f59-aed5c17c04a0");
	public static final UUID GENERAL_MOD = UUID.fromString("f598685c-c107-4ba0-b537-2a9c03582186");
	public static final UUID MAIN_HAND_MOD = UUID.fromString("fbd9ead3-fdd8-45c8-a029-644b9a5c72cf");
	public static final UUID OFF_HAND_MOD = UUID.fromString("ab4e455c-9fd1-4601-8da0-d23ffc212815");
	public static final UUID HELMET_MOD = UUID.fromString("7feca783-39ef-474a-829f-27b004847d8f");
	public static final UUID CHESTPLATE_MOD = UUID.fromString("b84f1f28-af51-41b3-a820-5b0d5943deb2");
	public static final UUID LEGGINGS_MOD = UUID.fromString("7155868f-c452-482b-9c35-20d3082cf766");
	public static final UUID FEET_MOD = UUID.fromString("6d64591f-abda-431f-87da-0622ba33b665");
	
	
	public EnchantmentDeathsOdium()
	{
		super(new DefaultData("deaths_odium", Rarity.UNCOMMON, false, 10, 4, 40), EnchantmentType.ALL, EquipmentSlotType.values());
	}
	
	@Override
	public int getMaxLevel()
	{
		return 1;
	}
	
	@Override
	public boolean isCurse()
	{
		return true;
	}
	
	@Override
	public void loadData(Builder config) {}
	
	public static UUID getForSlot(EquipmentSlotType slot)
	{
		switch(slot)
		{
			case CHEST: return CHESTPLATE_MOD;
			case FEET: return FEET_MOD;
			case HEAD: return HELMET_MOD;
			case LEGS: return LEGGINGS_MOD;
			case MAINHAND: return MAIN_HAND_MOD;
			case OFFHAND: return OFF_HAND_MOD;
			default: return GENERAL_MOD;
		}
	}
	
}
