package me.stylite.sana.command

import net.dv8tion.jda.core.entities.{Message, MessageChannel, User}
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter
import net.dv8tion.jda.core.Permission
import net.dv8tion.jda.core.utils.MiscUtil
import me.stylite.sana.Sana

class CommandContext(val event: MessageReceivedEvent) {

  //Basic stuff that is just from the event
  val channel: MessageChannel = event.getChannel
  val message: Message = event.getMessage
  val eevent = event
  val isNsfw = event.getTextChannel.isNSFW
  val rawMessage: String = event.getMessage.getContentRaw
  val author: User = event.getAuthor
  val guild = event.getGuild
  val test = args: Array[String]
  val member = event.getMember

  val allArgs: Array[String] = message.getContentRaw.split(" ")
  val commandName = allArgs(0).replace(Sana.PREFIX, "")
  val commandArgs = allArgs.slice(1, allArgs.length)

  //Doing this so that the other args variable won't be in scope
  val (name, args) = {
    val rawArgs = rawMessage.split(" ")
    (rawArgs.head.replace(Sana.PREFIX, ""), rawArgs.tail)
  }

  def Args(start: Int = 0, delim: String = " "): String = {
    combineArgs(start, commandArgs.length, delim)
  }

  def AArgs(start: Int = 0): Array[Char] = {
    combineArgss(start, commandArgs.length)
  }

  def combineArgs(start: Int, end: Int, delim: String): String = {

    var subArray = commandArgs.slice(start, end)
    var builder: StringBuilder = new StringBuilder

    for (i <- 0 until subArray.length){
      builder.append(subArray(i))
      if (i + 1 < subArray.length){
        builder.append(" ")
      }
    }
    builder.toString
  }


  def combineArgss(start: Int, end: Int): Array[Char] = {

    var subArray = commandArgs.slice(start, end)
    var builder: StringBuilder = new StringBuilder

    for (i <- 0 until subArray.length){
      builder.append(subArray(i))
      if (i + 1 < subArray.length){
        builder.append(" ")
      }
    }
    builder.toArray
  }


}
