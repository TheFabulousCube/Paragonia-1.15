package com.thefabulouscube.paragonia.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;

public enum Level implements IStringSerializable
{
	DOWN ( 0, "down"),
	EVEN ( 1, "even"),
	UP   ( 2, "up");
	
    private final int index;
    private final String name;
    
    private Level(int index, String level) {
    	this.index = index;
    	this.name = level;
    }

    public int getIndex()
    {
        return this.index;
    }

    @Override
    public String getName()
    {
        return this.name;
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }
    
    public static Level getLevel(PlayerEntity placer, BlockPos pos) {
		Level level = Level.EVEN;

        int playerHeight = (int)placer.getPosition().getY();
        int blockHeight = pos.getY();

        if (playerHeight - blockHeight > 0) {
        	level = Level.DOWN;
        } else if (playerHeight - blockHeight < 0) {
        	level = Level.UP;
        }
        return level;
    }
    
	public double[][] toLevel(double[][] boxes) {
		double[][] working = boxes.clone();
		switch (this.name) {
		case "down":
			for (int i = 0; i < working.length; i++) {
				// x1, y1, z1, x2, y2, z2
				working[i] = new double[] { working[i][0], 16 - working[i][2], working[i][1], working[i][3], 16 - working[i][5], working[i][4] };
			}
			break;
		case "up":
			for (int i = 0; i < working.length; i++) {
				working[i] = new double[] { working[i][0], working[i][2], 16 - working[i][1], working[i][3], working[i][5], 16 - working[i][4] };
			}
			break;
		case "even":
		default:
			break;

		}
		return working;
	}
    
//    public static AABB toDown(AABB boxes)
//    {
//    	double[][] working = boxes.getBoundingBoxes();
//		for (int i = 0; i < working.length; i++)
//		{
//			working[i] = new double[] {working[i][0], working[i][1], working[i][2], working[i][3], working[i][4], working[i][5]};
//		}
//		boxes.setBoundingBoxes(working);
//		return boxes;    	
//    }
	
}
