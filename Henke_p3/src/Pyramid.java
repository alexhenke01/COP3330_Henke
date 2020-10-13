public class Pyramid extends Shape3D {
    private double base;
    private double height;

    public Pyramid(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public String getName(){
        return "pyramid";
    }

    @Override
    public double getArea(){
        return base*base + (2*base*(Math.sqrt(base*base/4 + height*height)));
    }

    @Override
    public double getVolume() {
        return base*base*height/3;
    }
}