package me.stylite.sana.command.commands.misc

import java.awt.Color

import me.stylite.sana.command.{BotCommand, CommandContext}
import me.stylite.sana.util.Embed

object InviteCommand extends BotCommand {

  override val name: String = "invite"
  override val aliases: Set[String] = Set.empty[String]
  override val desc: String = "Pong."

  //TODO: Add more to this
  override def execute(context: CommandContext): Unit = {
    // context.channel.sendMessage("Pong! " + context.message.getJDA.getPing + "ms").queue()
    val embed = new Embed(Color.pink, "<:discord:495677697494876160> Server: https://invite.boob.bot/\n" +
      "<:bot:495677697448607754> Bot: https://thighs.boob.bot/\n" +
      ":link: Website: https://boob.bot/\n" +
      "<:paypal:495677697113063425> Paypal: https://paypal.boob.bot/")
    embed.send(context.eevent.getTextChannel)
  }
}
