package sheridan.gcaa.items.gun.guns;

import net.minecraft.resources.ResourceLocation;
import sheridan.gcaa.GCAA;
import sheridan.gcaa.items.gun.Gun;
import sheridan.gcaa.items.gun.GunProperties;
import sheridan.gcaa.items.gun.calibers.Caliber;
import sheridan.gcaa.items.gun.fireModes.Semi;
import sheridan.gcaa.sounds.ModSounds;

import java.util.List;

public class Python357 extends Gun {
    private static final Caliber caliber =
            new Caliber(new ResourceLocation(GCAA.MODID, ".357_magnum"), 9f, 5.5f, 4.8f, 4f);

    public Python357() {
        super(new GunProperties(4.5f, 0.4f, 2f, 0.7f, 0.35f,
                3.6f, GunProperties.toRPM(160), getTicks(3.2f), getTicks(3.2f),
                6, 1.5f, 1.2f, 0.12f, 0.1f, 6,
                List.of(Semi.SEMI), ModSounds.PYTHON_357_FIRE, null, caliber));
    }
}
