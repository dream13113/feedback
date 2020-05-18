package kode.koder.partyplugin.main.plugin;

import kode.koder.partyplugin.command.PartyCmd;
import kode.koder.partyplugin.main.PlayerData;
import org.bukkit.plugin.java.JavaPlugin;

import kode.koder.partyplugin.event.PlayerEvents;

import java.io.*;
import java.util.HashMap;
import java.util.UUID;

//this plugin is write by developer koder
public class Main extends JavaPlugin{
    //해쉬맵 생성
    public static HashMap<UUID, PlayerData> playerData;
    public static HashMap<String, UUID> playerList;

    //데이터 가져오기
    @Override
    @SuppressWarnings("unchecked")
    public void onEnable(){
        File dir = getDataFolder();

        if(!dir.exists()){
            if(!dir.mkdir())
                System.out.println("cannot make dir for plugin" + getDescription().getName());
        }
        playerData = (HashMap<UUID, PlayerData>) load(new File(getDataFolder(), "playerData.dat"));
        playerList = (HashMap<String, UUID>) load(new File(getDataFolder(), "playerList.dat"));


        //초기값
        if(playerData == null){
            playerData = new HashMap<UUID, PlayerData>();
        }
        if(playerList == null){
            playerList = new HashMap<String, UUID>();
        }
        new PartyCmd(this);
        new PlayerEvents(this);
    }
    //세이브 (아웃시)


    @Override
    public void onDisable() {
        save(playerData, new File(getDataFolder(), "playerData.dat"));
        save(playerList, new File(getDataFolder(), "playerList.dat"));
    }

    //저장
    public void save(Object o, File f){
        try{
            if(!f.exists()) {
                f.createNewFile();
            }
            ObjectOutputStream ood = new ObjectOutputStream(new FileOutputStream(f));
            ood.writeObject(o);
            ood.flush();
            ood.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //로딩
    public Object load(File f){

        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(f));
            Object result = ois.readObject();
            ois.close();
            return result;
        }catch (Exception e){
            return null;
        }
    }

}
