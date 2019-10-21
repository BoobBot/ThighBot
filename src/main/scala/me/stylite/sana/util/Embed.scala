package me.stylite.sana.util

import java.awt.Color
import java.util.concurrent.TimeUnit

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.{Message, MessageEmbed, TextChannel}

import scala.collection.JavaConverters._

class Embed(color: Color = null, description: String = null, fields: List[MessageEmbed.Field] = null, title: String = null, imageUrl: String = null, thumbnailUrl: String = null) {
  val builder: EmbedBuilder = new EmbedBuilder

  if (!(color == null)) builder.setColor(color)
  if (!(description == null)) builder.setDescription(description)
  if (!(fields == null)) fields.foreach(f => builder.addField(f))
  if (!(title == null)) builder.setTitle(title)
  if (!(imageUrl == null)) builder.setImage(imageUrl)
  if (!(thumbnailUrl == null)) builder.setThumbnail(thumbnailUrl)

  def isEmpty: Boolean = builder.getFields.asScala.isEmpty

  def build: MessageEmbed = builder.build()

  def send(channel: TextChannel, seconds: Int = -1, message: Message = null, reaction: String = null): Unit = {
    val embed = builder.build()

    if (!(message == null)) {
      message.delete().queueAfter(seconds, TimeUnit.SECONDS)
    }

    if (reaction == null) {
      channel.sendMessage(embed).queue(msg =>
      {
        if (!(seconds == -1)) {
          msg.delete().queueAfter(seconds, TimeUnit.SECONDS)
        }
      }
      )
    } else {
      channel.sendMessage(embed).queue(msg =>
      {
        msg.addReaction(reaction).queue()
        if (!(seconds == -1)) {
          msg.delete().queueAfter(seconds, TimeUnit.SECONDS)
        }
      }
      )
    }
  }
  def sendComplete(channel: TextChannel, seconds: Int = -1, message: Message = null, reaction: String = null): Message = {
    val embed = builder.build()
    var msg: Message = null

    if (!(message == null)) {
      message.delete().queueAfter(seconds, TimeUnit.SECONDS)
    }

    if (reaction == null) {
      msg = channel.sendMessage(embed).complete()
      msg.delete().queueAfter(seconds, TimeUnit.SECONDS)
    } else {
      msg = channel.sendMessage(embed).complete()
      msg.addReaction(reaction).queue()
      msg.delete().queueAfter(seconds, TimeUnit.SECONDS)
    }

    msg
  }
}
