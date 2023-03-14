package bangunruang;

import bangundatar.Rectangle;

public class Cuboid extends Rectangle implements ThreeDimensional {
    private double height;

    public Cuboid(double lenght, double width, double height) {
        super(lenght, width);
        this.height = height;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * (lenght * width + lenght * height + width * height);
    }

    @Override
    public double getVolume() {
        return lenght * width * height;
    }

}
