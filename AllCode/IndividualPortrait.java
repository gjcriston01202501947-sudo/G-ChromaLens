// ============================================================
//  INHERITANCE — Subclass 1 of PhotoshootService
//  Represents newborn, maternity, and funshoot sessions
// ============================================================
public class IndividualPortrait extends PhotoshootService {
 
    // ENCAPSULATION — private field with getter/setter
    private String portraitSubtype;
 
    public IndividualPortrait(String clientName, String bookingDate, String subtype) {
        super(clientName, bookingDate, 60, 500.0);
        setPortraitSubtype(subtype);
    }
 
    public String getPortraitSubtype() { return portraitSubtype; }
    public void setPortraitSubtype(String subtype) {
        if (subtype == null || subtype.trim().isEmpty())
            throw new IllegalArgumentException("Subtype cannot be empty.");
        this.portraitSubtype = subtype.trim();
    }
 
    // POLYMORPHISM — Method overriding
    @Override
    public String getServiceType() {
        return "Individual Portrait (" + portraitSubtype + ")";
    }
 
    @Override
    public double getExtensionRatePerHour() { return 300.0; }
 
    @Override
    public void displayServiceDetails() {
        System.out.println("     Package   : Individual Portrait");
        System.out.println("     Subtype   : " + portraitSubtype);
        System.out.println("     Session   : 60 minutes");
        System.out.println("     Price     : P500.00");
        System.out.println("     Includes  : Newborns, Maternity, Funshoot");
        System.out.println("     Delivery  : Soft copies via Google Drive");
    }
}