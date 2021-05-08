package viergewinntbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

public class Game {
    private Grid grid;
    private Player[] players;
    private long lastplayer;
    public Game(boolean ai, long player1id,long player2id){
        this.grid = new Grid();
        players = new Player[2];
        players[0] = new Player(":red_circle:",player1id);
        if (ai){
            // TODO: create Ai
        }
        else{
            players[1] = new Player(":large_blue_diamond:",player2id);
        }
        lastplayer = player2id;
    }
    public Grid getGrid(){
        return grid;
    }
    public boolean placeinrow(int row, int playerindex){
        return grid.placeinrow(row,players[playerindex].emoji);

    }

    public void run(MessageChannel channel, String input, User user) {
        int i;
        JDA jda = user.getJDA();
        User nextplayer = jda.getUserById(lastplayer);
        if(lastplayer == user.getIdLong()){
            channel.sendMessage("It's not your turn").queue();
            return;
        }
        try {
            i = Integer.parseInt(input);
        }catch (NumberFormatException e){
            return;
        }

        if (placeinrow(i,getPlayerindexbyid(user.getIdLong()))){
            lastplayer = user.getIdLong();
        }
        System.out.println(this.grid.toString());
        channel.sendMessage(utils.makeEmbed(this.grid.toString(),nextplayer)).queue();
    }
    private int getPlayerindexbyid(long id) {
        for (int i=0; i< players.length;i++) {
            if(players[i].id == id){
                return i;
            }
        }
        return -1;
    }
}
