package me.stylite.sana.command.commands.misc

import java.awt.Color

import me.stylite.sana.command.{BotCommand, CommandContext}
import me.stylite.sana.util.Embed

object PingCommand extends BotCommand {

  override val name: String = "ping"
  override val aliases: Set[String] = Set.empty[String]
  override val desc: String = "Pong."

  //TODO: Add more to this
  override def execute(context: CommandContext): Unit = {
      // context.channel.sendMessage("Pong! " + context.message.getJDA.getPing + "ms").queue()
      val embed = new Embed(Color.pink, "Pong! " + context.message.getJDA.getPing + "ms")
      embed.send(context.eevent.getTextChannel)
  }
}
