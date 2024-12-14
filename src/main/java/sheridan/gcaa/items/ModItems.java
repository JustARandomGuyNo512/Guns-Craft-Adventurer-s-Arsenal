package sheridan.gcaa.items;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import sheridan.gcaa.GCAA;
import sheridan.gcaa.blocks.ModBlocks;
import sheridan.gcaa.items.ammunition.ammunitions.*;
import sheridan.gcaa.items.attachments.akStuff.AKImprovedDustCover;
import sheridan.gcaa.items.attachments.akStuff.AKRailBracket;
import sheridan.gcaa.items.attachments.arStuff.ARGasBlock;
import sheridan.gcaa.items.attachments.arStuff.ARStockTube;
import sheridan.gcaa.items.attachments.functional.GrenadeLauncher;
import sheridan.gcaa.items.attachments.grips.*;
import sheridan.gcaa.items.attachments.handguard.AKImprovedHandguard;
import sheridan.gcaa.items.attachments.handguard.ARRailedHandguard;
import sheridan.gcaa.items.attachments.handguard.M249RailedHandguard;
import sheridan.gcaa.items.attachments.mags.*;
import sheridan.gcaa.items.attachments.muzzle.*;
import sheridan.gcaa.items.attachments.scope.Acog;
import sheridan.gcaa.items.attachments.scope.ScopeX10;
import sheridan.gcaa.items.attachments.sight.*;
import sheridan.gcaa.items.attachments.stocks.CTRStock;
import sheridan.gcaa.items.gun.guns.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GCAA.MODID);

    public static final RegistryObject<Ammo9x19mm> AMMO_9X19MM = ITEMS.register("ammo9x19mm", Ammo9x19mm::new);
    public static final RegistryObject<Ammo556x45mm> AMMO_5_56X45MM = ITEMS.register("ammo5_56x45mm", Ammo556x45mm::new);
    public static final RegistryObject<Ammo762x51mm> AMMO_7_62X51MM = ITEMS.register("ammo7_62x51mm", Ammo762x51mm::new);
    public static final RegistryObject<Ammo12Gauge> AMMO_12GAUGE = ITEMS.register("ammo12gauge", Ammo12Gauge::new);
    public static final RegistryObject<Ammo762x39mm> AMMO_7_62X39MM = ITEMS.register("ammo7_62x39mm", Ammo762x39mm::new);
    public static final RegistryObject<Ammo45ACP> AMMO_45ACP = ITEMS.register("ammo_45acp", Ammo45ACP::new);
    public static final RegistryObject<Ammo357Magnum> AMMO_357MAGNUM = ITEMS.register("ammo_357magnum", Ammo357Magnum::new);
    public static final RegistryObject<AmmoVOG25> AMMO_VOG_25 = ITEMS.register("ammo_vog_25", AmmoVOG25::new);

    public static final RegistryObject<G19> G19 = ITEMS.register("g19", G19::new);
    public static final RegistryObject<Python357> PYTHON_357 = ITEMS.register("python_357", Python357::new);
    public static final RegistryObject<Vector45> VECTOR_45 = ITEMS.register("vector_45", Vector45::new);
    public static final RegistryObject<Akm> AKM = ITEMS.register("akm", Akm::new);
    public static final RegistryObject<M4a1> M4A1 = ITEMS.register("m4a1", M4a1::new);
    public static final RegistryObject<Awp> AWP = ITEMS.register("awp", Awp::new);
    public static final RegistryObject<M870> M870 = ITEMS.register("m870", M870::new);
    public static final RegistryObject<Xm1014> XM1014 = ITEMS.register("xm1014", Xm1014::new);
    public static final RegistryObject<M249> M249 = ITEMS.register("m249", M249::new);
    public static final RegistryObject<Mk47> MK47 = ITEMS.register("mk47", Mk47::new);

    public static final RegistryObject<UnknownAttachment> UNKNOWN_ATTACHMENT = ITEMS.register("unknown_attachment", UnknownAttachment::new);
    public static final RegistryObject<AKSuppressor> AK_SUPPRESSOR = ITEMS.register("ak_suppressor", AKSuppressor::new);
    public static final RegistryObject<ARSuppressor> AR_SUPPRESSOR = ITEMS.register("ar_suppressor", ARSuppressor::new);
    public static final RegistryObject<ShotGunSuppressor> SHOTGUN_SUPPRESSOR = ITEMS.register("shotgun_suppressor", ShotGunSuppressor::new);
    public static final RegistryObject<SniperSuppressor> SNIPER_SUPPRESSOR = ITEMS.register("sniper_suppressor", SniperSuppressor::new);
    public static final RegistryObject<OspreySuppressor> OSPREY_SUPPRESSOR = ITEMS.register("osprey_suppressor", OspreySuppressor::new);
    public static final RegistryObject<AKCompensator> AK_COMPENSATOR = ITEMS.register("ak_compensator", AKCompensator::new);
    public static final RegistryObject<PistolSuppressor> PISTOL_SUPPRESSOR = ITEMS.register("pistol_suppressor", PistolSuppressor::new);
    public static final RegistryObject<AKImprovedHandguard> AK_IMPROVED_HANDGUARD = ITEMS.register("ak_improved_handguard", AKImprovedHandguard::new);
    public static final RegistryObject<AKRailBracket> AK_RAIL_BRACKET = ITEMS.register("ak_rail_bracket", AKRailBracket::new);
    public static final RegistryObject<AKImprovedDustCover> AK_IMPROVED_DUST_COVER = ITEMS.register("ak_improved_dust_cover", AKImprovedDustCover::new);
    public static final RegistryObject<MicroRedDot> MICRO_RED_DOT = ITEMS.register("micro_red_dot", MicroRedDot::new);
    public static final RegistryObject<RedDot> RED_DOT = ITEMS.register("red_dot", RedDot::new);
    public static final RegistryObject<Holographic> HOLOGRAPHIC = ITEMS.register("holographic", Holographic::new);
    public static final RegistryObject<ScopeX10> SCOPE_X10 = ITEMS.register("scope_x10", ScopeX10::new);
    public static final RegistryObject<VerticalGrip> VERTICAL_GRIP = ITEMS.register("vertical_grip", VerticalGrip::new);
    public static final RegistryObject<GrenadeLauncher> GP_25 = ITEMS.register("gp_25", GrenadeLauncher::new);
    public static final RegistryObject<Acog> ACOG = ITEMS.register("acog", Acog::new);
    public static final RegistryObject<ARGasBlock> AR_GAS_BLOCK = ITEMS.register("ar_gas_block", ARGasBlock::new);
    public static final RegistryObject<ARStockTube> AR_STOCK_TUBE = ITEMS.register("ar_stock_tube", ARStockTube::new);
    public static final RegistryObject<ARRailedHandguard> AR_RAILED_HANDGUARD = ITEMS.register("ar_railed_handguard", ARRailedHandguard::new);
    public static final RegistryObject<M249RailedHandguard> M249_RAILED_HANDGUARD = ITEMS.register("m249_railed_handguard", M249RailedHandguard::new);
    public static final RegistryObject<ARExtendMag> AR_EXTEND_MAG = ITEMS.register("ar_extend_mag", ARExtendMag::new);
    public static final RegistryObject<AKExtendMag> AK_EXTEND_MAG = ITEMS.register("ak_extend_mag", AKExtendMag::new);
    public static final RegistryObject<GlockExtendMag> GLOCK_EXTEND_MAG = ITEMS.register("glock_extend_mag", GlockExtendMag::new);
    public static final RegistryObject<Vector45ExtendMag> VECTOR_45_EXTEND_MAG = ITEMS.register("vector_45_extend_mag", Vector45ExtendMag::new);
    public static final RegistryObject<ShotgunExtendBay> SHOTGUN_EXTEND_BAY = ITEMS.register("shotgun_extend_bay", ShotgunExtendBay::new);
    public static final RegistryObject<SniperExtendMag> SNIPER_EXTEND_MAG = ITEMS.register("sniper_extend_mag", SniperExtendMag::new);
    public static final RegistryObject<CTRStock> CTR_STOCK = ITEMS.register("ctr_stock", CTRStock::new);
    public static final RegistryObject<ARCompensator> AR_COMPENSATOR = ITEMS.register("ar_compensator", ARCompensator::new);
    public static final RegistryObject<SMGCompensator> SMG_COMPENSATOR = ITEMS.register("smg_compensator", SMGCompensator::new);
    public static final RegistryObject<MicroLaserSight> MICRO_LASER_SIGHT = ITEMS.register("micro_laser_sight", MicroLaserSight::new);
    public static final RegistryObject<HorizontalLaserSight> HORIZONTAL_LASER_SIGHT = ITEMS.register("horizontal_laser_sight", HorizontalLaserSight::new);
    public static final RegistryObject<NormalLaserSight> LASER_SIGHT = ITEMS.register("laser_sight", NormalLaserSight::new);
    public static final RegistryObject<RailPanel> RAIL_PANEL = ITEMS.register("rail_panel", RailPanel::new);
    public static final RegistryObject<RailPanelShort> RAL_PANEL_SHORT = ITEMS.register("rail_panel_short", RailPanelShort::new);
    public static final RegistryObject<MicroFlashLight> MICRO_FLASHLIGHT = ITEMS.register("micro_flashlight", MicroFlashLight::new);
    public static final RegistryObject<NormalFlashlight> FLASHLIGHT = ITEMS.register("flashlight", NormalFlashlight::new);
    public static final RegistryObject<Okp7A> OKP_7_A = ITEMS.register("okp7_a", Okp7A::new);
    public static final RegistryObject<Okp7B> OKP_7_B = ITEMS.register("okp7_b", Okp7B::new);

    public static final RegistryObject<TransactionTerminal> TRANSACTION_TERMINAL = ITEMS.register("transaction_terminal", TransactionTerminal::new);

    public static final RegistryObject<Item> AMMUNITION_PROCESSOR = ITEMS.register("ammunition_processor", () -> new BlockItem(ModBlocks.AMMUNITION_PROCESSOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> VENDING_MACHINE = ITEMS.register("vending_machine", () -> new BlockItem(ModBlocks.VENDING_MACHINE.get(), new Item.Properties()));

    public static final RegistryObject<Item> BULLET_CRAFTING = ITEMS.register("bullet_crafting_table", () -> new BlockItem(ModBlocks.BULLET_CRAFTING.get(), new Item.Properties()));

    public static final RegistryObject<Item> THIN_COPPER_PLATE = ITEMS.register("thin_copper_plate", BaseItem::new);
    public static final RegistryObject<Item> ORE_LEAD = ITEMS.register("ore_lead", () -> new BlockItem(ModBlocks.ORE_LEAD.get(), new Item.Properties()));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", BaseItem::new);
    public static final RegistryObject<Item> LEAD_BLOCK = ITEMS.register("lead_block", () -> new BlockItem(ModBlocks.LEAD_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget", BaseItem::new);
    public static final RegistryObject<Item> ORE_ASPHALT = ITEMS.register("ore_asphalt", () -> new BlockItem(ModBlocks.ORE_ASPHALT.get(), new Item.Properties()));
    public static final RegistryObject<Item> PLASTIC = ITEMS.register("plastic", BaseItem::new);
}
