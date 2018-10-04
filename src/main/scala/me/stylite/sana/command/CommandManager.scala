package me.stylite.sana.command

import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter
import me.stylite.sana.Sana
import me.stylite.sana._
import me.stylite.sana.command.commands.misc
import me.stylite.sana.command.commands.misc.{PingCommand, ThighCommand, ToggleCommand, HelpCommand, InviteCommand, StatsCommand, PushCommand}

object CommandManager extends ListenerAdapter {

  val commands: Set[BotCommand] = Set(
    PingCommand,
    ThighCommand,
    ToggleCommand,
    HelpCommand,
    InviteCommand,
    StatsCommand,
    PushCommand
  )

  override def onMessageReceived(event: MessageReceivedEvent): Unit = {

    if (event.getMessage.getContentRaw.startsWith(Sana.PREFIX)){
      handleCommand(new CommandContext(event))
    }
  }

  private def handleCommand(context: CommandContext): Unit = {
    commands.find(_.doesMatch(context.name)) match {
      case Some(c) => c.execute(context)
      case None => return
    }
  }

}