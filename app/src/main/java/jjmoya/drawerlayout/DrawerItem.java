package jjmoya.drawerlayout;

/**
 * clase para crear objetos de elementos del menu lateral
 */

public class DrawerItem {



    //variables de menu personalizado
    private String name;
    private int iconId;

    //constructor
    public DrawerItem(String name, int iconId) {
        this.name = name;
        this.iconId = iconId;
    }

    //metodo get and set

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }
}
