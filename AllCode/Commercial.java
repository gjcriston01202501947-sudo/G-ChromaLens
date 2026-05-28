// ============================================================
//  INHERITANCE — Subclass 3 of PhotoshootService
//  Represents product, food, and fashion photography sessions
// ============================================================
public class Commercial extends PhotoshootService {
 
    // ENCAPSULATION — private field with getter/setter
    private String commercialCategory;
 
    public Commercial(String clientName, String bookingDate, String category) {
        super(clientName, bookingDate, 120, 2000.0);
        setCommercialCategory(category);
    }
 
    public String getCommercialCategory() { return commercialCategory; }
    public void setCommercialCategory(String category) {
        if (category == null || category.trim().isEmpty())
            throw new IllegalArgumentException("Category cannot be empty.");
        this.commercialCategory = category.trim();
    }
 
    // POLYMORPHISM — Method overriding
    @Override
    public String getServiceType() { return "Commercial -- " + commercialCategory; }
 
    @Override
    public double getExtensionRatePerHour() { return 500.0; }
 
    @Override
    public void displayServiceDetails() {
        System.out.println("     Package   : Commercial");
        System.out.println("     Category  : " + commercialCategory);
        System.out.println("     Session   : 120 minutes");
        System.out.println("     Price     : P2,000.00");
        System.out.println("     Includes  : Product, Food, Fashion Photography + Layout");
        System.out.println("     Delivery  : Soft copies via Google Drive");
    }
}