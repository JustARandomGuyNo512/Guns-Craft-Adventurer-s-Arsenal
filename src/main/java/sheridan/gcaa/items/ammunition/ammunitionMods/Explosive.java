package sheridan.gcaa.items.ammunition.ammunitionMods;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.joml.Vector4i;
import sheridan.gcaa.GCAA;
import sheridan.gcaa.items.ammunition.Ammunition;
import sheridan.gcaa.items.ammunition.AmmunitionMod;
import sheridan.gcaa.items.ammunition.IAmmunition;
import sheridan.gcaa.utils.FontUtils;

import java.awt.*;

public class Explosive extends AmmunitionMod {
    private final float explosiveDamageRate = 0.5f;

    public Explosive() {
        super(new ResourceLocation(GCAA.MODID, "explosive"), 3, ICONS_0, new Vector4i(16, 0, 128, 128),
                "gcaa.ammunition_mod.explosive", new Color(0xe5944e).getRGB());
    }

    @Override
    public void onModifyAmmunition(IAmmunition ammunition, CompoundTag dataRateTag) {
        dataRateTag.putFloat(Ammunition.BASE_DAMAGE_RATE, dataRateTag.getFloat(Ammunition.BASE_DAMAGE_RATE) + 0.1f);
        dataRateTag.putFloat(Ammunition.MIN_DAMAGE_RATE, dataRateTag.getFloat(Ammunition.MIN_DAMAGE_RATE) + 0.1f);
        dataRateTag.putFloat(Ammunition.PENETRATION_RATE, dataRateTag.getFloat(Ammunition.PENETRATION_RATE) - 0.3f);
    }

    @Override
    public net.minecraft.network.chat.Component getSpecialDescription() {
        String str = net.minecraft.network.chat.Component.translatable("gcaa.ammunition_mod.explosive_special").getString().replace("$rate", FontUtils.toPercentageStr(explosiveDamageRate));
        return net.minecraft.network.chat.Component.empty().append("\n").append(Component.literal(str));
    }

    public float getExplosiveDamageRate() {
        return explosiveDamageRate;
    }
}
