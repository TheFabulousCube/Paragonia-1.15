package com.thefabulouscube.paragonia.util;

import com.thefabulouscube.paragonia.Paragonia;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
/**
 * Directions for BlockRotational class
 * 
 * @author Cube
 *
 */
// TODO order directions to filter for cardinal 4, diagonals, all 16
public enum AllFacing implements IStringSerializable
{
	WWW(0, "west"),
	WNW(1, "wnw"),
	NW (2, "northwest"),
	NNW(3, "nnw"),
	NNN(4, "north"),
	NNE(5, "nne"),
	NE (6, "northeast"),
	ENE(7, "ene"),
	EEE(8, "east"),
	ESE(9, "ese"),
	SE (10, "southeast"),
	SSE(11, "sse"),
	SSS(12, "south"),   
	SSW(13, "ssw"),     
	SW (14, "southwest"),
	WSW(15, "wsw");

    /** Ordering index for D-U-N-S-W-E */
    private final int index;
    /** Index of the opposite Facing in the VALUES array */
    private final int opposite;
    private final String name;
    
    //private static final Map<String, AllFacing> NAME_LOOKUP = Maps.<String, AllFacing>newHashMap();


    private AllFacing(int index, String direction) {
    	this.index = index;
    	this.opposite = (index >= 8) ? index-8 : index + 8;
    	this.name = direction;
    }

    /**
     * Get the Index of this Facing (0-16). The order is clockwise from SOUTH
     */
    public int getIndex() {
        return this.index;
    }

    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Get the opposite Facing (e.g. DOWN => UP)
     */
    public int getOpposite() {
        return this.opposite;
    }

    public  AllFacing byMeta(int meta)
    {
    	return AllFacing.values()[meta];
    }

    public float getHorizontalAngle()
    {
        return (float)(this.index * 22.5);
    }

	public double[][] toFacing(double[][] boxes) {
		double[][] working = boxes.clone();
		switch (this.getName()) {
		case "northwest":
		case "nnw":
		case "nne":
		case "north":
			for (int i = 0; i < working.length; i++) {
				working[i] = new double[] { working[i][0], working[i][1], working[i][2], working[i][3], working[i][4], working[i][5] };
//				working[i] = new double[] { 16 - working[i][0], working[i][1], 16 - working[i][2], 16 - working[i][3], working[i][4], 16 - working[i][5] };
			}
			break;
		case "northeast":
		case "ene":
		case "ese":
		case "east":
			for (int i = 0; i < working.length; i++) {
				working[i] = new double[] { 16 - working[i][2], working[i][1], working[i][0], 16 - working[i][5], working[i][4], working[i][3] };
//				working[i] = new double[] { working[i][2], working[i][1], 16 - working[i][0], working[i][5], working[i][4], 16 - working[i][3] };
			}
			break;
		case "southeast":
		case "sse":
		case "ssw":
		case "south":
			for (int i = 0; i < working.length; i++) {
				working[i] = new double[] { 16 - working[i][0], working[i][1], 16 - working[i][2], 16 - working[i][3], working[i][4], 16 - working[i][5] };
//				working[i] = new double[] { working[i][0], working[i][1], working[i][2], working[i][3], working[i][4], working[i][5] };
			}
			break;
		case "southwest":
		case "wsw":
		case "wnw":
		case "west":
			for (int i = 0; i < working.length; i++) {
				working[i] = new double[] { working[i][2], working[i][1], 16 - working[i][0], working[i][5], working[i][4], 16 - working[i][3] };
//				working[i] = new double[] { 16 - working[i][2], working[i][1], working[i][0], 16 - working[i][5], working[i][4], working[i][3] };
			}
			break;
			default:
				for (int i = 0; i < working.length; i++) {
						working[i] = new double[] { working[i][0], working[i][1], working[i][2], working[i][3], working[i][4], working[i][5] };
				}
		}
		return working;

	}

	public static AllFacing getFacing(PlayerEntity player, BlockPos block, int numDirs) {
		/**
		 * calculate angle from points (vectors)
		 */
		int modifier = 16/numDirs;
		double deltaX = (Math.floor(player.getPosX()) - block.getX());
		double deltaZ = (Math.floor(player.getPosZ()) - block.getZ());
		double inRadians = Math.atan2(deltaZ, deltaX);
		double inDegrees = Math.toDegrees(inRadians) + 180; // offset for negative values will need to be adjusted for others
		int meta = (int) (Math.round(inDegrees / (360/numDirs)));
		Paragonia.LOGGER.info("Placing " + numDirs + ": deltaX: " + deltaX + " deltaZ:" + deltaZ);
//		Paragonia.LOGGER.info("from: PlayerX: " + Math.floor(player.getPosX()) + " PlayerZ: " + Math.floor(player.getPosZ()) + " blockX: " + block.getX() + " blockZ: " + block.getZ());
		
		Paragonia.LOGGER.info("Placing " + numDirs + ":  inDegrees = " + inDegrees);
		Paragonia.LOGGER.info("Placing " + numDirs + ":  raw degrees = " + Math.toDegrees(inRadians));
		Paragonia.LOGGER.info("Placing " + numDirs + ": raw meta = " + meta);
		Paragonia.LOGGER.info("Placing " + numDirs + ": adjusted meta = " + (meta % numDirs));
		Paragonia.LOGGER.info("Placing " + numDirs + ": test meta = " + (meta) * modifier);
		Paragonia.LOGGER.info("Placing " + numDirs + ": test2 meta = " + (meta % numDirs) * modifier);
//		return AllFacing.values()[Math.abs(meta)];
		return AllFacing.values()[(meta % numDirs) * modifier];

	}
}
