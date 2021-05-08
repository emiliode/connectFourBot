package viergewinntbot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;

public  class utils {
    public static MessageEmbed makeEmbed(String grid, User nextUser){
        EmbedBuilder eb = new EmbedBuilder();
        eb.setAuthor("Vier Gewinnt");
        eb.setTitle("Vier Gewinnt");
        eb.addField("Spielfed",grid,false);
        eb.addField("Nächster Spieler",nextUser.getAsMention(),false);
        return  eb.build();
    }
}
