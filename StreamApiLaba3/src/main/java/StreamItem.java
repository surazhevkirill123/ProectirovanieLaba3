

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamItem {


    public static void main(String[]args) throws Exception {
        Item[]items=Item.itemArrayCreation(3);           //создание массивов
        Store[]stores=Store.storeArrayCreation(3);

        Item[]items11=new Item[1];                              //конфигурация интернет-магазина
        items11[0]=items[0];
        List<Item> itemsList11= Arrays.asList(items11);

        Item[]items12=new Item[1];
        items12[0]=items[1];
        List<Item> itemsList12= Arrays.asList(items12);

        Item[]items13=new Item[1];
        items13[0]=items[2];
        List<Item> itemsList13= Arrays.asList(items13);

        Item[]items21=new Item[2];
        items21[0]=items[0];
        items21[1]=items[1];
        List<Item> itemsList21= Arrays.asList(items21);

        Item[]items22=new Item[2];
        items22[0]=items[1];
        items22[1]=items[2];
        List<Item> itemsList22= Arrays.asList(items22);

        Item[]items23=new Item[2];
        items23[0]=items[0];
        items23[1]=items[2];
        List<Item> itemsList23= Arrays.asList(items23);

        Store[]stores11=new Store[1];
        stores11[0]=stores[0];
        List<Store> storesList11= Arrays.asList(stores11);

        Store[]stores12=new Store[1];
        stores11[0]=stores[1];
        List<Store> storesList12= Arrays.asList(stores12);

        Store[]stores13=new Store[1];
        stores11[0]=stores[2];
        List<Store> storesList13= Arrays.asList(stores13);

        Store[]stores21=new Store[2];
        stores21[0]=stores[0];
        stores21[1]=stores[1];
        List<Store> storesList21= Arrays.asList(stores21);

        Store[]stores22=new Store[2];
        stores22[0]=stores[1];
        stores22[1]=stores[2];
        List<Store> storesList22= Arrays.asList(stores22);

        Store[]stores23=new Store[2];
        stores23[0]=stores[0];
        stores23[1]=stores[2];
        List<Store> storesList23= Arrays.asList(stores23);

        List<Store>storeList=Arrays.asList(stores);
        List<Item> itemList= Arrays.asList(items);


        items[0].setStores(storesList11);
        items[1].setStores(storesList21);
        items[2].setStores(storesList22);

        stores[0].setItems(itemsList12);
        stores[1].setItems(itemsList22);
        stores[2].setItems(itemsList23);
        for (int i=0;i<items.length;i++)                        //напечатает товары
        {
            System.out.println(items[i].toString());
        }
        for (int i=0;i<stores.length;i++)                       //напечатает магазины
        {
            System.out.println(stores[i].toString());
        }

        Collection<Item> itemCollection=Arrays.asList(items);   //создаю коллекцию и потом из неё создаю стримы и работаю с ними

        List<Item> moreThan500=itemCollection.stream().filter((i)->i.getPrice()>500).collect(Collectors.toList());                      //проверить, есть ли товары, дороже 500
        System.out.println("Есть ли товары,дороже 500 = " + !moreThan500.isEmpty());

        int max=itemCollection.stream().mapToInt(Item::getCount).max().getAsInt();                                                      //Найти товары с максимальнымколичеством единиц на складе
        List<Item> itemsWithMax=itemCollection.stream().filter((i)->i.getCount()==max).collect(Collectors.toList());
        System.out.println("Товары с максимальным количеством единиц на складе = " + itemsWithMax);

        int min=itemCollection.stream().mapToInt(Item::getCount).min().getAsInt();                                                      //Найти товары с минимальным количеством единиц на складе
        List<Item> itemsWithMin=itemCollection.stream().filter((i)->i.getCount()==min).collect(Collectors.toList());
        System.out.println("Товары с минимальным количеством единиц на складе = " + itemsWithMin);

        List<Item> itemsWithOneStore1=itemCollection.stream().filter((i)->i.getStores().size()==1).collect(Collectors.toList());        //Отфильтровать товары с единственным магазином(через stream)
        System.out.println("Товары с единственным магазином(через stream) = " + itemsWithOneStore1);

        List<Item> itemsWithOneStore2=itemCollection.parallelStream().filter((i)->i.getStores().size()==1).collect(Collectors.toList());//Отфильтровать товары с единственным магазином(через parallelStream)
        System.out.println("Товары с единственным магазином(через parallelStream) = " + itemsWithOneStore2);

        List<Item> itemsSortedByPrice=itemCollection.stream().sorted(Comparator.comparing(Item::getPrice)).collect(Collectors.toList());//Отсортировать товары по цене
        System.out.println("Товары, отсортированные по цене = " + itemsSortedByPrice);

        List<Item> itemsSortedByCount=itemCollection.stream().sorted(Comparator.comparing(Item::getCount)).collect(Collectors.toList());//Отсортировать товары по количеству
        System.out.println("Товары, отсортированные по количеству = " + itemsSortedByCount);

        List<List<Store>> storeList1=itemCollection.stream().map((i)->i.getStores()).collect(Collectors.toList());                      //Получить список магазинов
        System.out.println("Список магазинов = " + storeList1);

        System.out.print("Информация о магазинах, используя foreach =");                                                                //Напечатать информацию о магазинах, используя foreach
        itemCollection.stream().forEachOrdered((i)->System.out.print(i.getStores()+","));
        System.out.println();

        List<Store> storeList2=storeList1.stream().flatMap(store->store.stream()).distinct().collect(Collectors.toList());              //Получить список магазинов без дубликатов
        System.out.println("Список магазинов без дупликатов= " + storeList2);

        System.out.print("Информация о магазинах, используя peek =");                                                                   //Напечатать информацию о магазинах, используя peek
        List<Item> storeList3=itemCollection.stream().peek((i)->System.out.print(i.getStores()+",")).collect(Collectors.toList());
        System.out.println();

        /*Подготовить как минимум 3 примера с Optional. (Использовать orElseThrow, if(is)present, get,orElse)*/
        Optional<Item[]> optionalItems=Optional.of(items);
        System.out.println("Optional methods : ");
        System.out.println(optionalItems.isPresent());                                  //то же самое,что и System.out.println(optionalItems != null)
        System.out.println(Arrays.toString(optionalItems.orElse(new Item[3])));         //если optionalItems != null, то создаётся новый Item[3]
        System.out.println(Arrays.toString(optionalItems.orElseThrow(Exception::new))); //если optionalItems != null, то выбрасывается исключение
        System.out.println(Arrays.toString(optionalItems.get()));                       //то же самое,что и System.out.println(Arrays.toString(optionalItems))

        Logger logger = LogManager.getLogger(StreamItem.class);
        logger.info("All’s well that ends well ");


    }


}
