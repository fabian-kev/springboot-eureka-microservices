package com.fbiankevin.player.playerservice.model.resource;

import com.fbiankevin.player.playerservice.model.Account;
import com.fbiankevin.player.playerservice.model.Player;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerResource {
    private Player player;
    private Account account;
}
