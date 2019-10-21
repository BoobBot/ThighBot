package me.stylite.sana.command.commands.misc

import java.awt.Color

import me.stylite.sana.command.{BotCommand, CommandContext}
import me.stylite.sana.util.Embed

object PingCommand extends BotCommand {

  override val name: String = "ping"
  override val aliases: Set[String] = Set.empty[String]
  override val desc: String = "Pong."
  override val category: String = "Misc"

  //TODO: Add more to this
  override def execute(context: CommandContext): Unit = {
   context.send(s"Pong! ${context.jda.getGatewayPing}ms")
  }
}
