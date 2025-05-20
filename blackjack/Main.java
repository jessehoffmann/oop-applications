public class Main {
    public static void main(String[] args) {
        UserPlayer player = new UserPlayer(1000, new Hand());
        Dealer dealer = new Dealer(new Hand());
        while (player.getBalance() > 0) {
            new GameRound(player, dealer, new Deck()).play();
        }
    }
}
