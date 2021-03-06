package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common;

import ic2.api.item.ElectricItem;
import ic2.core.IC2;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class UGSCommonEventHandler
{
    @SubscribeEvent
    public void onTickPlayer(TickEvent.PlayerTickEvent event)
    {
        ItemStack chestPlate = event.player.getCurrentArmor(2);
        if(chestPlate != null && chestPlate.getItem() == UltimateGraviSuiteMod.ultimateGraviChestPlate)
        {
            if(event.phase == TickEvent.Phase.START && event.side == Side.SERVER)
            {
                if(UltimateGraviSuiteMod.keyboard.isFlyKeyDown(event.player))
                {
                    UGSUtils.switchFly(event.player, chestPlate);
                }

                if(UltimateGraviSuiteMod.keyboard.isInvisibleKeyDown(event.player))
                {
                    UGSUtils.switchVisibility(event.player, chestPlate);
                }

                if(!UGSUtils.isFlyActive(event.player))
                {
                    NBTTagCompound tag = UGSUtils.getTag(chestPlate);
                    if(tag.getBoolean("fly"))
                    {
                        UGSUtils.flyActive.put(event.player, true);
                    }
                }

                if(!UGSUtils.isInvisibilityActive(event.player))
                {
                    NBTTagCompound tag = UGSUtils.getTag(chestPlate);
                    if(tag.getBoolean("invisible"))
                    {
                        UGSUtils.invisibilityActive.put(event.player, true);
                    }
                }
            }

            if(event.phase == TickEvent.Phase.END)
            {
                if(UGSUtils.isInvisibilityActive(event.player) && ElectricItem.manager.getCharge(chestPlate) > UltimateGraviSuiteMod.ultimateMinCharge)
                {
                    event.player.setInvisible(true);
                    if(!event.player.capabilities.isCreativeMode)
                    {
                        if(!this.canUseChestplate(event.player, chestPlate, "ultimate.inv.noenergy", UltimateGraviSuiteMod.ultimateUseByTick))
                        {
                            event.player.setInvisible(false);
                            UGSUtils.switchVisibility(event.player, chestPlate);
                        }
                    }
                }
                else
                {
                    if(event.player.isInvisible() && !event.player.isPotionActive(Potion.invisibility))
                    {
                        event.player.setInvisible(false);
                    }
                }

                if(UGSUtils.isFlyActive(event.player) && ElectricItem.manager.getCharge(chestPlate) > UltimateGraviSuiteMod.ultimateMinCharge)
                {
                    if(!event.player.capabilities.isCreativeMode)
                    {
                        event.player.capabilities.allowFlying = true;
                        event.player.capabilities.isFlying = true;
                        if(IC2.keyboard.isBoostKeyDown(event.player) && !event.player.onGround && event.player.capabilities.isFlying)
                        {
                            this.canUseChestplate(event.player, chestPlate, "utilmate.fly.boost.noenergy", UltimateGraviSuiteMod.boostUseByTick);
                        }
                    }
                    if(!this.canUseChestplate(event.player, chestPlate, "ultimate.fly.noenergy", UltimateGraviSuiteMod.ultimateUseByTick))
                    {
                        if(!event.player.capabilities.isCreativeMode)
                        {
                            event.player.capabilities.allowFlying = false;
                            event.player.capabilities.isFlying = false;
                        }
                        UGSUtils.switchFly(event.player, chestPlate);
                    }
                }
                else if(!event.player.capabilities.isCreativeMode)
                {
                    event.player.capabilities.allowFlying = false;
                    event.player.capabilities.isFlying = false;
                }

                if(event.player.posY > 262.0D && !event.player.capabilities.isCreativeMode)
                {
                    event.player.setPosition(event.player.posX, 262.0D, event.player.posZ);
                }
            }
        }
        else
        {
            if(UGSUtils.isFlyActive(event.player))
            {
                UGSUtils.flyActive.put(event.player, false);
                if(!event.player.capabilities.isCreativeMode)
                {
                    event.player.capabilities.allowFlying = false;
                    event.player.capabilities.isFlying = false;
                }
            }

            if(UGSUtils.isInvisibilityActive(event.player))
            {
                UGSUtils.invisibilityActive.put(event.player, false);
                if(event.player.isInvisible() && !event.player.isPotionActive(Potion.invisibility))
                {
                    event.player.setInvisible(false);
                }
            }
        }
    }

    private boolean canUseChestplate(EntityPlayer player, ItemStack chestPlate, String message, int use)
    {
        ElectricItem.manager.discharge(chestPlate, use, 4, true, true, false);
        if(ElectricItem.manager.getCharge(chestPlate) < UltimateGraviSuiteMod.ultimateMinCharge)
        {
            player.addChatMessage(new ChatComponentTranslation(message));
            return false;
        }
        return true;
    }

    @SubscribeEvent
    public void onPlayerFall(LivingFallEvent event)
    {
        ItemStack armor = event.entityLiving.getEquipmentInSlot(1);
        if((armor != null) && (armor.getItem() == UltimateGraviSuiteMod.ultimateBoots))
        {
            int fallDamage = Math.max((int)event.distance - 10, 0);
            int energyCost = 10000 * fallDamage;
            if(energyCost <= ElectricItem.manager.getCharge(armor))
            {
                ElectricItem.manager.discharge(armor, energyCost, Integer.MAX_VALUE, true, true, false);
                event.setCanceled(true);
            }
        }
    }
}