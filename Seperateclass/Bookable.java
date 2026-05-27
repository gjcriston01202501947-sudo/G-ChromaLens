// ============================================================
//  ABSTRACTION — Interface
//  Defines a contract for all bookable services
// ============================================================
public interface Bookable {
    void book();
    void cancel();
    String getBookingStatus();
}
 