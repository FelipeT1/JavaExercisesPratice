package Entities;

public class ImportedProduct extends Product{
    private Double customFee;
    public ImportedProduct(String name, Double price, Double customFee) {
        super(name, price);
        this.customFee = customFee;
    }
    public Double getCustomFee() {
        return customFee;
    }
    public Double totalPrice(){
        return super.getPrice()+getCustomFee();
    }
    @Override
    public String priceTag(){
        return String.format("%s R$ %.2f (Custom fee: R$ %.2f)%n", getName(),totalPrice(),getCustomFee());
    }
}
