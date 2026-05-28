// ============================================================
//  GChromaLensSystem.java — Main Entry Point
//  G ChromaLens Photoshoot Booking System
//  Final Machine Problem — OOP in Java
// ============================================================

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GChromaLensSystem {

   static Scanner sc       = new Scanner(System.in);
   static List<BookingEntry> bookings = new ArrayList<>();

   public static void main(String[] args) {
   
      new MyWindow();
      printBanner();
      boolean running = true;
      while (running) {
         printMainMenu();
         String choice = sc.nextLine().trim();
         switch (choice) {
            case "1": bookService();     
               break;
            case "2": viewAllBookings(); 
               break;
            case "3": viewReceipt();     
               break;
            case "4": cancelBooking();   
               break;
            case "5": running = false;   
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
      System.out.println("         G  C H R O M A L E N S");
      System.out.println("       Photoshoot Booking System v1.0");
      System.out.println("  ==========================================");
      System.out.println("    capturing faces, framing emotion");
      System.out.println("    Contact: +63 906 586 4651");
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
      try { extra = Integer.parseInt(sc.nextLine().trim()); }
      catch (NumberFormatException e) { extra = 0; }
   
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
               try { subjects = Integer.parseInt(sc.nextLine().trim()); }
               catch (NumberFormatException e) { subjects = 1; }
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
         entry.book(); // sets status to Confirmed
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
         System.out.printf ("      Total   : P%.2f%n", s.calculateTotal(e.getExtraHours()));
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