package me.stylite.sana.events

import java.awt.Color

import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.events.guild.{GuildJoinEvent, GuildLeaveEvent}
import net.dv8tion.jda.api.EmbedBuilder
import me.stylite.sana.Sana

object Events extends ListenerAdapter {

  override def onGuildJoin(event: GuildJoinEvent): Unit = {
    val name = event.getGuild.getName
    val id = event.getGuild.getId
    val owner = event.getGuild.getOwner.getUser.getAsTag
    val memberCount = event.getGuild.getMembers.size
    val currentGuildCount = event.getJDA.getGuilds.size
    val desc = new StringBuilder
    desc.append(s"Guild name: $name\n")
    desc.append(s"Guild ID: $id\n")
    desc.append(s"Guild owner: $owner\n")
    desc.append(s"Guild member count: $memberCount\n")
    desc.append(s"Current guild count: $currentGuildCount")
    val em = new EmbedBuilder().setDescription(desc).setTitle("Joined a new guild!").setThumbnail(Sana.Sana.getUserById(495437730810036225L).getAvatarUrl).setColor(Color.pink)
    Sana.Sana.getGuildById(320397377536000012L).getTextChannelById(552122565779259402L).sendMessage(em.build()).queue()
  }

  override def onGuildLeave(event: GuildLeaveEvent): Unit = {
    val name = event.getGuild.getName
    val id = event.getGuild.getId
    val owner = event.getGuild.getOwner.getUser.getAsTag
    val memberCount = event.getGuild.getMembers.size
    val currentGuildCount = event.getJDA.getGuilds.size
    val desc = new StringBuilder
    desc.append(s"Guild name: $name\n")
    desc.append(s"Guild ID: $id\n")
    desc.append(s"Guild owner: $owner\n")
    desc.append(s"Guild member count: $memberCount\n")
    desc.append(s"Current guild count: $currentGuildCount")
    val em = new EmbedBuilder().setDescription(desc).setTitle("I left a guild!").setThumbnail(Sana.Sana.getUserById(495437730810036225L).getAvatarUrl).setColor(Color.pink)
    Sana.Sana.getGuildById(320397377536000012L).getTextChannelById(552122565779259402L).sendMessage(em.build()).queue()
  }
}