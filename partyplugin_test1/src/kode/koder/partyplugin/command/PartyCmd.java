package kode.koder.partyplugin.command;

import kode.koder.partyplugin.main.PlayerData;
import kode.koder.partyplugin.main.plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PartyCmd implements CommandExecutor {
    private Main plugin;

    public PartyCmd(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("party").setExecutor(this);

    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage( ChatColor.RED  + "이 명령어는 플레이어만 실행 가능합니다.");
            return true;
        }
        try{
            Player p = (Player) sender;

        }catch (Exception e){
            sender.sendMessage( ChatColor.RED + "에러가 발생했습니다. 운영자에게 문의 부탁드립니다.");
            return true;
        }


        if(args[0].equalsIgnoreCase("invite")){
            if (args.length != 2){
                sender.sendMessage(ChatColor.RED + "명령어를 잘못 사용했습니다. 올바른 사용:" + cmd.getUsage());
                return true;
            }





        }
        else if(args[0].equalsIgnoreCase("out")){

        }

        return false;
    }
}
