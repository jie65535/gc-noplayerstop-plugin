/*
 * gc-noplayerstop
 * Copyright (C) 2023  jie65535
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.github.jie65535.noplayerstop.commands;

import com.github.jie65535.noplayerstop.NoPlayerStopPlugin;
import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.command.commands.StopCommand;
import emu.grasscutter.game.player.Player;

import java.util.List;

@Command(label = "stop", aliases = {"shutdown"}, permission = "server.stop", targetRequirement = Command.TargetRequirement.NONE)
public final class ConsoleStopCommand implements CommandHandler {
    private final NoPlayerStopPlugin plugin;
    private final StopCommand RawStopCommand = new StopCommand();

    public ConsoleStopCommand(NoPlayerStopPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        if (sender != null) {
            plugin.getLogger().warn(
                    String.format("Player %s(%d) tries to stop the server",
                            sender.getNickname(), sender.getUid()));
        } else {
            RawStopCommand.execute(null, null, args);
        }
    }
}
