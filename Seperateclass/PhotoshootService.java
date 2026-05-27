// ============================================================
//  ABSTRACTION — Abstract base class
//  Hides implementation details, exposes only necessary methods
// ============================================================
public abstract class PhotoshootService {

    // ENCAPSULATION — private fields; no direct external access
    private String clientName;
    private String bookingDate;
    private int sessionDurationMinutes;
    private double basePrice;
    private String status;

    public PhotoshootService(String clientName, String bookingDate,
                             int sessionDurationMinutes, double basePrice) {
        setClientName(clientName);
        setBookingDate(bookingDate);
        setSessionDurationMinutes(sessionDurationMinutes);
        setBasePrice(basePrice);
        this.status = "Pending";
    }

    // ENCAPSULATION — Getters & Setters with validation
    public String getClientName() { return clientName; }
    public void setClientName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Client name cannot be empty.");
        this.clientName = name.trim();
    }

    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String date) {
        if (date == null || date.trim().isEmpty())
            throw new IllegalArgumentException("Booking date cannot be empty.");
        this.bookingDate = date.trim();
    }

    public int getSessionDurationMinutes() { return sessionDurationMinutes; }
    public void setSessionDurationMinutes(int mins) {
        if (mins <= 0) throw new IllegalArgumentException("Duration must be positive.");
        this.sessionDurationMinutes = mins;
    }

    public double getBasePrice() { return basePrice; }
    public void setBasePrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative.");
        this.basePrice = price;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // ABSTRACTION — Abstract methods subclasses MUST implement
    public abstract String getServiceType();
    public abstract double getExtensionRatePerHour();
    public abstract void displayServiceDetails();

    // POLYMORPHISM — Method overloading (same method name, different params)
    public double calculateTotal() {
        return basePrice;
    }

    public double calculateTotal(int extraHours) {
        if (extraHours < 0) throw new IllegalArgumentException("Extra hours cannot be negative.");
        return basePrice + (extraHours * getExtensionRatePerHour());
    }

    // Shared receipt printer used by all subclasses
    public void printReceipt(int extraHours) {
        System.out.println();
        System.out.println("  +------------------------------------------+");
        System.out.println("  |      G ChromaLens -- Booking Receipt      |");
        System.out.println("  +------------------------------------------+");
        System.out.printf("  | %-15s : %-24s|\n", "Service",       getServiceType());
        System.out.printf("  | %-15s : %-24s|\n", "Client",        clientName);
        System.out.printf("  | %-15s : %-24s|\n", "Date",          bookingDate);
        System.out.printf("  | %-15s : %-24s|\n", "Duration",      sessionDurationMinutes + " mins");
        System.out.printf("  | %-15s : %-24s|\n", "Delivery",      "Google Drive");
        System.out.printf("  | %-15s : %-24s|\n", "Edited Photos", "Included");
        System.out.printf("  | %-15s : P%-23.2f|\n", "Base Price", basePrice);
        if (extraHours > 0) {
            System.out.printf("  | %-15s : %-24s|\n",  "Extra Hours",    extraHours + " hr(s)");
            System.out.printf("  | %-15s : P%-23.2f|\n", "Extension Fee", extraHours * getExtensionRatePerHour());
        }
        System.out.println("  |------------------------------------------|");
        System.out.printf("  | %-15s : P%-23.2f|\n", "TOTAL",  calculateTotal(extraHours));
        System.out.printf("  | %-15s : %-24s|\n",    "Status", status);
        System.out.println("  +------------------------------------------+");
        System.out.println();
    }
}