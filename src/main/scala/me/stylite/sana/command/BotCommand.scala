package me.stylite.sana.command

abstract class BotCommand() {

  val name: String
  val aliases: Set[String]
  val desc: String
  val category: String

  def execute(commandContext: CommandContext): Unit

  /**
    * Checks if the given string matches the command name or one of the aliases
    */
  def doesMatch(s: String): Boolean = {
    name.equals(s.toLowerCase()) || aliases.contains(s.toLowerCase())
  }
}
