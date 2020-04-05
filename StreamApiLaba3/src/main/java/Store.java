import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Store {
    private String name;
    List<Item> items;
    List<String> feedbackList;

    Store()
    {
        System.out.println("Введите имя: ");Scanner in1 = new Scanner(System.in);this.name=in1.nextLine();
        this.items=null;
        this.feedbackList= Arrays.asList("Cool","Good");
    }
    Store(String name,List<Item>items,List<String>feedbackList)
    {
        this.name=name;
        this.items=items;
        this.feedbackList=feedbackList;

    }

    public void setName(String name) {
        this.name = name;
    }



    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setFeedbackList(List<String> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<String> getFeedbackList() {
        return feedbackList;
    }

    @Override
    public String toString() {

        return "Store{" +
                "name='" + name + '\'' +
                ", items=" +this.getNames()+
                ", feedbackList=" + feedbackList +
                '}';
    }

    public static Store[] storeArrayCreation(int length) {
        Store[]stores=new Store[length];
        for (int i=0;i<length;i++)
            stores[i]=new Store();

        return stores;
    }

    public List<String> getNames(){
        String[] stringNames1=new String[items.size()];
        for (int i=0;i<stringNames1.length;i++)
        {
            stringNames1[i]=items.get(i).getName();
        }
        List<String> names=Arrays.asList(stringNames1);
        return names;
    }

    public static void main(String[]args){
        Store[]stores=storeArrayCreation(2);
        System.out.println(stores.toString());
    }
}
