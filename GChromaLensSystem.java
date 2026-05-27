// ============================================================
//  GChromaLensSystem.java 
//  G ChromaLens Photoshoot Booking System (Console App)
//  Final Machine Problem — OOP in Java
// ============================================================

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ============================================================
//  ABSTRACTION — Interface
//  Defines a contract for all bookable services
// ============================================================
interface Bookable {
    void book();
    void cancel();
    String getBookingStatus();
}

// ============================================================
// ABSTRACTION — Abstract base class
// Hides implementation details, exposes only necessary methods
// ============================================================
abstract class PhotoshootService {

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
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Client name cannot be empty.");
        this.clientName = name.trim();
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String date) {
        if (date == null || date.trim().isEmpty())
            throw new IllegalArgumentException("Booking date cannot be empty.");
        this.bookingDate = date.trim();
    }

    public int getSessionDurationMinutes() {
        return sessionDurationMinutes;
    }

    public void setSessionDurationMinutes(int mins) {
        if (mins <= 0)
            throw new IllegalArgumentException("Duration must be positive.");
        this.sessionDurationMinutes = mins;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative.");
        this.basePrice = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ABSTRACTION — Abstract methods subclasses MUST implement
    public abstract String getServiceType();

    public abstract double getExtensionRatePerHour();

    public abstract void displayServiceDetails();

    // POLYMORPHISM — Method overloading (same method name, different params)
    public double calculateTotal() {
        return basePrice;
    }

    public double calculateTotal(int extraHours) {
        if (extraHours < 0)
            throw new IllegalArgumentException("Extra hours cannot be negative.");
        return basePrice + (extraHours * getExtensionRatePerHour());
    }

    // Shared receipt printer used by all subclasses
    public void printReceipt(int extraHours) {
        System.out.println();
        System.out.println("  +------------------------------------------+");
        System.out.println("  |      G ChromaLens -- Booking Receipt      |");
        System.out.println("  +------------------------------------------+");
        System.out.printf("  | %-15s : %-24s|\n", "Service", getServiceType());
        System.out.printf("  | %-15s : %-24s|\n", "Client", clientName);
        System.out.printf("  | %-15s : %-24s|\n", "Date", bookingDate);
        System.out.printf("  | %-15s : %-24s|\n", "Duration", sessionDurationMinutes + " mins");
        System.out.printf("  | %-15s : %-24s|\n", "Delivery", "Google Drive");
        System.out.printf("  | %-15s : %-24s|\n", "Edited Photos", "Included");
        System.out.printf("  | %-15s : P%-23.2f|\n", "Base Price", basePrice);
        if (extraHours > 0) {
            System.out.printf("  | %-15s : %-24s|\n", "Extra Hours", extraHours + " hr(s)");
            System.out.printf("  | %-15s : P%-23.2f|\n", "Extension Fee", extraHours * getExtensionRatePerHour());
        }
        System.out.println("  |------------------------------------------|");
        System.out.printf("  | %-15s : P%-23.2f|\n", "TOTAL", calculateTotal(extraHours));
        System.out.printf("  | %-15s : %-24s|\n", "Status", status);
        System.out.println("  +------------------------------------------+");
        System.out.println();
    }
}

// ============================================================
// INHERITANCE — Subclass 1 of PhotoshootService
// Represents newborn, maternity, and funshoot sessions
// ============================================================
class IndividualPortrait extends PhotoshootService {

    // ENCAPSULATION — private field with getter/setter
    private String portraitSubtype;

    public IndividualPortrait(String clientName, String bookingDate, String subtype) {
        super(clientName, bookingDate, 60, 500.0);
        setPortraitSubtype(subtype);
    }

    public String getPortraitSubtype() {
        return portraitSubtype;
    }

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
    public double getExtensionRatePerHour() {
        return 300.0;
    }

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

// ============================================================
// INHERITANCE — Subclass 2 of PhotoshootService
// Represents pre-debut, prenup, couple, family, group sessions
// ============================================================
class Portrait extends PhotoshootService {

    // ENCAPSULATION — private fields with getters/setters
    private String occasion;
    private int numberOfSubjects;

    public Portrait(String clientName, String bookingDate, String occasion, int subjects) {
        super(clientName, bookingDate, 120, 1000.0);
        setOccasion(occasion);
        setNumberOfSubjects(subjects);
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        if (occasion == null || occasion.trim().isEmpty())
            throw new IllegalArgumentException("Occasion cannot be empty.");
        this.occasion = occasion.trim();
    }

    public int getNumberOfSubjects() {
        return numberOfSubjects;
    }

    public void setNumberOfSubjects(int count) {
        if (count <= 0)
            throw new IllegalArgumentException("Subjects must be at least 1.");
        this.numberOfSubjects = count;
    }

    // POLYMORPHISM — Method overriding
    @Override
    public String getServiceType() {
        return "Portrait -- " + occasion;
    }

    @Override
    public double getExtensionRatePerHour() {
        return 500.0;
    }

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

// ============================================================
// INHERITANCE — Subclass 3 of PhotoshootService
// Represents product, food, and fashion photography sessions
// ============================================================
class Commercial extends PhotoshootService {

    // ENCAPSULATION — private field with getter/setter
    private String commercialCategory;

    public Commercial(String clientName, String bookingDate, String category) {
        super(clientName, bookingDate, 120, 2000.0);
        setCommercialCategory(category);
    }

    public String getCommercialCategory() {
        return commercialCategory;
    }

    public void setCommercialCategory(String category) {
        if (category == null || category.trim().isEmpty())
            throw new IllegalArgumentException("Category cannot be empty.");
        this.commercialCategory = category.trim();
    }

    // POLYMORPHISM — Method overriding
    @Override
    public String getServiceType() {
        return "Commercial -- " + commercialCategory;
    }

    @Override
    public double getExtensionRatePerHour() {
        return 500.0;
    }

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

// ============================================================
// BookingEntry — Implements Bookable interface
// Wraps any PhotoshootService and manages booking state
// Demonstrates runtime dispatch via parent reference
// ============================================================
class BookingEntry implements Bookable {

    // POLYMORPHISM — parent reference holds any subclass object
    private PhotoshootService service;
    private int extraHours;

    public BookingEntry(PhotoshootService service, int extraHours) {
        this.service = service;
        this.extraHours = extraHours;
    }

    // ABSTRACTION — Bookable interface methods
    @Override
    public void book() {
        service.setStatus("Confirmed");
    }

    @Override
    public void cancel() {
        service.setStatus("Cancelled");
    }

    @Override
    public String getBookingStatus() {
        return service.getStatus();
    }

    // POLYMORPHISM — runtime dispatch: calls the correct subclass method
    public void showDetails() {
        service.displayServiceDetails();
    }

    public void showReceipt() {
        service.printReceipt(extraHours);
    }

    public PhotoshootService getService() {
        return service;
    }

    public int getExtraHours() {
        return extraHours;
    }
}

// ============================================================
// GChromaLensSystem — Main Entry Point
// Console menu and user interaction
// ============================================================
public class GChromaLensSystem {

    static Scanner sc = new Scanner(System.in);
    static List<BookingEntry> bookings = new ArrayList<>();

    public static void main(String[] args) {
        printBanner();
        boolean running = true;
        while (running) {
            printMainMenu();
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    bookService();
                    break;
                case "2":
                    viewAllBookings();
                    break;
                case "3":
                    viewReceipt();
                    break;
                case "4":
                    cancelBooking();
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("\n  [!] Invalid option. Please enter 1-5.\n");
            }
        }
        System.out.println();
        System.out.println("  Thank you for choosing G ChromaLens!");
        System.out.println("  because every moment deserves to be framed -- affordably.");
        System.out.println();
    }

    // ── Banner ────────────────────────────────────────────────
    static void printBanner() {
        System.out.println();
        System.out.println("  ==========================================");
        System.out.println("          G  C H R O M A L E N S");
        System.out.println("         Photoshoot Booking System");
        System.out.println("  ==========================================");
        System.out.println("      capturing faces, framing emotion");
        System.out.println("         Contact: +63 906 586 4651");
        System.out.println("  ==========================================");
        System.out.println();
    }

    // ── Main Menu ─────────────────────────────────────────────
    static void printMainMenu() {
        System.out.println("  ==========================================");
        System.out.println("                 MAIN MENU");
        System.out.println("  ==========================================");
        System.out.println("   [1] Book a Service");
        System.out.println("   [2] View All Bookings");
        System.out.println("   [3] View Receipt");
        System.out.println("   [4] Cancel a Booking");
        System.out.println("   [5] Exit");
        System.out.println("  ==========================================");
        System.out.print("   Choose: ");
    }

    // ── Book a Service ────────────────────────────────────────
    static void bookService() {
        System.out.println();
        System.out.println("  ==========================================");
        System.out.println("            SELECT A PACKAGE");
        System.out.println("  ==========================================");
        System.out.println("   [1] Individual Portrait   -- P500");
        System.out.println("       (60 mins | +P300/hr extension)");
        System.out.println("   [2] Portrait              -- P1,000");
        System.out.println("       (120 mins | +P500/hr extension)");
        System.out.println("   [3] Commercial            -- P2,000");
        System.out.println("       (120 mins | +P500/hr extension)");
        System.out.println("   [0] Back");
        System.out.println("  ==========================================");
        System.out.print("   Choose package: ");
        String pkg = sc.nextLine().trim();

        if (pkg.equals("0"))
            return;

        System.out.print("\n   Client Name  : ");
        String name = sc.nextLine().trim();

        System.out.print("   Booking Date : ");
        String date = sc.nextLine().trim();

        System.out.print("   Extra Hours  : ");
        int extra = 0;
        try {
            extra = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            extra = 0;
        }

        // POLYMORPHISM — parent reference will hold the chosen subclass
        PhotoshootService service = null;

        try {
            switch (pkg) {
                case "1":
                    System.out.println("   Subtypes: Newborn | Maternity | Funshoot");
                    System.out.print("   Subtype : ");
                    String subtype = sc.nextLine().trim();
                    service = new IndividualPortrait(name, date, subtype);
                    break;

                case "2":
                    System.out.println("   Occasions : Pre-debut | Prenup | Couple | Family | Group");
                    System.out.print("   Occasion  : ");
                    String occasion = sc.nextLine().trim();
                    System.out.print("   No. of Subjects: ");
                    int subjects = 1;
                    try {
                        subjects = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        subjects = 1;
                    }
                    service = new Portrait(name, date, occasion, subjects);
                    break;

                case "3":
                    System.out.println("   Categories: Product | Food | Fashion");
                    System.out.print("   Category : ");
                    String cat = sc.nextLine().trim();
                    service = new Commercial(name, date, cat);
                    break;

                default:
                    System.out.println("\n  [!] Invalid package choice.\n");
                    return;
            }

            BookingEntry entry = new BookingEntry(service, extra);
            entry.book();
            bookings.add(entry);

            System.out.println();
            System.out.println("  ==========================================");
            System.out.println("   Booking Confirmed! Here are the details:");
            System.out.println("  ==========================================");
            entry.showDetails();
            if (extra > 0) {
                System.out.printf("\n     Total (incl. %d extra hr(s)): P%.2f%n",
                        extra, service.calculateTotal(extra));
            } else {
                System.out.printf("\n     Total : P%.2f%n",
                        service.calculateTotal());
            }
            System.out.println("     Status: " + entry.getBookingStatus());
            System.out.println();

        } catch (IllegalArgumentException e) {
            System.out.println("\n  [!] Error: " + e.getMessage() + "\n");
        }
    }

    // ── View All Bookings ─────────────────────────────────────
    static void viewAllBookings() {
        System.out.println();
        if (bookings.isEmpty()) {
            System.out.println("  [!] No bookings yet.\n");
            return;
        }
        System.out.println("  ==========================================");
        System.out.println("                ALL BOOKINGS");
        System.out.println("  ==========================================");
        for (int i = 0; i < bookings.size(); i++) {
            BookingEntry e = bookings.get(i);
            PhotoshootService s = e.getService();
            System.out.printf("  [%d] %s%n", i + 1, s.getClientName());
            System.out.println("      Service : " + s.getServiceType());
            System.out.println("      Date    : " + s.getBookingDate());
            System.out.printf("      Total   : P%.2f%n", s.calculateTotal(e.getExtraHours()));
            System.out.println("      Status  : " + e.getBookingStatus());
            System.out.println();
        }
    }

    // ── View Receipt ──────────────────────────────────────────
    static void viewReceipt() {
        viewAllBookings();
        if (bookings.isEmpty())
            return;
        System.out.print("  Select booking number: ");
        try {
            int idx = Integer.parseInt(sc.nextLine().trim()) - 1;
            if (idx < 0 || idx >= bookings.size()) {
                System.out.println("  [!] Invalid selection.\n");
                return;
            }
            bookings.get(idx).showReceipt();
        } catch (NumberFormatException e) {
            System.out.println("  [!] Please enter a valid number.\n");
        }
    }

    // ── Cancel Booking ────────────────────────────────────────
    static void cancelBooking() {
        viewAllBookings();
        if (bookings.isEmpty())
            return;
        System.out.print("  Select booking number to cancel: ");
        try {
            int idx = Integer.parseInt(sc.nextLine().trim()) - 1;
            if (idx < 0 || idx >= bookings.size()) {
                System.out.println("  [!] Invalid selection.\n");
                return;
            }
            BookingEntry entry = bookings.get(idx);
            if (entry.getBookingStatus().equals("Cancelled")) {
                System.out.println("  [!] This booking is already cancelled.\n");
                return;
            }
            entry.cancel();
            System.out.println("  Booking for " + entry.getService().getClientName()
                    + " has been cancelled.\n");
        } catch (NumberFormatException e) {
            System.out.println("  [!] Please enter a valid number.\n");
        }
    }
}