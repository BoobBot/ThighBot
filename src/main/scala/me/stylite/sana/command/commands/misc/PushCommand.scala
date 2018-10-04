package me.stylite.sana.command.commands.misc

import java.awt.Color

import me.stylite.sana.command.{BotCommand, CommandContext}
import me.stylite.sana.util.Embed
import com.sksamuel.elastic4s.RefreshPolicy
import me.stylite.sana.Sana


object PushCommand extends BotCommand {

  override val name: String = "pushstats"
  override val aliases: Set[String] = Set.empty[String]
  override val desc: String = "Pong."

  //TODO: Add more to this
  override def execute(context: CommandContext): Unit = {
    import com.sksamuel.elastic4s.http.ElasticDsl._
    val servers = Sana.Sana.getGuilds.size()
    val users = Sana.Sana.getUsers.size()
    val shards = Sana.Sana.getShards.size()
    Sana.eal.execute {
      bulk(
        indexInto("guilds" / "mytype").fields("Guilds" -> s"$servers"),
        indexInto("users" / "mytype").fields("Users" -> s"$users"),
        indexInto("shards" / "mytype").fields("Shards" -> s"$shards")
      ).refresh(RefreshPolicy.WaitFor)
    }.await
  }
}
