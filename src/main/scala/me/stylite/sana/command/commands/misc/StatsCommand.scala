package me.stylite.sana.command.commands.misc

import java.awt.Color

import me.stylite.sana.command.{BotCommand, CommandContext}
import me.stylite.sana.util.Embed
import com.sun.management.OperatingSystemMXBean
import net.dv8tion.jda.api.JDA
import java.lang.management.ManagementFactory
import java.text.DecimalFormat

import me.stylite.sana.Sana

object StatsCommand extends BotCommand {

  override val name: String = "stats"
  override val aliases: Set[String] = Set.empty[String]
  override val desc: String = "Shows stats on the bot"
  override val category: String = "Misc"

  //TODO: Add more to this
  override def execute(context: CommandContext): Unit = {
    // context.channel.sendMessage("Pong! " + context.message.getJDA.getPing + "ms").queue()
    val servers = Sana.Sana.getGuilds.size()
    val users = Sana.Sana.getUsers.size()
    val shards = Sana.Sana.getShards.size()

    val embed = new Embed(Color.pink, s"```" + s"Servers: $servers\n" + s"Users: $users\n" + s"Shards: $shards" + "```")
    embed.send(context.textChannel)
  }
}
