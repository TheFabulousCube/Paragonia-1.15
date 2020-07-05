package com.thefabulouscube.paragonia.init;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.objects.blocks.FoodBlock;
import com.thefabulouscube.paragonia.objects.blocks.OrthoBlock;
import com.thefabulouscube.paragonia.objects.blocks.RotationalBlock;
import com.thefabulouscube.paragonia.objects.blocks.ThreeWay;
import com.thefabulouscube.paragonia.objects.blocks.WideBlock;
import com.thefabulouscube.paragonia.util.AABB;
import com.thefabulouscube.paragonia.util.ParagoniaFoods;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Paragonia.MOD_ID);
	public static final DeferredRegister<Block> FOOD = new DeferredRegister<>(ForgeRegistries.BLOCKS, Paragonia.MOD_ID);
	public static final DeferredRegister<Block> FURNITURE = new DeferredRegister<>(ForgeRegistries.BLOCKS, Paragonia.MOD_ID);
	
	public static final RegistryObject<Block> BLOCK_PLAIN = BLOCKS.register("block_plain", () -> new WideBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
	public static final RegistryObject<Block> BLOCK_DIRTY = BLOCKS.register("block_dirty", () -> new WideBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
	public static final RegistryObject<Block> BLOCK_DARK = BLOCKS.register("block_dark", () -> new WideBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
	public static final RegistryObject<Block> BLOCK_LIGHT = BLOCKS.register("block_light", () -> new WideBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));

	public static final RegistryObject<Block> SCALE = BLOCKS.register("scale", () -> new ThreeWay(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5F, 6.0F), AABB.Scales()));

	public static final RegistryObject<Block> BOOKS_RED = BLOCKS.register("books_red", () -> new RotationalBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.5F, 6.0F), AABB.BOOKS_RED));
	public static final RegistryObject<Block> BOOKREST = BLOCKS.register("bookrest", () -> new RotationalBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.5F, 6.0F), AABB.BOOKREST));
	// Foods
	public static final RegistryObject<Block> APPLE = FOOD.register("apple", () -> new FoodBlock(Block.Properties.create(Material.GOURD), ParagoniaFoods.APPLE, AABB.APPLE));
	public static final RegistryObject<Block> BEET = FOOD.register("beet", () -> new FoodBlock(Block.Properties.create(Material.GOURD), ParagoniaFoods.BEET, AABB.BEET));
	public static final RegistryObject<Block> BREAD_1 = FOOD.register("bread_1", () -> new FoodBlock(Block.Properties.create(Material.GOURD), ParagoniaFoods.BREAD_1, AABB.BREAD_1));
	public static final RegistryObject<Block> MEAT_DRUMSTICK = FOOD.register("meat_drumstick", () -> new FoodBlock(Block.Properties.create(Material.GOURD), ParagoniaFoods.MEAT_DRUMSTICK, AABB.MEAT_DRUMSTICK));
	public static final RegistryObject<Block> MEAT_HAM = FOOD.register("meat_ham", () -> new FoodBlock(Block.Properties.create(Material.GOURD), ParagoniaFoods.MEAT_HAM, AABB.MEAT_HAM));
	public static final RegistryObject<Block> MEAT_HUNK = FOOD.register("meat_hunk", () -> new FoodBlock(Block.Properties.create(Material.GOURD), ParagoniaFoods.MEAT_HUNK, AABB.MEAT_HUNK));
	public static final RegistryObject<Block> ORANGE = FOOD.register("orange", () -> new FoodBlock(Block.Properties.create(Material.GOURD), ParagoniaFoods.ORANGE, AABB.ORANGE));
	public static final RegistryObject<Block> PIE = FOOD.register("pie", () -> new FoodBlock(Block.Properties.create(Material.GOURD), ParagoniaFoods.PIE, AABB.PIE));
	public static final RegistryObject<Block> POTATO = FOOD.register("potato", () -> new FoodBlock(Block.Properties.create(Material.GOURD), ParagoniaFoods.POTATO, AABB.POTATO));
//	public static final RegistryObject<Block> PUMPKIN_LARGE = BLOCKS.register("pumpkin_large", () -> new OrthoBlock(Block.Properties.create(Material.GOURD), AABB.PUMPKIN_LARGE));
//	public static final RegistryObject<Block> PUMPKIN_SMALL = BLOCKS.register("pumpkin_small", () -> new OrthoBlock(Block.Properties.create(Material.GOURD), AABB.PUMPKIN_SMALL));
 
	// Reviewed
	// Model file already has rotation, this is not suitable for Rotational
	public static final RegistryObject<Block> APIARY = BLOCKS.register("apiary", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.APIARY));
	public static final RegistryObject<Block> CANDLE_CANDELABRA_GOLD = BLOCKS.register("candle_candelabra_gold", () -> new OrthoBlock(Block.Properties.create(Material.IRON).lightValue(15), AABB.CANDLE_CANDELABRA));
	public static final RegistryObject<Block> CANDLE_CANDELABRA_IRON = BLOCKS.register("candle_candelabra_iron", () -> new OrthoBlock(Block.Properties.create(Material.IRON).lightValue(13), AABB.CANDLE_CANDELABRA));
	public static final RegistryObject<Block> GEM_CALIPERS_1 = BLOCKS.register("gem_calipers_1", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.GEM_CALIPERS_1));
	public static final RegistryObject<Block> GEM_CALIPERS_2 = BLOCKS.register("gem_calipers_2", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.GEM_CALIPERS_2));
	
	// Okay for Rotational
	public static final RegistryObject<Block> BOTTLE_1 = BLOCKS.register("bottle_1", () -> new RotationalBlock(Block.Properties.create(Material.GLASS), AABB.BOTTLE_1));
	public static final RegistryObject<Block> BOTTLE_2 = BLOCKS.register("bottle_2", () -> new RotationalBlock(Block.Properties.create(Material.GLASS), AABB.BOTTLE_2));
	public static final RegistryObject<Block> BOTTLE_WINE = BLOCKS.register("bottle_wine", () -> new RotationalBlock(Block.Properties.create(Material.GLASS), AABB.BOTTLE_WINE));
	public static final RegistryObject<Block> CANDLE_CANDLESTICK_GOLD = BLOCKS.register("candle_candlestick_gold", () -> new RotationalBlock(Block.Properties.create(Material.IRON).lightValue(10), AABB.CANDLE_CANDLESTICK));
	public static final RegistryObject<Block> CANDLE_CANDLESTICK_IRON = BLOCKS.register("candle_candlestick_iron", () -> new RotationalBlock(Block.Properties.create(Material.IRON).lightValue(9), AABB.CANDLE_CANDLESTICK));
	public static final RegistryObject<Block> CANDLE_LARGE = BLOCKS.register("candle_large", () -> new RotationalBlock(Block.Properties.create(Material.WOOD).lightValue(5), AABB.CANDLE_LARGE));
	public static final RegistryObject<Block> CANDLE_SKULL = BLOCKS.register("candle_skull", () -> new RotationalBlock(Block.Properties.create(Material.WOOD).lightValue(7), AABB.CANDLE_SKULL));
	public static final RegistryObject<Block> CANDLE_SMALL = BLOCKS.register("candle_small", () -> new RotationalBlock(Block.Properties.create(Material.WOOD).lightValue(4), AABB.CANDLE_SMALL));
	public static final RegistryObject<Block> HOURGLASS = BLOCKS.register("hourglass", () -> new RotationalBlock(Block.Properties.create(Material.GLASS), AABB.HOURGLASS));
	public static final RegistryObject<Block> INKWELL = BLOCKS.register("inkwell", () -> new RotationalBlock(Block.Properties.create(Material.WOOD), AABB.INKWELL));
	
	// in Process
	public static final RegistryObject<Block> CANDLES_RITUAL = BLOCKS.register("candles_ritual", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.CANDLES_RITUAL));
	public static final RegistryObject<Block> CANDLE_CHAMBERSTICK = BLOCKS.register("candle_chamberstick", () -> new RotationalBlock(Block.Properties.create(Material.WOOD), AABB.CANDLE_CHAMBERSTICK));
	public static final RegistryObject<Block> GONG = BLOCKS.register("gong", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.GONG));
	

	// GENERATED
	public static final RegistryObject<Block> AXE = BLOCKS.register("axe", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.AXE));
//	public static final RegistryObject<Block> BANNER_SIMPLE_BLACK = BLOCKS.register("banner_simple_black", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BANNER));
//	public static final RegistryObject<Block> BANNER_SIMPLE_BLUE = BLOCKS.register("banner_simple_blue", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BANNER));
//	public static final RegistryObject<Block> BANNER_SIMPLE_BROWN = BLOCKS.register("banner_simple_brown", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BANNER));
//	public static final RegistryObject<Block> BANNER_SIMPLE_CYAN = BLOCKS.register("banner_simple_cyan", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BANNER));
//	public static final RegistryObject<Block> BANNER_SIMPLE_GREEN = BLOCKS.register("banner_simple_green", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BANNER));
//	public static final RegistryObject<Block> BANNER_SIMPLE_GREY = BLOCKS.register("banner_simple_grey", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BANNER));
//	public static final RegistryObject<Block> BANNER_SIMPLE_LIGHTBLUE = BLOCKS.register("banner_simple_lightblue", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BANNER));
//	public static final RegistryObject<Block> BANNER_SIMPLE_LIGHTGREY = BLOCKS.register("banner_simple_lightgrey", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BANNER));
//	public static final RegistryObject<Block> BANNER_SIMPLE_LIME = BLOCKS.register("banner_simple_lime", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BANNER));
//	public static final RegistryObject<Block> BANNER_SIMPLE_MAGENTA = BLOCKS.register("banner_simple_magenta", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BANNER));
//	public static final RegistryObject<Block> BANNER_SIMPLE_ORANGE = BLOCKS.register("banner_simple_orange", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BANNER));
//	public static final RegistryObject<Block> BANNER_SIMPLE_PINK = BLOCKS.register("banner_simple_pink", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BANNER));
//	public static final RegistryObject<Block> BANNER_SIMPLE_PURPLE = BLOCKS.register("banner_simple_purple", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BANNER));
//	public static final RegistryObject<Block> BANNER_SIMPLE_RED = BLOCKS.register("banner_simple_red", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BANNER));
//	public static final RegistryObject<Block> BANNER_SIMPLE_WHITE = BLOCKS.register("banner_simple_white", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BANNER));
//	public static final RegistryObject<Block> BANNER_SIMPLE_YELLOW = BLOCKS.register("banner_simple_yellow", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BANNER));
//	public static final RegistryObject<Block> BARREL = BLOCKS.register("barrel", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BARREL));
//	public static final RegistryObject<Block> BARREL_ROPE = BLOCKS.register("barrel_rope", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BARREL));
//	public static final RegistryObject<Block> BASKET_WOODEN = BLOCKS.register("basket_wooden", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BASKET_WOODEN));
//	public static final RegistryObject<Block> BEDROLL_ROLLED = BLOCKS.register("bedroll_rolled", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BEDROLL_ROLLED));
//	public static final RegistryObject<Block> BIN = BLOCKS.register("bin", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BIN));
//	public static final RegistryObject<Block> BLOCK_COIN = BLOCKS.register("block_coin", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BLOCK_COIN));
//	public static final RegistryObject<Block> BLOCK_CRATE = BLOCKS.register("block_crate", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BLOCK_CRATE));
	

//	public static final RegistryObject<Block> BOOK_OPEN = BLOCKS.register("book_open", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BOOK_OPEN));
//	public static final RegistryObject<Block> BOOK_OPEN_WRITTEN = BLOCKS.register("book_open_written", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BOOK_OPEN_WRITTEN));
//	public static final RegistryObject<Block> BRICK_PILE = BLOCKS.register("brick_pile", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BRICK_PILE));
//	public static final RegistryObject<Block> BROOM = BLOCKS.register("broom", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BROOM));
//	public static final RegistryObject<Block> BUCKET = BLOCKS.register("bucket", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BUCKET));
//	public static final RegistryObject<Block> BUCKET_ROPE = BLOCKS.register("bucket_rope", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BUCKET_ROPE));
//	public static final RegistryObject<Block> CAGE_HORIZONTAL = BLOCKS.register("cage_horizontal", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.CAGE_HORIZONTAL));
//	public static final RegistryObject<Block> CAGE_VERTICAL = BLOCKS.register("cage_vertical", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.CAGE_VERTICAL));
//	public static final RegistryObject<Block> CARCASS_DEER = BLOCKS.register("carcass_deer", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.CARCASS_DEER));
//	public static final RegistryObject<Block> CASE_DISPLAY = BLOCKS.register("case_display", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.CASE_DISPLAY));
//	public static final RegistryObject<Block> CASE_DISPLAY_OPEN = BLOCKS.register("case_display_open", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.CASE_DISPLAY_OPEN));
//	public static final RegistryObject<Block> CHARM_HAND = BLOCKS.register("charm_hand", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.CHARM_HAND));
//	public static final RegistryObject<Block> CHOPPING_BLOCK = BLOCKS.register("chopping_block", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.CHOPPING_BLOCK));
//	public static final RegistryObject<Block> CLOTHESLINE_LARGE = BLOCKS.register("clothesline_large", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.CLOTHESLINE_LARGE));
//	public static final RegistryObject<Block> CLOTHESLINE_POST = BLOCKS.register("clothesline_post", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.CLOTHESLINE_POST));
//	public static final RegistryObject<Block> CLOTHESLINE_SMALL = BLOCKS.register("clothesline_small", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.CLOTHESLINE_SMALL));
//	public static final RegistryObject<Block> COFFIN_STONE = BLOCKS.register("coffin_stone", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.COFFIN_STONE));
//	public static final RegistryObject<Block> COFFIN_STONE_LID = BLOCKS.register("coffin_stone_lid", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.COFFIN_STONE_LID));
//	public static final RegistryObject<Block> COFFIN_WOOD = BLOCKS.register("coffin_wood", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.COFFIN_WOOD));
//	public static final RegistryObject<Block> COFFIN_WOOD_LID = BLOCKS.register("coffin_wood_lid", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.COFFIN_WOOD_LID));
//	public static final RegistryObject<Block> COIN_PILE = BLOCKS.register("coin_pile", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.COIN_PILE));
//	public static final RegistryObject<Block> COIN_STACK = BLOCKS.register("coin_stack", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.COIN_STACK));
//	public static final RegistryObject<Block> DUMMY_POST = BLOCKS.register("dummy_post", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.DUMMY_POST));
//	public static final RegistryObject<Block> DUMMY_SITTING = BLOCKS.register("dummy_sitting", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.DUMMY_SITTING));
//	public static final RegistryObject<Block> DUMMY_TARGET = BLOCKS.register("dummy_target", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.DUMMY_TARGET));
//	public static final RegistryObject<Block> FABRIC_STACK = BLOCKS.register("fabric_stack", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.FABRIC_STACK));
//	public static final RegistryObject<Block> FIREPIT = BLOCKS.register("firepit", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.FIREPIT));
//	public static final RegistryObject<Block> FISHING_POLE = BLOCKS.register("fishing_pole", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.FISHING_POLE));
//	public static final RegistryObject<Block> FISHING_RACK = BLOCKS.register("fishing_rack", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.FISHING_RACK));
//	public static final RegistryObject<Block> FISHING_SPEAR = BLOCKS.register("fishing_spear", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.FISHING_SPEAR));
//	public static final RegistryObject<Block> FISH_LARGE = BLOCKS.register("fish_large", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.FISH_LARGE));
//	public static final RegistryObject<Block> FLAMING_OIL = BLOCKS.register("flaming_oil", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.FLAMING_OIL));
//	public static final RegistryObject<Block> HAMMER = BLOCKS.register("hammer", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.HAMMER));
//	public static final RegistryObject<Block> HAMMER_SMALL = BLOCKS.register("hammer_small", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.HAMMER_SMALL));
//	public static final RegistryObject<Block> HATCHET = BLOCKS.register("hatchet", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.HATCHET));
//	public static final RegistryObject<Block> JEWELRY_BOX_CLOSED = BLOCKS.register("jewelry_box_closed", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.JEWELRY_BOX_CLOSED));
//	public static final RegistryObject<Block> JEWELRY_BOX_OPEN = BLOCKS.register("jewelry_box_open", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.JEWELRY_BOX_OPEN));
	public static final RegistryObject<Block> JOURNAL = BLOCKS.register("journal", () -> new RotationalBlock(Block.Properties.create(Material.WOOD), AABB.JOURNAL));
//	public static final RegistryObject<Block> KNIFE_BUTCHER = BLOCKS.register("knife_butcher", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.KNIFE_BUTCHER));
//	public static final RegistryObject<Block> KNIFE_CARVING = BLOCKS.register("knife_carving", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.KNIFE_CARVING));
//	public static final RegistryObject<Block> LANTERN_1 = BLOCKS.register("lantern_1", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.LANTERN_1));
//	public static final RegistryObject<Block> LANTERN_2 = BLOCKS.register("lantern_2", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.LANTERN_2));
//	public static final RegistryObject<Block> LANTERN_3 = BLOCKS.register("lantern_3", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.LANTERN_3));
//	public static final RegistryObject<Block> LEDGER_STAND = BLOCKS.register("ledger_stand", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.LEDGER_STAND));
//	public static final RegistryObject<Block> MAT_REEDS = BLOCKS.register("mat_reeds", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.MAT_REEDS));
//	public static final RegistryObject<Block> MAT_REEDS_ROLLED = BLOCKS.register("mat_reeds_rolled", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.MAT_REEDS_ROLLED));
//	public static final RegistryObject<Block> MESSAGE_BOARD = BLOCKS.register("message_board", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.MESSAGE_BOARD));
//	public static final RegistryObject<Block> MINECART = BLOCKS.register("minecart", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.MINECART));
//	public static final RegistryObject<Block> MINECART_COAL = BLOCKS.register("minecart_coal", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.MINECART_COAL));
//	public static final RegistryObject<Block> MORTAR_PESTLE = BLOCKS.register("mortar_pestle", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.MORTAR_PESTLE));
//	public static final RegistryObject<Block> MUG = BLOCKS.register("mug", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.MUG));
//	public static final RegistryObject<Block> ORANGE_BUNCH = BLOCKS.register("orange_bunch", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.ORANGE_BUNCH));
//	public static final RegistryObject<Block> PAPERS_1 = BLOCKS.register("papers_1", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.PAPERS_1));
//	public static final RegistryObject<Block> PAPERS_STACK = BLOCKS.register("papers_stack", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.PAPERS_STACK));
//	public static final RegistryObject<Block> PIE_DISH = BLOCKS.register("pie_dish", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.PIE_DISH));
//	public static final RegistryObject<Block> PLAQUE_DEER = BLOCKS.register("plaque_deer", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.PLAQUE_DEER));
//	public static final RegistryObject<Block> PLAQUE_FISH_LARGE = BLOCKS.register("plaque_fish_large", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.PLAQUE_FISH_LARGE));
//	public static final RegistryObject<Block> PLATE = BLOCKS.register("plate", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.PLATE));
//	public static final RegistryObject<Block> PLATE_SMALL = BLOCKS.register("plate_small", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.PLATE_SMALL));
//	public static final RegistryObject<Block> PODIUM_STONE = BLOCKS.register("podium_stone", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.PODIUM_STONE));
//	public static final RegistryObject<Block> POT = BLOCKS.register("pot", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.POT));
//	public static final RegistryObject<Block> QUILL = BLOCKS.register("quill", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.QUILL));
//	public static final RegistryObject<Block> SACK = BLOCKS.register("sack", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.SACK));
//	public static final RegistryObject<Block> SCALE = BLOCKS.register("scale", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.SCALE));
//	public static final RegistryObject<Block> SCROLL = BLOCKS.register("scroll", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.SCROLL));
//	public static final RegistryObject<Block> SCYTHE = BLOCKS.register("scythe", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.SCYTHE));
//	public static final RegistryObject<Block> SEAL_STONE = BLOCKS.register("seal_stone", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.SEAL_STONE));
//	public static final RegistryObject<Block> SIGN_STABLE = BLOCKS.register("sign_stable", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.SIGN_STABLE));
//	public static final RegistryObject<Block> SKULL_RAM = BLOCKS.register("skull_ram", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.SKULL_RAM));
//	public static final RegistryObject<Block> STARFISH_ORANGE = BLOCKS.register("starfish_orange", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.STARFISH_ORANGE));
//	public static final RegistryObject<Block> STARFISH_RED = BLOCKS.register("starfish_red", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.STARFISH_RED));
	public static final RegistryObject<Block> STATION = BLOCKS.register("station", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.STATION));
	public static final RegistryObject<Block> STATION_PORTABLE = BLOCKS.register("station_portable", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.STATION_PORTABLE));
	public static final RegistryObject<Block> STATION_PORTABLE_ENCHANTING = BLOCKS.register("station_portable_enchanting", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.STATION_PORTABLE_ENCHANTING));
	public static final RegistryObject<Block> STATION_PORTABLE_SMITHING = BLOCKS.register("station_portable_smithing", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.STATION_PORTABLE_SMITHING));
	public static final RegistryObject<Block> STATION_PROVISIONING = BLOCKS.register("station_provisioning", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.STATION_PROVISIONING));
//	public static final RegistryObject<Block> STREETLIGHT_1 = BLOCKS.register("streetlight_1", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.STREETLIGHT_1));
//	public static final RegistryObject<Block> STREETLIGHT_2 = BLOCKS.register("streetlight_2", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.STREETLIGHT_2));
//	public static final RegistryObject<Block> STREETLIGHT_3 = BLOCKS.register("streetlight_3", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.STREETLIGHT_3));
//	public static final RegistryObject<Block> STREETLIGHT_4 = BLOCKS.register("streetlight_4", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.STREETLIGHT_4));
//	public static final RegistryObject<Block> THREAD_BLACK = BLOCKS.register("thread_black", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.THREAD));
//	public static final RegistryObject<Block> THREAD_BLUE = BLOCKS.register("thread_blue", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.THREAD));
//	public static final RegistryObject<Block> THREAD_BROWN = BLOCKS.register("thread_brown", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.THREAD));
//	public static final RegistryObject<Block> THREAD_CYAN = BLOCKS.register("thread_cyan", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.THREAD));
//	public static final RegistryObject<Block> THREAD_GRAY = BLOCKS.register("thread_gray", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.THREAD));
//	public static final RegistryObject<Block> THREAD_GREEN = BLOCKS.register("thread_green", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.THREAD));
//	public static final RegistryObject<Block> THREAD_LIGHTBLUE = BLOCKS.register("thread_lightblue", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.THREAD));
//	public static final RegistryObject<Block> THREAD_LIGHTGRAY = BLOCKS.register("thread_lightgray", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.THREAD));
//	public static final RegistryObject<Block> THREAD_LIME = BLOCKS.register("thread_lime", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.THREAD));
//	public static final RegistryObject<Block> THREAD_MAGENTA = BLOCKS.register("thread_magenta", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.THREAD));
//	public static final RegistryObject<Block> THREAD_ORANGE = BLOCKS.register("thread_orange", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.THREAD));
//	public static final RegistryObject<Block> THREAD_PINK = BLOCKS.register("thread_pink", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.THREAD));
//	public static final RegistryObject<Block> THREAD_PURPLE = BLOCKS.register("thread_purple", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.THREAD));
//	public static final RegistryObject<Block> THREAD_RED = BLOCKS.register("thread_red", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.THREAD));
//	public static final RegistryObject<Block> THREAD_WHITE = BLOCKS.register("thread_white", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.THREAD));
//	public static final RegistryObject<Block> THREAD_YELLOW = BLOCKS.register("thread_yellow", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.THREAD));
//	public static final RegistryObject<Block> TONGS = BLOCKS.register("tongs", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.TONGS));
//	public static final RegistryObject<Block> TORCH = BLOCKS.register("torch", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.TORCH));
//	public static final RegistryObject<Block> TORCH_CLUSTER = BLOCKS.register("torch_cluster", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.TORCH_CLUSTER));
//	public static final RegistryObject<Block> TORCH_SKELETON = BLOCKS.register("torch_skeleton", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.TORCH_SKELETON));
	public static final RegistryObject<Block> TROUGH = BLOCKS.register("trough", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.TROUGH));
//	public static final RegistryObject<Block> TROUGH_WATER = BLOCKS.register("trough_water", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.TROUGH_WATER));
//	public static final RegistryObject<Block> TROUGH_WHEAT = BLOCKS.register("trough_wheat", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.TROUGH_WHEAT));
//	public static final RegistryObject<Block> UTENSIL_FORK = BLOCKS.register("utensil_fork", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.UTENSIL));
//	public static final RegistryObject<Block> UTENSIL_KNIFE = BLOCKS.register("utensil_knife", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.UTENSIL));
//	public static final RegistryObject<Block> UTENSIL_SPOON = BLOCKS.register("utensil_spoon", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.UTENSIL));
//	public static final RegistryObject<Block> WHEEL_SHIP_LARGE = BLOCKS.register("wheel_ship_large", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.WHEEL_SHIP_LARGE));
//	public static final RegistryObject<Block> WHEEL_SHIP_SMALL = BLOCKS.register("wheel_ship_small", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.WHEEL_SHIP_SMALL));
//	public static final RegistryObject<Block> WINCH = BLOCKS.register("winch", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.WINCH));

// Furniture
//	public static final RegistryObject<Block> BENCH = FURNITURE.register("bench", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BENCH));
//	public static final RegistryObject<Block> BOOKSHELF = FURNITURE.register("bookshelf", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BOOKSHELF));
//	public static final RegistryObject<Block> BOOKSHELF_ORNATE = FURNITURE.register("bookshelf_ornate", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.BOOKSHELF_ORNATE));
	public static final RegistryObject<Block> CHAIR = FURNITURE.register("chair", () -> new RotationalBlock(Block.Properties.create(Material.WOOD), AABB.CHAIR));
	public static final RegistryObject<Block> MIRROR = FURNITURE.register("mirror", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.MIRROR));
	public static final RegistryObject<Block> STOOL = FURNITURE.register("stool", () -> new RotationalBlock(Block.Properties.create(Material.WOOD), AABB.STOOL));
	public static final RegistryObject<Block> TABLE = FURNITURE.register("table", () -> new RotationalBlock(Block.Properties.create(Material.WOOD), AABB.TABLE));
	public static final RegistryObject<Block> TABLE_TEA = FURNITURE.register("table_tea", () -> new RotationalBlock(Block.Properties.create(Material.WOOD), AABB.TABLE_TEA));

// Creatures
//public static final RegistryObject<Block> CHICKEN = BLOCKS.register("chicken", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.CHICKEN));
//public static final RegistryObject<Block> CHICKEN_2 = BLOCKS.register("chicken_2", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.CHICKEN_2));
//public static final RegistryObject<Block> DEER_FEMALE = BLOCKS.register("deer_female", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.DEER_FEMALE));
//public static final RegistryObject<Block> DEER_MALE = BLOCKS.register("deer_male", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.DEER_MALE));
//public static final RegistryObject<Block> GHOST = BLOCKS.register("ghost", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.GHOST));
//public static final RegistryObject<Block> HORSE_BROWNPAINT = BLOCKS.register("horse_brownpaint", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.HORSE_BROWNPAINT));
//public static final RegistryObject<Block> HORSE_FROSTMARE = BLOCKS.register("horse_frostmare", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.HORSE_FROSTMARE));
//public static final RegistryObject<Block> HORSE_NIGHTMARE = BLOCKS.register("horse_nightmare", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.HORSE_NIGHTMARE));
//public static final RegistryObject<Block> HORSE_PALOMINO = BLOCKS.register("horse_palomino", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.HORSE_PALOMINO));
//public static final RegistryObject<Block> HORSE_SHADOWGHOST = BLOCKS.register("horse_shadowghost", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.HORSE_SHADOWGHOST));
//public static final RegistryObject<Block> HORSE_SORREL = BLOCKS.register("horse_sorrel", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.HORSE_SORREL));
//public static final RegistryObject<Block> HORSE_WHITE = BLOCKS.register("horse_white", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.HORSE_WHITE));
//public static final RegistryObject<Block> HORSE_WHITEMANE = BLOCKS.register("horse_whitemane", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.HORSE_WHITEMANE));
//public static final RegistryObject<Block> LION_CUB = BLOCKS.register("lion_cub", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.LION_CUB));
//public static final RegistryObject<Block> LION_FEMALE = BLOCKS.register("lion_female", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.LION_FEMALE));
//public static final RegistryObject<Block> LION_MALE = BLOCKS.register("lion_male", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.LION_MALE));
//public static final RegistryObject<Block> LION_MALE_BLACK = BLOCKS.register("lion_male_black", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.LION_MALE_BLACK));
//public static final RegistryObject<Block> LION_MALE_BLACKMANE = BLOCKS.register("lion_male_blackmane", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.LION_MALE_BLACKMANE));
//public static final RegistryObject<Block> LION_MALE_WHITE = BLOCKS.register("lion_male_white", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.LION_MALE_WHITE));
//public static final RegistryObject<Block> MONKEY = BLOCKS.register("monkey", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.MONKEY));
//public static final RegistryObject<Block> PARROT_GOLDEN_1 = BLOCKS.register("parrot_golden_1", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.PARROT_GOLDEN_1));
//public static final RegistryObject<Block> PARROT_GOLDEN_2 = BLOCKS.register("parrot_golden_2", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.PARROT_GOLDEN_2));
//public static final RegistryObject<Block> PARROT_MACAW_1 = BLOCKS.register("parrot_macaw_1", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.PARROT_MACAW_1));
//public static final RegistryObject<Block> PARROT_MACAW_2 = BLOCKS.register("parrot_macaw_2", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.PARROT_MACAW_2));
//public static final RegistryObject<Block> SPRITE_OAK_1 = BLOCKS.register("sprite_oak_1", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.SPRITE_OAK_1));
//public static final RegistryObject<Block> SPRITE_OAK_2 = BLOCKS.register("sprite_oak_2", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.SPRITE_OAK_2));
//public static final RegistryObject<Block> SPRITE_OAK_NEUTRAL = BLOCKS.register("sprite_oak_neutral", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.SPRITE_OAK_NEUTRAL));
//public static final RegistryObject<Block> WOLF_GREY_1 = BLOCKS.register("wolf_grey_1", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.WOLF_GREY_1));
//public static final RegistryObject<Block> WYVERN_RED = BLOCKS.register("wyvern_red", () -> new OrthoBlock(Block.Properties.create(Material.WOOD), AABB.WYVERN_RED));

	// end generated

}
