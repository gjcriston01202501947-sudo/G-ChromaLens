// ============================================================
//  INHERITANCE — Subclass 2 of PhotoshootService
//  Represents pre-debut, prenup, couple, family, group sessions
// ============================================================
public class Portrait extends PhotoshootService {
 
    // ENCAPSULATION — private fields with getters/setters
    private String occasion;
    private int numberOfSubjects;
 
    public Portrait(String clientName, String bookingDate, String occasion, int subjects) {
        super(clientName, bookingDate, 120, 1000.0);
        setOccasion(occasion);
        setNumberOfSubjects(subjects);
    }
 
    public String getOccasion() { return occasion; }
    public void setOccasion(String occasion) {
        if (occasion == null || occasion.trim().isEmpty())
            throw new IllegalArgumentException("Occasion cannot be empty.");
        this.occasion = occasion.trim();
    }
 
    public int getNumberOfSubjects() { return numberOfSubjects; }
    public void setNumberOfSubjects(int count) {
        if (count <= 0) throw new IllegalArgumentException("Subjects must be at least 1.");
        this.numberOfSubjects = count;
    }
 
    // POLYMORPHISM — Method overriding
    @Override
    public String getServiceType() { return "Portrait -- " + occasion; }
 
    @Override
    public double getExtensionRatePerHour() { return 500.0; }
 
    @Override
    public void displayServiceDetails() {
        System.out.println("     Package   : Portrait");
        System.out.println("     Occasion  : " + occasion);
        System.out.println("     Subjects  : " + numberOfSubjects);
        System.out.println("     Session   : 120 minutes");
        System.out.println("     Price     : P1,000.00");
        System.out.println("     Includes  : Pre-debut, Prenup, Couple, Family, Group");
        System.out.println("     Delivery  : Soft copies via Google Drive");
    }
}