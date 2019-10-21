package me.stylite.sana

import java.awt.Color
import java.io.FileInputStream
import java.util.Properties

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder
import net.dv8tion.jda.api.entities.Activity
import me.stylite.sana.command.CommandManager

object Sana extends App {

  val prop = new Properties()
  prop.load(new FileInputStream("config.properties"))
  val LOG: Logger = LoggerFactory.getLogger("Sana")

  val PREFIX = prop.getProperty("PREFIX")
  val KEY = prop.getProperty("KEY")
  val BOT_COLOR = Color.pink

  val Sana = new DefaultShardManagerBuilder()
    .setToken(prop.getProperty("DISCORD_TOKEN"))
    .addEventListeners(CommandManager)
    .setActivity(Activity.playing(s"tbhelp || tbinvite"))
    .build()

}
