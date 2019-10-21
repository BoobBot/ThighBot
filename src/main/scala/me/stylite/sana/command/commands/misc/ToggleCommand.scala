package me.stylite.sana.command.commands.misc

import java.awt.Color
import me.stylite.sana.command.{BotCommand, CommandContext}
import me.stylite.sana.util.Embed
import net.dv8tion.jda.api.Permission

object ToggleCommand extends BotCommand {

  override val name: String = "toggle"
  override val aliases: Set[String] = Set.empty[String]
  override val desc: String = "Toggles a channel NSFW or not"
  override val category: String = "NSFW"

  //TODO: Add more to this
  override def execute(context: CommandContext): Unit = {
    val cm = context.textChannel.getManager
    if (context.canRun(context.author, context.textChannel, Permission.MANAGE_CHANNEL)) {
      if (!context.isNsfw) {
        cm.setNSFW(true).queue()
        val embed = new Embed(Color.pink, description = "Toggled channel to NSFW.")
        embed.send(context.textChannel)
      } else {
        cm.setNSFW(false).queue()
        val embed = new Embed(Color.pink, description = "Toggled channel to SFW.")
        embed.send(context.textChannel)
      }
    }
  }
}
