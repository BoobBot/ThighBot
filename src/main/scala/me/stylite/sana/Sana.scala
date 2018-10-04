package me.stylite.sana

import java.awt.Color
import java.io.FileInputStream
import java.util.Properties

import com.sksamuel.elastic4s.http.{ElasticClient, ElasticProperties}
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import net.dv8tion.jda.bot.sharding.{DefaultShardManagerBuilder, ShardManager}
import net.dv8tion.jda.core.entities.Game
import me.stylite.sana.command.CommandManager

object Sana extends App {

  val prop = new Properties()
  prop.load(new FileInputStream("config.properties"))
  val LOG: Logger = LoggerFactory.getLogger("Sana")

  val PREFIX = prop.getProperty("PREFIX")
  val BOT_COLOR = Color.pink
  val eal = ElasticClient(ElasticProperties("http://localhost:9200"))


  val Sana = new DefaultShardManagerBuilder()
    .setToken(prop.getProperty("DISCORD_TOKEN"))
    .addEventListeners(CommandManager)
    .setGame(Game.playing(s"tbhelp || tbinvite"))
    .build()


}
