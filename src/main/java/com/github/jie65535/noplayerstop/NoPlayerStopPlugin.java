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
package com.github.jie65535.noplayerstop;

import com.github.jie65535.noplayerstop.commands.ConsoleStopCommand;

import emu.grasscutter.command.CommandMap;
import emu.grasscutter.plugin.Plugin;

public final class NoPlayerStopPlugin extends Plugin {
    @Override
    public void onEnable() {
        // Register commands.
        CommandMap.getInstance().unregisterCommand("stop");
        getHandle().registerCommand(new ConsoleStopCommand(this));

        // Log a plugin status message.
        getLogger().info("[NoPlayerStop] Enabled, see https://github.com/jie65535/gc-noplayerstop-plugin");
    }

    @Override
    public void onDisable() {
        getLogger().info("[NoPlayerStop] Disabled.");
    }
}
