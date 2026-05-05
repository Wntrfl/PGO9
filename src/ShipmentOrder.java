public abstract class ShipmentOrder implements SummaryPrintable {
    private int orderNumber;
    private String customerName;
    private int distanceKm;
    private double baseFee;
    private boolean insured;
    private double lastCalculatedPrice;

    public ShipmentOrder(int orderNumber, String customerName, int distanceKm, double baseFee) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.distanceKm = distanceKm;
        this.baseFee = baseFee;
        this.lastCalculatedPrice = lastCalculatedPrice;
        this.insured = false;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getDistanceKm() {
        return distanceKm;
    }

    public double getBaseFee() {
        return baseFee;
    }

    public boolean isInsured() {
        return insured;
    }

    public double getLastCalculatedPrice() {
        return lastCalculatedPrice;
    }

    @Override
    public String toString() {
        return String.format("Order number:%s | Customer name:%s | Price: $%.2f ",
                orderNumber, customerName, lastCalculatedPrice);
    }

    private void validateOrder(){
        if(orderNumber == 0){
            throw new IllegalArgumentException("Order number must be greater than zero");
        }
        if(customerName == null){
            throw new IllegalArgumentException("Customer name cannot be empty");
        }

        if(distanceKm <= 0){
            throw new IllegalArgumentException("Distance must be greater than zero");
        }

    }

    protected void validateSpecificRules(){

    }

    private double applyInsurance(double price){
        if(insured){
            lastCalculatedPrice += lastCalculatedPrice * 0.07;
        }
        return lastCalculatedPrice;
    }

    protected double applyBusinessDiscount(double price){
        return price;
    }

    private void printProcessingResult(){
        System.out.print("Order info: " + orderNumber + customerName + lastCalculatedPrice);

    }

    public String buildSummaryLine(){
        return "Order info: " + orderNumber + customerName + lastCalculatedPrice;
    }

    protected abstract double calculateBasePrice();
    protected abstract double calculateAdditionalFee();
    public abstract String getShipmentType();

    public final void processOrder() {
        validateOrder();
        validateSpecificRules();

        double price = calculateBasePrice();
        price += calculateAdditionalFee();
        price = applyInsurance(price);
        price = applyBusinessDiscount(price);

        lastCalculatedPrice = price;
        printProcessingResult();
    }




}
