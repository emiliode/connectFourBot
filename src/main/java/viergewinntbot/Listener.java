package viergewinntbot;

import com.vdurmont.emoji.EmojiManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Listener extends ListenerAdapter {
    private  Game game;

    @Override 
    public void onMessageReceived(MessageReceivedEvent event){
        JDA jda = event.getJDA();
        User author = event.getAuthor();
        if (author.isBot()) return;


        Message message = event.getMessage();
        String msg = message.getContentDisplay();
        MessageChannel channel = event.getChannel();
        ArrayList<String>  options = new ArrayList<>();
        options.add("0");
        options.add("1");
        options.add("2");
        options.add("3");
        options.add("4");
        options.add("5");
        options.add("6");
        if(msg.startsWith("-play")) {
            this.game = new Game(false, author.getIdLong(), message.getMentionedUsers().get(0).getIdLong());
            System.out.println("hallo");
            event.getChannel().sendMessage(utils.makeEmbed(game.getGrid().toString(),author)).queue();
        }else  {
            try {
                this.game.run(channel,message.getContentDisplay(),author);
            }
            catch (NullPointerException e){
                channel.sendMessage("You must start a game first using !play").queue();
            }
        }

        System.out.println("Received a message from "+event.getAuthor().getName() + " : "+ event.getMessage().getContentDisplay());

    }

}
