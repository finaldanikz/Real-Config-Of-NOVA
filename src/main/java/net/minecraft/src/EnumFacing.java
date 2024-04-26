package net.minecraft.src;

public enum EnumFacing {
	DOWN(0, 1, 0, -1, 0), UP(1, 0, 0, 1, 0), NORTH(2, 3, 0, 0, -1), SOUTH(3, 2, 0, 0, 1), EAST(4, 5, -1, 0, 0), WEST(5, 4, 1, 0, 0);

	/** Face order for D-U-N-S-E-W. */
	private final int order_a;

	/** Face order for U-D-S-N-W-E. */
	private final int order_b;
	private final int frontOffsetX;
	private final int frontOffsetY;
	private final int frontOffsetZ;

	/** List of all values in EnumFacing. Order is D-U-N-S-E-W. */
	private static final EnumFacing[] faceList = new EnumFacing[6];

	private EnumFacing(int par3, int par4, int par5, int par6, int par7) {
		this.order_a = par3;
		this.order_b = par4;
		this.frontOffsetX = par5;
		this.frontOffsetY = par6;
		this.frontOffsetZ = par7;
	}

	/**
	 * Returns a offset that addresses the block in front of this facing.
	 */
	public int getFrontOffsetX() {
		return this.frontOffsetX;
	}

	public int getFrontOffsetY() {
		return this.frontOffsetY;
	}

	/**
	 * Returns a offset that addresses the block in front of this facing.
	 */
	public int getFrontOffsetZ() {
		return this.frontOffsetZ;
	}

	/**
	 * Returns the facing that represents the block in front of it.
	 */
	public static EnumFacing getFront(int par0) {
		return faceList[par0 % faceList.length];
	}
	
	public static EnumFacing getFacingFromVector(float p_176737_0_, float p_176737_1_, float p_176737_2_)
    {
        EnumFacing enumfacing = NORTH;
        float f = Float.MIN_VALUE;

        for (EnumFacing enumfacing1 : values())
        {
            float f1 = p_176737_0_ * (float)enumfacing1.getFrontOffsetX() + p_176737_1_ * (float)enumfacing1.getFrontOffsetY() + p_176737_2_ * (float)enumfacing1.getFrontOffsetZ();

            if (f1 > f)
            {
                f = f1;
                enumfacing = enumfacing1;
            }
        }

        return enumfacing;
    }

	static {
		EnumFacing[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			EnumFacing var3 = var0[var2];
			faceList[var3.order_a] = var3;
		}
	}
}
