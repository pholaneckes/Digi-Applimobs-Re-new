package love.digimons.digi_applimobs.items.tools;

import love.digimons.digi_applimobs.event.CapTb;
import love.digimons.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import love.digimons.digi_applimobs.util.varia.DenShiNouRyokuProcider;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;

import static org.apache.commons.lang3.RandomUtils.nextFloat;

public class ModInfBow extends ProjectileWeaponItem implements Vanishable {
    public ModInfBow(Item.Properties itemProp) {
        super(itemProp);
    }

    public void releaseUsing(ItemStack item_stack, Level world, LivingEntity livEnti, int i4) {
        if (livEnti instanceof Player && !world.isClientSide) {
            Player Player = (Player)livEnti;
            LazyOptional<AppliDenShiNouRyoku> capability = Player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);
            capability.ifPresent(cpb->{
            boolean flag = true;//Player.abilities.instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, item_stack) > 0;
            ItemStack itemstack = Player.getProjectile(item_stack);

            int i = this.getUseDuration(item_stack) - i4;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(item_stack, world, Player, i, !itemstack.isEmpty() || flag);
            if (i < 0) {
                return;
            }

                itemstack.isEmpty();
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = getPowerForTime(i);
                if (!((double)f < 0.05D)) {
                    //boolean flag1 = true;//Player.abilities.instabuild || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, item_stack, Player));
                    ArrowItem arrowitem = (ArrowItem) (itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                    if (arrowitem != Items.TIPPED_ARROW || arrowitem != Items.SPECTRAL_ARROW){
                        arrowitem = (ArrowItem)Items.ARROW;
                    }
                    AbstractArrow abstractarrowentity = arrowitem.createArrow(world, itemstack, Player);
                    abstractarrowentity = customArrow(abstractarrowentity);
                    abstractarrowentity.shootFromRotation(Player, Player.xRotO, Player.yRotO, 0.0F, f * 3.0F, 1.0F);
                    if (f == 0.6F) {
                        abstractarrowentity.setCritArrow(true);
                    }

                    int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, item_stack);
                    if (j > 0) {
                        abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + (double)j * 0.5D + 0.5D);
                        cpb.setDenSNR(cpb.getDenSNR()-0.05f);
                    }

                    int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, item_stack);
                    if (k > 0) {
                        abstractarrowentity.setKnockback(k);
                        cpb.setDenSNR(cpb.getDenSNR()-0.05f);
                    }

                    if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, item_stack) > 0) {
                        abstractarrowentity.setSecondsOnFire(100);
                        cpb.setDenSNR(cpb.getDenSNR()-0.15f);
                    }

                    item_stack.hurtAndBreak(1, Player, (p_220009_1_) -> {
                        p_220009_1_.broadcastBreakEvent(Player.getUsedItemHand());
                    });
                    if (Player.getAbilities().instabuild || itemstack.getItem() != Items.TIPPED_ARROW || (itemstack.getItem() == Items.TIPPED_ARROW && cpb.getDenSNR() >= 25)) {
                            abstractarrowentity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        if(cpb.getDenSNR() >= 25) {
                            cpb.setDenSNR(cpb.getDenSNR() - 3.5f);
                            CapTb.serverDSNRPackSend(Player,cpb);
                        }else {itemstack.shrink(1);}
                        }

                    world.addFreshEntity(abstractarrowentity);
                    if (itemstack.getItem() == Items.TIPPED_ARROW) {
                            if(cpb.getDenSNR() >= 25){
                                cpb.setDenSNR(cpb.getDenSNR()-24);
                                //NetworkRegHandler.CHANNEL.send(PacketDistributor.PLAYER.with(()-> (ServerPlayer)Player), new Cap(cpb.getDenSNR()));
                                CapTb.serverDSNRPackSend(Player,cpb);
                            }else {
                                itemstack.shrink(1);
                            }
                        if (itemstack.isEmpty()) {
                            Player.getInventory().removeItem(itemstack);
                        }
                    }

                    world.playSound(Player, Player.getX(), Player.getY(), Player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    Player.awardStat(Stats.ITEM_USED.get(this));
                }
            });
        }
    }

    public static float getPowerForTime(int forTime) {
        float f = (float)forTime / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override
    public int getUseDuration(ItemStack itemstack) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemstackA) {
        return UseAnim.BOW;
    }

    //@OnlyIn(Dist.CLIENT)
    public boolean isPowerOff(Player player){
        AtomicBoolean isPowerOver = new AtomicBoolean(false);
            LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);
            capability.ifPresent(cpb -> {
                isPowerOver.set(!(cpb.getDenSNR() >= 25));
                if(cpb.getDenSNR() >= 25){
                    cpb.setDenSNR(cpb.getDenSNR()-1f);
                }
            });
            return isPowerOver.get();
    }

    public void setBowDamage(ItemStack itemStack, Player player){
        LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);
        capability.ifPresent(cpb -> {
            int dsnrNow = (int)cpb.getDenSNR();
            int dsnrSet = Math.max(0,dsnrNow <=3 ? (itemStack.getMaxDamage()-(itemStack.getMaxDamage()-5)) : itemStack.getMaxDamage()-dsnrNow-1);
            itemStack.setDamageValue(dsnrSet);
        });
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldUse, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        boolean flag = !player.getProjectile(itemstack).isEmpty();

        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldUse, player, hand, flag);
        if (ret != null) return ret;


        if (!player.getAbilities().instabuild && !flag && isPowerOff(player)) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            player.startUsingItem(hand);
            setBowDamage(itemstack,player);
            return InteractionResultHolder.consume(itemstack);
        }
    }


    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    public AbstractArrow customArrow(AbstractArrow arrow) {
        return arrow;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 15;
    }
}
