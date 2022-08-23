package pers.zhangyang.easyauthorization.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import pers.zhangyang.easyauthorization.domain.Gamer;
import pers.zhangyang.easyauthorization.manager.GamerManager;
import pers.zhangyang.easyauthorization.yaml.MessageYaml;
import pers.zhangyang.easylibrary.annotation.EventListener;
import pers.zhangyang.easylibrary.util.MessageUtil;

import java.util.List;

@EventListener
public class EntityDropItem implements Listener {

    @EventHandler
    public void on(EntityDropItemEvent event){
        if (!(event.getEntity() instanceof Player)){
            return;
        }
        Player player= (Player) event.getEntity();
        Gamer gamer= GamerManager.INSTANCE.getGamer(player);
        if (gamer.isLogin()){
            return;
        }
        event.setCancelled(true);
    }
}