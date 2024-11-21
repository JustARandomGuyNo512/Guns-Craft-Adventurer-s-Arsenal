package sheridan.gcaa;

import net.minecraft.world.item.Items;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import sheridan.gcaa.attachmentSys.AttachmentSlot;
import sheridan.gcaa.attachmentSys.common.AttachmentsRegister;
import sheridan.gcaa.attachmentSys.proxies.AkmAttachmentSlotProxy;
import sheridan.gcaa.attachmentSys.proxies.Mk47AttachmentSlotProxy;
import sheridan.gcaa.items.ModItems;
import sheridan.gcaa.items.attachments.replaceableParts.Mk47Handguard;
import sheridan.gcaa.items.attachments.replaceableParts.RecoilControlPart;
import sheridan.gcaa.items.attachments.replaceableParts.RecoilLowerPart;
import sheridan.gcaa.items.attachments.replaceableParts.WeightPart;
import sheridan.gcaa.service.ProductsRegister;
import sheridan.gcaa.service.product.AmmunitionProduct;
import sheridan.gcaa.service.product.CommonProduct;
import sheridan.gcaa.service.product.GunProduct;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static sheridan.gcaa.items.attachments.Attachment.MUZZLE;
import static sheridan.gcaa.items.attachments.Attachment.STOCK;
import static sheridan.gcaa.items.attachments.Attachment.GRIP;
import static sheridan.gcaa.items.attachments.Attachment.MAG;
import static sheridan.gcaa.items.attachments.Attachment.HANDGUARD;
import static sheridan.gcaa.items.attachments.Attachment.SCOPE;

public class Commons {
    public static long SERVER_START_TIME = System.currentTimeMillis();

    public static void onCommonSetUp(final FMLCommonSetupEvent event) {

        AttachmentsRegister.registerAttachmentSlot(ModItems.AKM.get(), AttachmentSlot.root()
                .addChild(new AttachmentSlot(MUZZLE, Set.of("gcaa:ak_suppressor", "gcaa:ak_compensator")))
                .addChild(new AttachmentSlot(MAG, Set.of("gcaa:ak_extend_mag")))
                .addChild(new AttachmentSlot(GRIP, Set.of()))
                .addChild(new AttachmentSlot("rail_set", Set.of("gcaa:ak_rail_bracket")))
                .addChild(new AttachmentSlot(HANDGUARD, Set.of("gcaa:ak_improved_handguard")).setReplaceableGunPart(new WeightPart(1)))
                .addChild(new AttachmentSlot(STOCK, Set.of("gcaa:ar_stock_tube")).setReplaceableGunPart(new RecoilControlPart(1, 0.1f, 0.1f)))
                .addChild(new AttachmentSlot("dust_cover", Set.of("gcaa:ak_improved_dust_cover", "gcaa:ak_tactical_dust_cover"))),
                 AkmAttachmentSlotProxy::new
        );

        AttachmentsRegister.registerAttachmentSlot(ModItems.M4A1.get(), AttachmentSlot.root()
                .addChild(new AttachmentSlot(MUZZLE, Set.of("gcaa:ar_suppressor", "gcaa:ar_compensator")))
                .addChild(new AttachmentSlot(MAG, Set.of("gcaa:ar_extend_mag")))
                .addChild(new AttachmentSlot(GRIP, Set.of()))
                .addChild(new AttachmentSlot(HANDGUARD, Set.of("gcaa:ar_railed_handguard")).setReplaceableGunPart(new RecoilControlPart(0.8f, 0.05f, 0.05f)))
                .addChild(new AttachmentSlot(STOCK, Set.of("gcaa:ctr_stock")).setReplaceableGunPart(new WeightPart(1)))
                .addChild(new AttachmentSlot("gas_block", Set.of("gcaa:ar_gas_block")))
                .addChild(new AttachmentSlot(SCOPE, Set.of("gcaa:red_dot", "gcaa:holographic", "gcaa:acog")).setReplaceableGunPart(new WeightPart(0.5f)))
        );

        AttachmentsRegister.registerAttachmentSlot(ModItems.G19.get(), AttachmentSlot.root()
                .addChild(new AttachmentSlot(MUZZLE, Set.of("gcaa:pistol_suppressor", "gcaa:osprey_suppressor")))
                .addChild(new AttachmentSlot(SCOPE, Set.of("gcaa:micro_red_dot")))
                .addChild(new AttachmentSlot(GRIP, Set.of("gcaa:micro_laser_sight", "gcaa:micro_flashlight")))
                .addChild(new AttachmentSlot(MAG, Set.of("gcaa:glock_extend_mag")))
        );

        AttachmentsRegister.registerAttachmentSlot(ModItems.PYTHON_357.get(), AttachmentSlot.EMPTY);

        AttachmentsRegister.registerAttachmentSlot(ModItems.AWP.get(), AttachmentSlot.root()
                .addChild(new AttachmentSlot(MUZZLE, Set.of("gcaa:sniper_suppressor")).setReplaceableGunPart(new RecoilLowerPart(0, 0.15f, 0.15f)))
                .addChild(new AttachmentSlot(SCOPE, Set.of("gcaa:red_dot", "gcaa:holographic", "gcaa:scope_x10", "gcaa:acog")))
                .addChild(new AttachmentSlot(MAG, "mag", Set.of("gcaa:sniper_extend_mag")))
        );

        AttachmentsRegister.registerAttachmentSlot(ModItems.M870.get(), AttachmentSlot.root()
                .addChild(new AttachmentSlot(MUZZLE, Set.of("gcaa:shotgun_suppressor")))
                .addChild(new AttachmentSlot(STOCK, Set.of()))
                .addChild(new AttachmentSlot(MAG, Set.of("gcaa:shotgun_extend_bay")))
                .addChild(new AttachmentSlot(HANDGUARD, Set.of()))
        );

        Set<String> mk47HandguardSlot = new HashSet<>(List.of(
                "gcaa:laser_sight",
                "gcaa:horizontal_laser_sight",
                "gcaa:rail_panel",
                "gcaa:rail_panel_short",
                "gcaa:flashlight"));

        AttachmentsRegister.registerAttachmentSlot(ModItems.M249.get(), AttachmentSlot.root()
                .addChild(new AttachmentSlot(SCOPE, Set.of("gcaa:red_dot", "gcaa:holographic", "gcaa:acog")))
                .addChild(new AttachmentSlot(GRIP, Set.of()))
                .addChild(new AttachmentSlot(MUZZLE, Set.of("gcaa:ar_suppressor", "gcaa:ar_compensator")))
                .addChild(new AttachmentSlot(STOCK, Set.of("gcaa:ar_stock_tube")).setReplaceableGunPart(new RecoilControlPart(1.2f, 0.1f, 0.08f)))
                .addChild(new AttachmentSlot(MAG, Set.of()).setReplaceableGunPart(new WeightPart(3f)))
                .addChild(new AttachmentSlot(HANDGUARD, Set.of("gcaa:m249_railed_handguard")).setReplaceableGunPart(new WeightPart(0.5f)))
                .addChild(new AttachmentSlot("handguard_grip", Set.of(
                        "gcaa:laser_sight",
                        "gcaa:flashlight",
                        "gcaa:horizontal_laser_sight",
                        "gcaa:rail_panel",
                        "gcaa:rail_panel_short",
                        "gcaa:vertical_grip"
                )).lower().lock())
                .addChild(new AttachmentSlot("handguard_left", mk47HandguardSlot).lower().lock())
                .addChild(new AttachmentSlot("handguard_right", mk47HandguardSlot).lower().lock())
        );

        AttachmentsRegister.registerAttachmentSlot(ModItems.VECTOR_45.get(), AttachmentSlot.root()
                .addChild(new AttachmentSlot(SCOPE, Set.of("gcaa:red_dot", "gcaa:holographic", "gcaa:acog")))
                .addChild(new AttachmentSlot(MUZZLE, Set.of("gcaa:osprey_suppressor"," gcaa:pistol_suppressor", "gcaa:smg_compensator")))
                .addChild(new AttachmentSlot(STOCK, Set.of("gcaa:ar_stock_tube")).setReplaceableGunPart(new RecoilControlPart(0.7f, 0.05f, 0.06f)))
                .addChild(new AttachmentSlot(MAG, Set.of("gcaa:vector_45_extend_mag")))
                .addChild(new AttachmentSlot(GRIP, Set.of("gcaa:vertical_grip", "gcaa:rail_panel_short", "gcaa:laser_sight", "gcaa:flashlight")))
                .addChild(new AttachmentSlot("left",  Set.of("gcaa:laser_sight", "gcaa:flashlight", "gcaa:micro_flashlight")))
                .addChild(new AttachmentSlot("right", Set.of("gcaa:laser_sight", "gcaa:rail_panel_short", "gcaa:flashlight")))
        );

        AttachmentsRegister.registerAttachmentSlot(ModItems.XM1014.get(), AttachmentSlot.root()
                .addChild(new AttachmentSlot(SCOPE, Set.of("gcaa:red_dot", "gcaa:holographic", "gcaa:acog")))
                .addChild(new AttachmentSlot(MUZZLE, Set.of("gcaa:shotgun_suppressor")))
        );

        AttachmentsRegister.registerAttachmentSlot(ModItems.MK47.get(), AttachmentSlot.root()
                .addChild(new AttachmentSlot(SCOPE, Set.of("gcaa:red_dot", "gcaa:holographic", "gcaa:acog")))
                .addChild(new AttachmentSlot(HANDGUARD, Set.of()).setReplaceableGunPart(new Mk47Handguard()))
                .addChild(new AttachmentSlot(MAG, Set.of("gcaa:ak_extend_mag")))
                .addChild(new AttachmentSlot(STOCK, Set.of("gcaa:ctr_stock")))
                .addChild(new AttachmentSlot(MUZZLE, Set.of("gcaa:ak_compensator", "gcaa:ak_suppressor")))
                .addChild(new AttachmentSlot(GRIP, Set.of()))
                .addChild(new AttachmentSlot("handguard_scope", Set.of(
                        "gcaa:red_dot",
                        "gcaa:holographic",
                        "gcaa:acog",
                        "gcaa:horizontal_laser_sight",
                        "gcaa:rail_panel",
                        "gcaa:rail_panel_short")).upper())
                .addChild(new AttachmentSlot("handguard_left", mk47HandguardSlot).lower())
                .addChild(new AttachmentSlot("handguard_left_rear", mk47HandguardSlot).lower())
                .addChild(new AttachmentSlot("handguard_right", mk47HandguardSlot).lower())
                .addChild(new AttachmentSlot("handguard_right_rear", mk47HandguardSlot).lower())
                .addChild(new AttachmentSlot("handguard_lower", Set.of(
                        "gcaa:laser_sight",
                        "gcaa:horizontal_laser_sight",
                        "gcaa:flashlight",
                        "gcaa:rail_panel_short")).lower())
                .addChild(new AttachmentSlot("handguard_grip", Set.of(
                        "gcaa:laser_sight",
                        "gcaa:horizontal_laser_sight",
                        "gcaa:flashlight",
                        "gcaa:rail_panel",
                        "gcaa:rail_panel_short",
                        "gcaa:vertical_grip",
                        "gcaa:gp_25")).lower()),
                Mk47AttachmentSlotProxy::new
        );


        ProductsRegister.registerProducts(ProductsRegister.EXCHANGE,
                new CommonProduct(Items.GOLD_INGOT, 100),
                new CommonProduct(Items.DIAMOND, 200),
                new CommonProduct(Items.IRON_INGOT, 20));

        ProductsRegister.registerProducts(ProductsRegister.GUN,
                new GunProduct(ModItems.G19.get(), 800),
                new GunProduct(ModItems.PYTHON_357.get(), 700),
                new GunProduct(ModItems.VECTOR_45.get(), 1300),
                new GunProduct(ModItems.AKM.get(), 2700),
                new GunProduct(ModItems.M4A1.get(), 2900),
                new GunProduct(ModItems.MK47.get(), 3050),
                new GunProduct(ModItems.AWP.get(), 4750),
                new GunProduct(ModItems.M870.get(), 2000),
                new GunProduct(ModItems.XM1014.get(), 2400),
                new GunProduct(ModItems.M249.get(), 4400));

        ProductsRegister.registerProducts(ProductsRegister.AMMUNITION,
                new AmmunitionProduct(ModItems.AMMO_9X19MM.get(), 100),
                new AmmunitionProduct(ModItems.AMMO_357MAGNUM.get(), 150),
                new AmmunitionProduct(ModItems.AMMO_45ACP.get(), 180),
                new AmmunitionProduct(ModItems.AMMO_7_62X39MM.get(), 300),
                new AmmunitionProduct(ModItems.AMMO_5_56X45MM.get(), 280),
                new AmmunitionProduct(ModItems.AMMO_7_62X51MM.get(), 400),
                new AmmunitionProduct(ModItems.AMMO_12GAUGE.get(), 200),
                new AmmunitionProduct(ModItems.AMMO_VOG_25.get(), 100));

        ProductsRegister.registerProducts(ProductsRegister.ATTACHMENT,
                new CommonProduct(ModItems.PISTOL_SUPPRESSOR.get(), 50),
                new CommonProduct(ModItems.AK_SUPPRESSOR.get(), 110),
                new CommonProduct(ModItems.AR_SUPPRESSOR.get(), 130),
                new CommonProduct(ModItems.SHOTGUN_SUPPRESSOR.get(), 150),
                new CommonProduct(ModItems.SNIPER_SUPPRESSOR.get(), 210),
                new CommonProduct(ModItems.OSPREY_SUPPRESSOR.get(), 150),
                new CommonProduct(ModItems.AK_COMPENSATOR.get(), 180),
                new CommonProduct(ModItems.AR_COMPENSATOR.get(), 220),
                new CommonProduct(ModItems.SMG_COMPENSATOR.get(), 160),
                new CommonProduct(ModItems.AK_IMPROVED_HANDGUARD.get(), 270),
                new CommonProduct(ModItems.AK_RAIL_BRACKET.get(), 100),
                new CommonProduct(ModItems.AK_IMPROVED_DUST_COVER.get(), 100),
                new CommonProduct(ModItems.AK_TACTICAL_DUST_COVER.get(), 120),
                new CommonProduct(ModItems.MICRO_RED_DOT.get(), 75),
                new CommonProduct(ModItems.RED_DOT.get(), 102),
                new CommonProduct(ModItems.HOLOGRAPHIC.get(), 100),
                new CommonProduct(ModItems.ACOG.get(), 220),
                new CommonProduct(ModItems.SCOPE_X10.get(), 400),
                new CommonProduct(ModItems.VERTICAL_GRIP.get(), 80),
                new CommonProduct(ModItems.GP_25.get(), 240),
                new CommonProduct(ModItems.AR_GAS_BLOCK.get(), 30),
                new CommonProduct(ModItems.AR_STOCK_TUBE.get(), 60),
                new CommonProduct(ModItems.AR_RAILED_HANDGUARD.get(), 180),
                new CommonProduct(ModItems.M249_RAILED_HANDGUARD.get(), 100),
                new CommonProduct(ModItems.AR_EXTEND_MAG.get(), 150),
                new CommonProduct(ModItems.AK_EXTEND_MAG.get(), 170),
                new CommonProduct(ModItems.GLOCK_EXTEND_MAG.get(), 70),
                new CommonProduct(ModItems.VECTOR_45_EXTEND_MAG.get(), 130),
                new CommonProduct(ModItems.SNIPER_EXTEND_MAG.get(), 50),
                new CommonProduct(ModItems.SHOTGUN_EXTEND_BAY.get(), 70),
                new CommonProduct(ModItems.CTR_STOCK.get(), 166),
                new CommonProduct(ModItems.MICRO_LASER_SIGHT.get(), 30),
                new CommonProduct(ModItems.LASER_SIGHT.get(), 50),
                new CommonProduct(ModItems.MICRO_FLASHLIGHT.get(), 50),
                new CommonProduct(ModItems.FLASHLIGHT.get(), 70),
                new CommonProduct(ModItems.HORIZONTAL_LASER_SIGHT.get(), 60),
                new CommonProduct(ModItems.RAIL_PANEL.get(), 15),
                new CommonProduct(ModItems.RAL_PANEL_SHORT.get(), 10));

        ProductsRegister.registerProducts(ProductsRegister.OTHER,
                new CommonProduct(Items.IRON_INGOT, 20),
                new CommonProduct(Items.GOLD_INGOT, 100),
                new CommonProduct(Items.DIAMOND, 200));

    }
}
