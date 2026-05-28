// ============================================================
//  BookingEntry — Implements Bookable interface
//  Wraps any PhotoshootService and manages booking state
//  Demonstrates runtime dispatch via parent reference
// ============================================================
public class BookingEntry implements Bookable {
 
    // POLYMORPHISM — parent reference holds any subclass object
    private PhotoshootService service;
    private int extraHours;
 
    public BookingEntry(PhotoshootService service, int extraHours) {
        this.service    = service;
        this.extraHours = extraHours;
    }
 
    // ABSTRACTION — Bookable interface methods
    @Override
    public void book()   { service.setStatus("Confirmed"); }
 
    @Override
    public void cancel() { service.setStatus("Cancelled"); }
 
    @Override
    public String getBookingStatus() { return service.getStatus(); }
 
    // POLYMORPHISM — runtime dispatch: calls the correct subclass method
    public void showDetails() { service.displayServiceDetails(); }
    public void showReceipt() { service.printReceipt(extraHours); }
 
    public PhotoshootService getService()  { return service; }
    public int getExtraHours()             { return extraHours; }
}