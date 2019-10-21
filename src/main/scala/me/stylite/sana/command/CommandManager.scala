package me.stylite.sana.command

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import me.stylite.sana.Sana
import me.stylite.sana.command.commands.misc.{PingCommand, ThighCommand, ToggleCommand, HelpCommand, InviteCommand, StatsCommand}

object CommandManager extends ListenerAdapter {

  val commands: Set[BotCommand] = Set(
    PingCommand,
    ThighCommand,
    ToggleCommand,
    HelpCommand,
    InviteCommand,
    StatsCommand
  )

  override def onMessageReceived(event: MessageReceivedEvent): Unit = {
    if (event.getMessage.getContentRaw.startsWith(Sana.PREFIX)){
      if (event.getMessage.getAuthor.isBot){ return } else {
        handleCommand(new CommandContext(event))
      }
    }
  }

  private def handleCommand(context: CommandContext): Unit = {
    commands.find(_.doesMatch(context.commandName)) match {
      case Some(c) => c.execute(context)
      case None =>
    }
  }

}