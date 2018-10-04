package me.stylite.sana.command.commands.misc

import java.awt.Color

import me.stylite.sana.command.{BotCommand, CommandContext}
import me.stylite.sana.util.Embed

object HelpCommand extends BotCommand {

  override val name: String = "help"
  override val aliases: Set[String] = Set.empty[String]
  override val desc: String = "Pong."

  //TODO: Add more to this
  override def execute(context: CommandContext): Unit = {
    // context.channel.sendMessage("Pong! " + context.message.getJDA.getPing + "ms").queue()
    val embed = new Embed(Color.pink, "**tbping**: pong!\n" +
      "**tbthigh**: Posts a random sexy thigh.\n" +
      "**tbthighs**: Random thighs as a slideshow.\n" +
      "**tbtoggle**: Toggles the current channels nsfw setting.\n" +
      "**tbinvite**: bot, support server and paypal links.\n" + ":link: Links\n" +
      "<:discord:495677697494876160> Server: https://invite.boob.bot/\n" +
      "<:bot:495677697448607754> Bot: https://thighs.boob.bot/\n" +
      ":link: Website: https://boob.bot\n" +
      "<:paypal:495677697113063425> Paypal: https://paypal.boob.bot/")
    embed.send(context.eevent.getTextChannel)
  }
}
