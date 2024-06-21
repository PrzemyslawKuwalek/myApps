//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Machine truck = new Truck();

        Machine bulldozer = new Bulldozer();

        Machine excavator = new Excavator();
        //tablica z obiektami

        Machine[] carPark = {truck , bulldozer , excavator };

        // stworzyc petle for ktora wyswietli do i stop work

        for (int i = 0; i < carPark.length; i++) {
            carPark[i].doWork();
            carPark[i].stopWork();


        }


        // stworzyc maszyny z podanych wczesniej 3 typow
        // i sprawdzic czy wywietlaja sie wiadomosci na konsoli



    }
}