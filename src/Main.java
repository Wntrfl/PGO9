//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ShipmentOrder[] orders = new ShipmentOrder[] {
                new DomesticCourierShipment(3, true, 120, "Anna", 55, 8.5),
                new DomesticCourierShipment(8, false, 420, "Piotr", 20, 14.0),
                new PickupPointShipment("L", true, 55, "Hanna", 20, 5.0),
                new PickupPointShipment("S", false, 30, "Jakub", 33, 2.53),
                new InternationalShipment("Poland", true, false, 110, "Technova", 40, 20.0),
                new InternationalShipment("Germany", false, true, 140, "SoftLine S.A.", 50, 34.5)
        };

        for (ShipmentOrder order : orders) {
            order.processOrder();
            System.out.println(order.buildSummaryLine());
            System.out.println();
        }
    }
}