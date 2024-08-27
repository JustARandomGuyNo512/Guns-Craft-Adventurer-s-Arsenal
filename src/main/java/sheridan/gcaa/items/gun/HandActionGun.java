package sheridan.gcaa.items.gun;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import sheridan.gcaa.Clients;
import sheridan.gcaa.client.*;
import sheridan.gcaa.utils.RenderAndMathUtils;

public class HandActionGun extends Gun{

    public HandActionGun(GunProperties gunProperties) {
        super(gunProperties);
    }

    @Override
    public void onCraftedBy(ItemStack pStack, Level pLevel, Player pPlayer) {
        super.onCraftedBy(pStack, pLevel, pPlayer);
        CompoundTag tag = pStack.getTag();
        if (tag != null && !tag.contains("need_hand_action")) {
            tag.putBoolean("need_hand_action", false);
        }
    }

    public boolean needHandAction(ItemStack itemStack) {
        CompoundTag tag = checkAndGet(itemStack);
        return tag.contains("need_hand_action") && tag.getBoolean("need_hand_action");
    }

    public void setNeedHandAction(ItemStack itemStack, boolean val) {
        checkAndGet(itemStack).putBoolean("need_hand_action", val);
    }

    @Override
    public void clientShoot(ItemStack stack, Player player, IGunFireMode fireMode) {
        super.clientShoot(stack, player, fireMode);
        setNeedHandAction(stack, true);
        HandActionHandler.INSTANCE.setHandActionTask(getHandActionTask(stack, false));
    }

    @Override
    public void shoot(ItemStack stack, Player player, IGunFireMode fireMode, float spread) {
        super.shoot(stack, player, fireMode, spread);
        setNeedHandAction(stack, true);
    }

    @Override
    public IReloadingTask getReloadingTask(ItemStack stack) {
        return new HandActionReloadingTask(stack, this);
    }

    public IHandActionTask getHandActionTask(ItemStack stack, boolean immediate) {
        return new HandActionTask(stack, this, immediate ? 0 : RenderAndMathUtils.secondsToTicks(0.5f), RenderAndMathUtils.secondsToTicks(1.25f), "bolt_action");
    }

    @Override
    public void reload(ItemStack stack, Player player) {
        super.reload(stack, player);
        setNeedHandAction(stack, false);
    }

    @Override
    public boolean shouldHandleAds(ItemStack stack) {
        boolean needHandAction = needHandAction(stack);
        if (needHandAction && !HandActionHandler.INSTANCE.hasTask()
                && getAmmoLeft(stack) > 0 && HandActionHandler.INSTANCE.secondsSinceLastTask() > 0.5f) {
            HandActionHandler.INSTANCE.setHandActionTask(getHandActionTask(stack, true));
        }
        if (needHandAction && RenderAndMathUtils.secondsFromNow(Clients.lastShootMain()) > 0.5f) {
            return false;
        }
        return super.shouldHandleAds(stack);
    }
}
