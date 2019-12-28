package uniquee.compat;

import ichttt.mods.firstaid.api.event.FirstAidLivingDamageEvent;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.Optional.Method;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uniquee.UniqueEnchantments;
import uniquee.enchantments.unique.EnchantmentAresBlessing;
import uniquee.utils.MiscUtil;

public class FirstAidHandler
{
	public static FirstAidHandler INSTANCE = new FirstAidHandler();
	
	@Method(modid = "firstaid")
	@SubscribeEvent
	public void onFirstAidEvent(FirstAidLivingDamageEvent event)
	{
		if(event.getAfterDamage().isDead(event.getEntityPlayer()))
		{
			DamageSource source = event.getSource();
			if(!source.isMagicDamage() && source != DamageSource.FALL)
			{
				int level = EnchantmentHelper.getEnchantmentLevel(UniqueEnchantments.ARES_BLESSING, event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.CHEST));
				if(level > 0)
				{
					float damage = event.getUndistributedDamage();
					event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.CHEST).damageItem((int)(damage * (EnchantmentAresBlessing.SCALAR / level)), event.getEntityLiving());
					event.setCanceled(true);
					return;
				}	
			}
			EntityPlayer living = event.getEntityPlayer();
			Object2IntMap.Entry<EntityEquipmentSlot> slot = MiscUtil.getEnchantedItem(UniqueEnchantments.PHOENIX_BLESSING, living);
			if(slot.getIntValue() > 0)
			{
				living.heal(living.getMaxHealth());
				living.clearActivePotions();
				living.getFoodStats().addStats(Short.MAX_VALUE, 1F);
	            living.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 900, 1));
	            living.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 100, 1));
	            living.world.setEntityState(living, (byte)35);
	            living.getItemStackFromSlot(slot.getKey()).shrink(1);
			}
		}
	}
}
