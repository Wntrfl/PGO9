public class InternationalShipment extends ShipmentOrder {
    private String destinationCountry;
    private boolean customDocumentsRequired;
    private boolean expressDelivery;


    public InternationalShipment(String destinationCountry, boolean customDocumentsRequired, boolean expressDelivery,
                                 int orderNumber, String customerName, int distanceKm, double baseFee) {

        super (orderNumber, customerName, distanceKm, baseFee);
        this.destinationCountry = destinationCountry;
        this.customDocumentsRequired = customDocumentsRequired;
        this.expressDelivery = expressDelivery;
    }

    public String getShipmentType() {
        return "International";
    }

    @Override
    protected double calculateBasePrice(){
        return getBaseFee() + getDistanceKm() * 2.10;
    }

    protected double calculateAdditionalFee(){
        if (customDocumentsRequired) {
           return calculateBasePrice()+ 45;
        }

        if (expressDelivery) {
            return calculateBasePrice()+ 80;
        }
        return calculateBasePrice();
    }

    @Override
    public void validateSpecificRules(){
        if(destinationCountry == null){
            throw new IllegalArgumentException("Destination Country cannot be empty");
        }
    }

    @Override
    protected double applyBusinessDiscount(double price){
        if (expressDelivery= false && getDistanceKm()> 1000) {
            return calculateBasePrice()- calculateBasePrice()*0.03;
        }
        return calculateBasePrice();
    }


}
