package etiquetaDePreco;

public class ImportedProduct extends Product {
    private Double costumsFee;


    public ImportedProduct(String name, Double price, Double costumsFee) {
        super(name, price);
        this.costumsFee = costumsFee;
    }
    public Double totalPrice(){
        return getPrice()+costumsFee;

    }
    @Override
    public String priceTag(){
        return getName()
         + " - $ "
         +String.format("%.2f",getPrice())
         +" $ "
         +String.format("(Costumer fee: %.2f)",costumsFee);
     }


}
