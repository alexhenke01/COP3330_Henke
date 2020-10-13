public class Pyramid extends Shape3D {
    private double length;
    private double width;
    private double height;

    public Pyramid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public String getName(){
        return "pyramid";
    }

    @Override
    public double getArea(){
        return length*width + length*(Math.sqrt(width*width/4 + height*height)) +
                width*(Math.sqrt(length*length/4 + height*height));
    }

    @Override
    public double getVolume() {
        return length*width*height/3;
    }
}
