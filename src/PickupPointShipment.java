public class PickupPointShipment extends ShipmentOrder{
    private String lockerSize;
    private boolean fragile;


    public PickupPointShipment(String lockerSize, boolean fragile,
                               int orderNumber, String customerName, int distanceKm, double baseFee){

        super(orderNumber, customerName, distanceKm, baseFee);

        this.lockerSize = lockerSize;
        this.fragile = fragile;
    }

    public String getShipmentType(){
        return "Pickup Point";
    }

    @Override
    protected double calculateBasePrice(){
        return getDistanceKm() + getDistanceKm() * 0.75;
    }

    @Override

    protected double calculateAdditionalFee(){
        if("S".equals(lockerSize)){
            return calculateBasePrice()+5;
        }
        else if("M".equals(lockerSize)){
            return calculateBasePrice()+10;
        }

        else if("L".equals(lockerSize)){
            return calculateBasePrice()+18;
        }

        else if(fragile == true){
            return calculateBasePrice()+12;
        }

        return calculateBasePrice();
    }

    @Override
    public void validateSpecificRules(){
        if (lockerSize == null) {
            throw new NullPointerException("lockerSize is null");
        }

        if (!lockerSize.equals("S") && !lockerSize.equals("M") && !lockerSize.equals("L")) {
            throw new IllegalArgumentException("Invalid lockerSize");
        }

    }





}
