import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Item {
    private String name;
    private int price;
    private int count;
    List<Store> stores;
    Item()
    {
        System.out.println("Введите имя: ");Scanner in1 = new Scanner(System.in);this.name=in1.nextLine();
        System.out.println("Введите цену: ");Scanner in2 = new Scanner(System.in);this.price=in2.nextInt();
        System.out.println("Введите количество: ");Scanner in3 = new Scanner(System.in);this.count=in3.nextInt();
        this.stores=null;
    }
    Item(String name,int price,int count,List<Store> stores)
    {
        this.name=name;
        this.price=price;
        this.count=count;
        this.stores=stores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public List<Store> getStores() {
        return stores;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", stores=" +this.getNames()+
                '}';
    }

    public List<String> getNames(){
        String[] stringNames=new String[stores.size()];
        for (int i=0;i<stringNames.length;i++)
        {
            stringNames[i]=stores.get(i).getName();
        }
        List<String> names=Arrays.asList(stringNames);
        return names;

    }

    public static Item[] itemArrayCreation(int length) {
        Item[]items=new Item[length];
        for (int i=0;i<length;i++)
            items[i]=new Item();
        return items;
    }
    public static void main(String[]args){
        Item[]items=itemArrayCreation(2);
        Store[]stores=Store.storeArrayCreation(2);

        List<Store> storesList1= Arrays.asList(stores);
        items[0].setStores(storesList1);

        List<Store> storesList2= Arrays.asList(stores);
        items[1].setStores(storesList2);




        List<Item> itemsList1= Arrays.asList(items);
        stores[0].setItems(itemsList1);

        List<Item> itemsList2= Arrays.asList(items);
        stores[1].setItems(itemsList2);



        for (int i=0;i<items.length;i++)
        {
            System.out.println(items[i].toString());
        }
        for (int i=0;i<stores.length;i++)
        {
            System.out.println(stores[i].toString());
        }


    }
}
