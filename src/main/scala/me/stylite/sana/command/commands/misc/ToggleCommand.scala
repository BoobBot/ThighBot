package me.stylite.sana.command.commands.misc

import java.awt.Color

import me.stylite.sana.Sana
import me.stylite.sana.command.{BotCommand, CommandContext}
import me.stylite.sana.util.Embed
import me.stylite.sana.util.ThighApi
import net.dv8tion.jda.core.Permission
import net.dv8tion.jda.core.utils.PermissionUtil
import net.dv8tion.jda.core.managers.ChannelManager

object ToggleCommand extends BotCommand {

  override val name: String = "toggle"
  override val aliases: Set[String] = Set.empty[String]
  override val desc: String = "Posts a sexy thigh.  "

  //TODO: Add more to this
  override def execute(context: CommandContext): Unit = {
    val cm = new ChannelManager(context.message.getTextChannel)
    if (PermissionUtil.checkPermission(context.message.getTextChannel(), context.message.getMember(), Permission.MANAGE_CHANNEL)) {
      if (!context.isNsfw) {
        cm.setNSFW(true).queue()
        val embed = new Embed(Color.pink, description = "Toggled channel to NSFW.")
        embed.send(context.eevent.getTextChannel)
      } else {
        cm.setNSFW(false).queue()
        val embed = new Embed(Color.pink, description = "Toggled channel to SFW.")
        embed.send(context.eevent.getTextChannel)
      }
    }
  }
}
