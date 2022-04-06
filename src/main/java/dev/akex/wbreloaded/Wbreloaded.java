package dev.akex.wbreloaded;

import dev.akex.wbreloaded.commands.Wbr;
import dev.akex.wbreloaded.utils.Color;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Wbreloaded extends JavaPlugin {

    public static Wbreloaded instance;

    public static Wbreloaded getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        System.out.println("--------------------------------------");
        System.out.println(Color.translate("&aGracias por usar World Border Reloaded"));
        System.out.println(Color.translate("&eSi necesitas ayuda únete a nuestro Discord"));
        System.out.println(Color.translate("&ehttps://discord.com/invite/easymh/"));
        System.out.println(Color.translate("&fHecho por: &cAkex06#9139"));
        System.out.println("--------------------------------------");

        loadCommands();
    }

    @Override
    public void onDisable() {
        System.out.println(Color.translate("&cAdiós :c"));
    }

    public void loadCommands() {
        this.getCommand("wbr").setExecutor(new Wbr());
    }
}
