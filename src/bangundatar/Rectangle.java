package bangundatar;

public class Rectangle implements TwoDimensional {
    protected double lenght, width;

    public Rectangle(double lenght, double width) {
        this.lenght = lenght;
        this.width = width;
    }

    @Override
    public double getArea() {
        return lenght * width;
    }

    @Override
    public double getCircumference() {
        return (width + lenght) * 2;
    }
}
