package me.stylite.sana.command

import net.dv8tion.jda.api.entities.{ChannelType, Guild, Member, Message, MessageChannel, TextChannel, User}
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.{JDA, Permission}
import net.dv8tion.jda.api.utils.MiscUtil
import me.stylite.sana.Sana

class CommandContext(val event: MessageReceivedEvent) {

  val channel: MessageChannel = event.getChannel
  val textChannel: TextChannel = event.getTextChannel
  val message: Message = event.getMessage
  val jda: JDA = event.getJDA
  val isNsfw: Boolean = event.getTextChannel.isNSFW
  val content: String = event.getMessage.getContentRaw
  val author: User = event.getAuthor
  val guild: Guild = event.getGuild
  val member: Member = event.getMember

  val allArgs: Array[String] = message.getContentRaw.split(" ")
  val commandName: String = allArgs(0).replace(Sana.PREFIX, "")
  val commandArgs: Array[String] = allArgs.slice(1, allArgs.length)

  def send(content: String): Unit = {
    message.getChannel.sendMessage(content).queue()
  }

  def canRun(user: User, channel: MessageChannel, permissions: Permission): Boolean = {
    val userChannel = channel.getJDA.getTextChannelById(channel.getIdLong)
    return if (channel.getType == ChannelType.PRIVATE || user.getIdLong == 366454817373290508L) {
      true
    } else {
      guild.getMember(user).hasPermission(userChannel, permissions)
    }
  }

  val args = {
    val rawArgs = content.split(" ")
    rawArgs.tail
  }

}
