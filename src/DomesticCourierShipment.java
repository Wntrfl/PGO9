public class DomesticCourierShipment extends ShipmentOrder{
    private int packageWeightKg;
    private boolean weekendDelivery;

    public DomesticCourierShipment(int packageWeightKg, boolean weekendDelivery) {
        super(int orderNumber, String customerName, int distanceKm, double baseFee);
        this.packageWeightKg = packageWeightKg;
        this.weekendDelivery = weekendDelivery;

    }

    public String getShipmentType(){
        return "Domestic Courier";
    }

    @Override
    protected double calculateBasePrice(){
        return getBaseFee()+ getDistanceKm()*1.20;
    }


    @Override
    protected double calculateAdditionalFee(){
        if (weekendDelivery){
            return (packageWeightKg*4.00)+ 25;
        }
        else{
        return packageWeightKg*4.00;
        }
    }

    @Override
    protected double applyBusinessDiscount(double price){
        if (getDistanceKm()>= 300){
            return price- price*0.05;
        }
        else{
            return price;
        }
    }



}
