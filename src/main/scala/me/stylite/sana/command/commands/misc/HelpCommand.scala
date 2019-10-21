package me.stylite.sana.command.commands.misc
import java.awt.Color
import java.util

import me.stylite.sana.command.{BotCommand, CommandContext, CommandManager}
import me.stylite.sana.util.Embed
import collection.mutable

object HelpCommand extends BotCommand {

  override val name: String = "help"
  override val aliases: Set[String] = Set.empty[String]
  override val desc: String = "The help command"
  override val category: String = "Misc"

  //TODO: Add more to this
  override def execute(context: CommandContext): Unit = {
    val commands = CommandManager.commands
    val commandMap = new mutable.HashMap[String, mutable.Set[String]] with mutable.MultiMap[String, String]
    commands.map(command => commandMap addBinding (command.category, s"${command.name}"))
    if (context.args.isEmpty) {
      val help = new StringBuilder
      help.append("```ini\n")
      help.append(s"Help for ${context.jda.getSelfUser.getName}\n\n")
      val miscCommands = commandMap.get("Misc").toList.head.toString().replace("Set(", "  ").replace(")", "")
      help.append(s"[Misc]\n")
      help.append(s"$miscCommands\n")
      val nsfwCommands = commandMap.get("NSFW").toList.head.toString().replace("Set(", "  ").replace(")", "")
      help.append("[NSFW]\n")
      help.append(s"$nsfwCommands\n")
      help.append("```")
      context.send(help.toString)
    } else {
      val help = new StringBuilder
      for (command <- commands) {
        if (command.name == context.args(0)){
          help.append("```ini\n")
            .append(s"[${command.name}]\n")
            .append(s"  Description: ${command.desc}\n")
            .append(s"  Aliases: ${command.aliases.toString.replace("Set(", "").replace(")", "")}\n")
            .append("```")
        }
      }
      context.send(help.toString())
    }
  }
}
