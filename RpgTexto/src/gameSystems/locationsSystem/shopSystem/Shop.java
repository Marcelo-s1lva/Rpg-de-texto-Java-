package gameSystems.locationsSystem.shopSystem;

import gameSystems.inventorySystem.Item;
import gameSystems.locationsSystem.Location;
import gameplay.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Shop extends Location {
    private List<Item> stock = new ArrayList<>();
    private List<Integer> costs = new ArrayList<>();
    private Player client;


    private void buy(Item itemToBuy, int cost, Player player){
        if (player.getMoney() >= cost){
            player.setMoney(player.getMoney() - cost);
            player.inventory.addItem(itemToBuy);
        }
        else{
            System.out.println("not Enough Money");

        }
    }


    public Player getClient() {
        return client;
    }

    public void setClient(Player client){
        this.client = client;
    }

    protected void addItem(Item item, int cost){
        stock.add(item);
        costs.add(cost);
    }

    private void buyItem(int selectedItem){
        if (selectedItem < stock.size() && client != null){
            buy(stock.get(selectedItem), costs.get(selectedItem),client);
            System.out.println("Bought:"+ stock.get(selectedItem).getName());
        }
        else{
            System.out.println("Not enough money");
        }
    }

    protected void shopBlock(){
        if (!stock.isEmpty()) {
            boolean Selected = false;
            Scanner insert = new Scanner(System.in);
            while(Selected == false) {
                for (int i = 0; i < stock.size(); i++) {
                    System.out.println("");
                    System.out.print("Item: " + stock.get(i).getName() + " - Cost:" + costs.get(i));
                    System.out.println("----" + i);
                }
                System.out.println("Your money:" + client.getMoney());
                System.out.println("");
                System.out.println("Select an option(-1 To cancel)");
                int option = insert.nextInt();
                if (option >= 0 && option < stock.size()) {
                    buyItem(option);
                }
                else {
                    Selected = true;
                }
            }

        }else {
            System.out.println("Empty shop");
        }

    }

}
