package rebelmythik.rebelsTPA.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {


    public void playerJoin(PlayerJoinEvent event) {
        String player = String.valueOf(event.getPlayer().getUniqueId());




    }
}
