package sheridan.gcaa.items.gun.guns;

import net.minecraft.resources.ResourceLocation;
import sheridan.gcaa.GCAA;
import sheridan.gcaa.items.attachments.Attachment;
import sheridan.gcaa.items.gun.Gun;
import sheridan.gcaa.items.gun.GunProperties;
import sheridan.gcaa.items.gun.calibers.Caliber;
import sheridan.gcaa.items.gun.fireModes.Auto;
import sheridan.gcaa.items.gun.fireModes.Burst;
import sheridan.gcaa.items.gun.fireModes.Semi;
import sheridan.gcaa.sounds.ModSounds;

import java.util.Arrays;

public class Vector45 extends Gun {
    private static final Caliber caliber =
            new Caliber(new ResourceLocation(GCAA.MODID, ".45"),7.5f, 4.5f, 4f, 5f);

    public Vector45() {
        super(new GunProperties(4f, 0.6f, 2.6f, 0.75f, 0.16f,
                3.2f, GunProperties.toRPM(1000), getTicks(2.45f), getTicks(3.05f), 13,
                1.45f, 0.65f, 0.13f, 0.1f, 10, Arrays.asList(Semi.SEMI, new Burst(2), Auto.AUTO),
                ModSounds.VECTOR_45_FIRE, null, caliber));
    }
}
