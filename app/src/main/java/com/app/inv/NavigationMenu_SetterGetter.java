package com.app.inv;

public class NavigationMenu_SetterGetter {
    private int menu_icon;
    private String menu_option;

    public NavigationMenu_SetterGetter(int menu_icon, String menu_option) {
        this.menu_icon = menu_icon;
        this.menu_option = menu_option;
    }

    public int getMenu_icon() {
        return menu_icon;
    }

    public void setMenu_icon(int menu_icon) {
        this.menu_icon = menu_icon;
    }

    public String getMenu_option() {
        return menu_option;
    }

    public void setMenu_option(String menu_option) {
        this.menu_option = menu_option;
    }
}
