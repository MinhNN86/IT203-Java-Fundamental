package Session10.lyThuyet;

public class Car implements IColorable{


    @Override
    public void showColor(String color) {
        System.out.println(color);
    }

    @Override
    public String getColorHexCode(String color) {
        return "HEX=" + color.hashCode();
    }
}
