package me.stylite.sana.command.commands.misc

import java.awt.Color

import me.stylite.sana.Sana
import me.stylite.sana.command.{BotCommand, CommandContext}
import me.stylite.sana.util.Embed
import me.stylite.sana.util.ThighApi

object ThighCommand extends BotCommand {

  override val name: String = "thigh"
  override val aliases: Set[String] = Set.empty[String]
  override val desc: String = "Posts a sexy thigh."
  override val category: String = "NSFW"

  //TODO: Add more to this
  override def execute(context: CommandContext): Unit = {
    val thigh = ThighApi.getThigh
    val prefix = Sana.PREFIX
    if(context.isNsfw){
      val embed = new Embed(Color.pink, description= "Sexy thighs", imageUrl= s"$thigh")
      embed.send(context.textChannel)
    } else {
      context.send(s"This isn't a NSFW Channel. Use `${prefix}toggle` to turn it into one.")
    }

  }
}
