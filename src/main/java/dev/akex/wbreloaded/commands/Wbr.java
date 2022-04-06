package dev.akex.wbreloaded.commands;

import dev.akex.wbreloaded.Wbreloaded;
import dev.akex.wbreloaded.utils.Color;
import dev.akex.wbreloaded.utils.Data;
import dev.akex.wbreloaded.utils.Permission;
import dev.akex.wbreloaded.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Wbr implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            System.out.println(Prefix.prefix() + Color.translate("&cPor favor, usa este comando dentro del juego."));
            return true;

        }

        Player player = ((Player) sender).getPlayer();
        World world = player.getWorld();
        WorldBorder worldBorder = world.getWorldBorder();


        if (args.length == 0) {
            player.sendMessage(Color.translate("&e----------&6[ &eWBReloaded &6]&e----------"));
            player.sendMessage(Color.translate("&6/wbr &ehelp command"));
            player.sendMessage(Color.translate("&6/wbr &eversion"));
            player.sendMessage(Color.translate("&6/wbr &ecenter x z"));
            player.sendMessage(Color.translate("&6/wbr &edamage int"));
            player.sendMessage(Color.translate("&6/wbr &esize int (seconds)"));
            player.sendMessage(Color.translate("&6/wbr &ebuffer int"));
            player.sendMessage(Color.translate("&6/wbr &ereset"));
            player.sendMessage(Color.translate("&6/wbr &einside player"));
            player.sendMessage(Color.translate("&6/wbr &edistance int"));
            player.sendMessage(" ");
            return true;

        }
        if (args.length >= 1) {
            if (args[0].equals("version")) {
                if (Data.lang().equals("ES")) {
                    player.sendMessage(Color.translate("&e----------&6[ &eWBReloaded &6]&e----------"));
                    player.sendMessage(Color.translate("&eVersión: &61.2"));
                    player.sendMessage(Color.translate("&eHecho por: &6Akex06#9139"));
                    player.sendMessage(Color.translate("&eDiscord: &6https://discord.aquaticmc.ml"));
                    player.sendMessage(" ");
                    return true;
                }
                if (Data.lang().equals("EN")) {
                    player.sendMessage(Color.translate("&e----------&6[ &eWBReloaded &6]&e----------"));
                    player.sendMessage(Color.translate("&eVersion: &61.2"));
                    player.sendMessage(Color.translate("&eMade by: &6Akex06#9139"));
                    player.sendMessage(Color.translate("&eDiscord: &6https://discord.aquaticmc.ml/"));
                    player.sendMessage(" ");
                    return true;
                }

            }

            if (args[0].equals("center")) {
                if (!(player.hasPermission("wbr.center"))) {
                    player.sendMessage(Permission.perms());
                    return true;
                };
                if (args.length == 1) {
                    Location center = worldBorder.getCenter();
                    if (Data.lang().equals("ES")) {
                        player.sendMessage(Prefix.prefix() + Color.translate("&eEl centro del borde es: &6"
                                + center.getX() + "&e, &6"
                                + center.getY()));
                    }
                    if (Data.lang().equals("EN")) {
                        player.sendMessage(Prefix.prefix() + Color.translate("&eThe World Border is at: &6"
                                + center.getX() + "&e, &6"
                                + center.getY()));
                    }
                    player.sendMessage(" ");
                    return true;
                }

                if (args.length >= 3) {
                    if (Data.isInt(args[1]) && Data.isInt(args[2])) {
                        double x = Data.toInt(args[1]);
                        double z = Data.toInt(args[2]);
                        worldBorder.setCenter(x, z);
                        Location center = worldBorder.getCenter();
                        if (Data.lang().equals("ES")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eEl centro del borde es: &6"
                                    + center.getX() + "&e, &6"
                                    + center.getY()));
                        }
                        if (Data.lang().equals("EN")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eThe World Border is at: &6"
                                    + center.getX() + "&e, &6"
                                    + center.getY()));
                        }
                        player.sendMessage(" ");
                        return true;
                    }
                }
            }

            if (args[0].equals("damage")) {
                if (!(player.hasPermission("wbr.damage"))) {
                    player.sendMessage(Permission.perms());
                    return true;
                };
                if (args.length == 1) {
                    if (Data.lang().equals("ES")) {
                        player.sendMessage(Prefix.prefix() + Color.translate("&eEl daño fuera del borde es de: &6" + worldBorder.getDamageAmount()));
                    }
                    if (Data.lang().equals("EN")) {
                        player.sendMessage(Prefix.prefix() + Color.translate("&eThe amount of damage dealed outside world border is: &6" + worldBorder.getDamageAmount()));
                    }
                    player.sendMessage(" ");
                    return true;
                }
                if (args.length >= 2) {
                    if (Data.isInt(args[1])) {
                        double damage = Data.toInt(args[1]);
                        worldBorder.setDamageAmount(damage);
                        if (Data.lang().equals("ES")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eEl daño fuera del borde es de: &6" + worldBorder.getDamageAmount()));
                        }
                        if (Data.lang().equals("EN")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eThe amount of damage dealed outside world border is of: &6" + worldBorder.getDamageAmount()));
                        }
                        player.sendMessage(" ");
                        return true;
                    }
                }
            }

            if (args[0].equals("size")) {
                if (!(player.hasPermission("wbr.size"))) {
                    player.sendMessage(Permission.perms());
                    return true;
                };
                if (args.length == 1) {
                    if (Data.lang().equals("ES")) {
                        player.sendMessage(Prefix.prefix() + Color.translate("&eEl tamaño del borde es de: &6" + worldBorder.getSize()));
                    }
                    if (Data.lang().equals("EN")) {
                        player.sendMessage(Prefix.prefix() + Color.translate("&eThe border's world is of: &6" + worldBorder.getSize()));
                    }
                    player.sendMessage(" ");
                    return true;
                }
                if (args.length >= 2) {
                    if (Data.isInt(args[1])) {
                        double size = Data.toInt(args[1]);
                        long seconds = 0L;
                        if (args.length >= 3) {
                            if (Data.isLong(args[2])) {
                                seconds = Data.toLong(args[2]);
                            }
                        }
                        worldBorder.setSize(size, seconds);
                        if (Data.lang().equals("ES")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eEl tamaño del borde es de: &6" + worldBorder.getSize()));
                        }
                        if (Data.lang().equals("EN")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eThe border's world is of: &6" + worldBorder.getSize()));
                        }
                        player.sendMessage(" ");
                        return true;
                    }
                }
            }

            if (args[0].equals("buffer")) {
                if (!(player.hasPermission("wbr.buffer"))) {
                    player.sendMessage(Permission.perms());
                    return true;
                };
                if (args.length == 1) {
                    if (Data.lang().equals("ES")) {
                        player.sendMessage(Prefix.prefix() + Color.translate("&eEl buffer del borde es de: &6" + worldBorder.getDamageBuffer()));
                    }
                    if (Data.lang().equals("EN")) {
                        player.sendMessage(Prefix.prefix() + Color.translate("&eThe border's buffer is of: &6" + worldBorder.getDamageBuffer()));
                    }
                    player.sendMessage(" ");
                    return true;
                }

                if (args.length >= 2) {
                    if (Data.isInt(args[1])) {
                        double buffer = Data.toInt(args[1]);
                        worldBorder.setDamageBuffer(buffer);
                        if (Data.lang().equals("ES")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eEl buffer del borde es de: &6" + worldBorder.getDamageBuffer()));
                        }
                        if (Data.lang().equals("EN")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eThe border's buffer is of: &6" + worldBorder.getDamageBuffer()));
                        }
                        player.sendMessage(" ");
                        return true;
                    }
                }
            }

            if (args[0].equals("reset")) {
                if (!(player.hasPermission("wbr.reset"))) {
                    player.sendMessage(Permission.perms());
                    return true;
                };
                if (args.length >= 2 && args[1].equals("confirm")) {
                    worldBorder.reset();
                    if (Data.lang().equals("ES")) {
                        player.sendMessage(Prefix.prefix() + Color.translate("&eEl borde se ha restablecido"));
                    }
                    if (Data.lang().equals("EN")) {
                        player.sendMessage(Prefix.prefix() + Color.translate("&eThe border has been reseted"));
                    }

                    player.sendMessage(" ");
                    return true;
                }

                if (Data.lang().equals("ES")) {
                    player.sendMessage(Prefix.prefix() + Color.translate("&eUsa /wbr reset confirm para restablecer el borde"));
                }
                if (Data.lang().equals("EN")) {
                    player.sendMessage(Prefix.prefix() + Color.translate("&eUse /wbr reset confirm to reset the world border"));
                }
                player.sendMessage(" ");
                return true;
            }

            if (args[0].equals("inside")) {
                if (!(player.hasPermission("wbr.inside"))) {
                    player.sendMessage(Permission.perms());
                    return true;
                };
                if (args.length == 1) {
                    if (Data.lang().equals("ES")) {
                        player.sendMessage(Prefix.prefix() + Color.translate("&cUso correcto: /wbr inside player"));
                    }
                    if (Data.lang().equals("EN")) {
                        player.sendMessage(Prefix.prefix() + Color.translate("&cUse: /wbr inside player"));
                    }

                    player.sendMessage(" ");
                    return true;
                }

                if (args.length >= 2) {
                    Location insider = Bukkit.getPlayer(args[1]).getLocation();
                    boolean inside = worldBorder.isInside(insider);
                    if (inside == true) {
                        if (Data.lang().equals("ES")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eEl jugador &6" + args[1] + "&e está dentro del borde"));
                        }
                        if (Data.lang().equals("EN")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eThe player &6" + args[1] + "&e is inside the border"));
                        }

                        player.sendMessage(" ");
                        return true;
                    } else {
                        if (Data.lang().equals("ES")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eEl jugador &6" + args[1] + "&e está fuera del borde"));
                        }
                        if (Data.lang().equals("EN")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eThe player &6" + args[1] + "&e is outside the border"));
                        }

                        player.sendMessage(" ");
                        return true;
                    }
                }
            }

            if (args[0].equals("distance")) {
                if (!(player.hasPermission("wbr.distance"))) {
                    player.sendMessage(Permission.perms());
                    return true;
                };
                if (args.length == 1) {
                    if (Data.lang().equals("ES")) {
                        player.sendMessage(Prefix.prefix() + Color.translate("&eDistancia de advertencia desde el borde: &6" + worldBorder.getWarningDistance()));
                    }
                    if (Data.lang().equals("EN")) {
                        player.sendMessage(Prefix.prefix() + Color.translate("&eWarning distance from the border: &6" + worldBorder.getWarningDistance()));
                    }

                    player.sendMessage(" ");
                    return true;
                }

                if (args.length >= 2) {
                    if (Data.isInt(args[1])) {
                        int damage = Data.toInt(args[1]);
                        worldBorder.setWarningDistance(damage);
                        if (Data.lang().equals("ES")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eDistancia de advertencia desde el borde: &6" + worldBorder.getWarningDistance()));
                        }
                        if (Data.lang().equals("EN")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eThe warning distance is now of: &6" + worldBorder.getWarningDistance()));
                        }

                        player.sendMessage(" ");
                        return true;
                    }
                }
            }


            if (args[0].equals("help")) {
                if (!(player.hasPermission("wbr.help"))) {
                    player.sendMessage(Permission.perms());
                    return true;
                };
                if (args.length >= 2) {
                    if (Data.lang().equals("ES")) {
                        if (args[1].equals("version")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eMira información sobre el plugin <3 &6| &e/wbr version"));
                            return true;
                        }
                        if (args[1].equals("center")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eEstablece el centro del borde &6| &e/wbr center x z"));
                            return true;
                        }
                        if (args[1].equals("damage")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eEstablece la cantidad de daño infligido al jugador fuera del borde " +
                                    "&6| &e/wbr damage int"));
                            return true;
                        }
                        if (args[1].equals("size")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eEstablece el tamaño del borde &6| &e/wbr size int"));
                        }
                        if (args[1].equals("buffer")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eMultiplica el daño de /wbr damage &6| &e/wbr buffer int"));
                            return true;
                        }
                        if (args[1].equals("reset")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eRestablece los valores del borde &6| &e/wbr reset"));
                            return true;
                        }
                        if (args[1].equals("inside")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eComprueba si un jugador está dentro del borde &6| &e/wbr inside player"));
                            return true;
                        }
                        if (args[1].equals("distance")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eEstablece la distancia a la cual se poner el efecto rojo &6| &e/wbr distance int"));
                        }
                    }

                    if (Data.lang().equals("EN")) {
                        if (args[1].equals("version")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eCheck the plugin information <3 &6| &e/wbr version"));
                            return true;
                        }
                        if (args[1].equals("center")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eSets the center of the border &6| &e/wbr center x z"));
                            return true;
                        }
                        if (args[1].equals("damage")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eSets the amount of damage dealed to the player outside the border ") +
                                    "&6| &e/wbr damage int");
                            return true;
                        }
                        if (args[1].equals("size")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eSets the border's size &6| &e/wbr size int"));
                        }
                        if (args[1].equals("buffer")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eMultiplies the /wbr damage damage &6| &e/wbr buffer int"));
                            return true;
                        }
                        if (args[1].equals("reset")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eResets the border's values &6| &e/wbr reset"));
                            return true;
                        }
                        if (args[1].equals("inside")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eChecks if a player is inside the border &6| &e/wbr inside player"));
                            return true;
                        }
                        if (args[1].equals("distance")) {
                            player.sendMessage(Prefix.prefix() + Color.translate("&eSets the warning distance &6| &e/wbr distance int"));
                        }
                    }

                } else {
                    if (Data.lang().equals("ES")) {
                        player.sendMessage(Prefix.prefix() + Color.translate("&eUsa &6/wbr help comando&e para una breve ayuda de dicho comando"));
                    }
                    if (Data.lang().equals("EN")) {
                        player.sendMessage(Prefix.prefix() + Color.translate("&eUse &6/wbr help command&e for a brief help about that command"));
                    }
                    return true;
                }
            }
        }
        return true;
    }
}
