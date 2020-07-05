package com.thefabulouscube.paragonia.util;

import net.minecraft.util.IStringSerializable;

public enum Diagonals implements IStringSerializable {
	NNN(0, "north"),
	NE (1, "northeast"),
	EEE(2, "east"),
	SE (3, "southeast"),
	SSS(4, "south"),
	SW (5, "southwest"),
	WWW(6, "west"),
	NW (7, "northwest");
    private int index;
	private int opposite;
	private String name;

	private Diagonals(int index, String direction) {
    	this.index = index;
    	this.opposite = (index >= 4) ? index-4 : index + 4;
    	this.name = direction;
    }

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

    public int getOpposite() {
        return this.opposite;
    }
}
