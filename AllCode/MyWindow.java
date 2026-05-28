import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {


    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);

    public MyWindow() {
    
        setTitle("Gerose's Window");
        setSize(600, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        mainPanel.add(homeScreen(), "HOME");
        mainPanel.add(mainMenuScreen(), "MENU");
        mainPanel.add(booking(), "BOOK");
        mainPanel.add(viewbook(), "VIEW");
        mainPanel.add(viewreciept(), "RECIEPT");

        cardLayout.show(mainPanel, "HOME");
        setContentPane(mainPanel);
        setVisible(true);
    }
    
    private JPanel homeScreen() {
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);
        
        ImageIcon imageIcon = new ImageIcon("Assets/GEROSE_LOGO.png");
        
        Image img = imageIcon.getImage();
        Image scaledImg = img.getScaledInstance(600, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(0,0, 600, 400);
        
        RoundedButton Startbutton = new RoundedButton("Book a Session");
        Startbutton.setBounds(212,460, 180, 60);
        Startbutton.setBackground(new Color(0, 80, 0));
        Startbutton.setForeground(Color.WHITE);
        
        Startbutton.setPreferredSize(new Dimension(120, 40));
        Startbutton.setFont(new Font("Arial", Font.PLAIN, 12));
        Startbutton.setFocusPainted(false);
        Startbutton.addActionListener(e -> {  cardLayout.show(mainPanel, "MENU"); });
        
        panel.setLayout(null);
        panel.add(imageLabel);
        panel.add(Startbutton);

        return panel;
    }
    
    private JPanel mainMenuScreen() {
        JPanel panel = new JPanel();
   //   panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel title = new JLabel("Main Menu");
        panel.add(title);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(225,100, 280, 60);
       
        
        
        RoundedButton book = new RoundedButton("Book a Service");
   //   book.setAlignmentX(Component.CENTER_ALIGNMENT);
        book.setBounds(210,200, 180, 60);
        book.setBackground(new Color(0, 80, 0));
        book.setForeground(Color.WHITE);
        book.setPreferredSize(new Dimension(120, 40));
        book.setFont(new Font("Arial", Font.PLAIN, 18));
        book.setFocusPainted(false);
        book.addActionListener(e -> {cardLayout.show(mainPanel, "BOOK"); } );
        
        RoundedButton view = new RoundedButton("View Bookings");
   //   view.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.setBounds(210,270, 180, 60);
        view.setBackground(new Color(0, 80, 0));
        view.setForeground(Color.WHITE);
        view.setPreferredSize(new Dimension(120, 40));
        view.setFont(new Font("Arial", Font.PLAIN, 18));
        view.setFocusPainted(false);
        view.addActionListener(e -> {cardLayout.show(mainPanel, "VIEW"); } );
        
        RoundedButton receipt = new RoundedButton("View Receipt");
   //   receipt.setAlignmentX(Component.CENTER_ALIGNMENT);
        receipt.setBounds(210,340, 180, 60);
        receipt.setBackground(new Color(0, 80, 0));
        receipt.setForeground(Color.WHITE);
        receipt.setPreferredSize(new Dimension(120, 40));
        receipt.setFont(new Font("Arial", Font.PLAIN, 18));
        receipt.setFocusPainted(false);
        receipt.addActionListener(e -> {cardLayout.show(mainPanel, "RECIEPT"); } );
           
        RoundedButton cancel = new RoundedButton("Cancel Booking");
   //   cancel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancel.setBounds(210,410, 180, 60);
        cancel.setBackground(new Color(0, 80, 0));
        cancel.setForeground(Color.WHITE);
        cancel.setPreferredSize(new Dimension(120, 40));
        cancel.setFont(new Font("Arial", Font.PLAIN, 18));
        cancel.setFocusPainted(false);
                
        RoundedButton exit = new RoundedButton("Exit");
   //   exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setBounds(212,480, 180, 60);
        exit.setBackground(new Color(0, 80, 0));
        exit.setForeground(Color.WHITE);
        exit.setPreferredSize(new Dimension(120, 40));
        exit.setFont(new Font("Arial", Font.PLAIN, 18));
        exit.setFocusPainted(false);
        exit.addActionListener(e -> {   System.exit(0); } );        
        
        panel.setLayout(null);
        panel.add(book);
        panel.add(view);
        panel.add(receipt);
        panel.add(cancel);
        panel.add(exit);

      return panel;
    }
    
    private JPanel booking() {
        JPanel panel = new JPanel(null);
  
        JLabel title = new JLabel("SELECT A PACKAGE");
        panel.add(title);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(200,80, 280, 60);
        
        
        JPanel box1 = new JPanel();
        box1.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY, 2),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        box1.setBackground(Color.WHITE);
        box1.setBounds(100, 140, 400, 80);
        
        JPanel box2 = new JPanel();
        box2.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY, 2),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        box2.setBackground(Color.WHITE);
        box2.setBounds(100, 240, 400, 80);
        
        JPanel box3 = new JPanel();
        box3.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY, 2),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        box3.setBackground(Color.WHITE);
        box3.setBounds(100, 340, 400, 80);
        
        JLabel Package1 = new JLabel("Package 1");
        Package1.setFont(new Font("Arial", Font.BOLD, 14));
        
        box1.add(Package1);
        box1.add(Box.createVerticalStrut(10));
        box1.add(new JLabel("Service: Individual Portrait"));
        box1.add(new JLabel("Price: P500 "));
        box1.add(new JLabel("Time: 60 mins"));
        box1.add(new JLabel("Extension: +300/hr."));
        RoundedButton p1 = new RoundedButton("Select");
        
        
        JLabel Package2 = new JLabel("Package 2");
        Package2.setFont(new Font("Arial", Font.BOLD, 14));
        
        box2.add(Package2);
        box2.add(Box.createVerticalStrut(10));
        box2.add(new JLabel("Service: Portrait"));
        box2.add(new JLabel("Price: P1,000 "));
        box2.add(new JLabel("Time: 120 mins"));
        box2.add(new JLabel("Extension: +500/hr."));
        RoundedButton p2 = new RoundedButton("Select");
        
        JLabel Package3 = new JLabel("Package 3");
        Package3.setFont(new Font("Arial", Font.BOLD, 14));
        
        box3.add(Package3);
        box3.add(Box.createVerticalStrut(10));
        box3.add(new JLabel("Service: Portrait"));
        box3.add(new JLabel("Price: P1,000 "));
        box3.add(new JLabel("Time: 120 mins"));
        box3.add(new JLabel("Extension: +500/hr."));
        RoundedButton p3 = new RoundedButton("Select");
        
        RoundedButton back = new RoundedButton("Back");
        back.setBounds(105,500, 180, 60);
        back.setBackground(new Color(0, 80, 0));
        back.setForeground(Color.WHITE);
        back.setPreferredSize(new Dimension(120, 40));
        back.setFont(new Font("Arial", Font.PLAIN, 18));
        back.setFocusPainted(false);
        back.addActionListener(e -> {cardLayout.show(mainPanel, "MENU"); } );
        
        RoundedButton next = new RoundedButton("Next");
        next.setBounds(315,500, 180, 60);
        next.setBackground(new Color(0, 80, 0));
        next.setForeground(Color.WHITE);
        next.setPreferredSize(new Dimension(120, 40));
        next.setFont(new Font("Arial", Font.PLAIN, 18));
        next.setFocusPainted(false);
        next.addActionListener(e -> {cardLayout.show(mainPanel, "MENU"); } );
        
        panel.add(box1);
        panel.add(box2);
        panel.add(box3);
        panel.add(back);
        panel.add(next);
        
       return panel;   
   }
   
     private JPanel viewbook() {
        JPanel panel = new JPanel(null);
  
        JLabel title = new JLabel("VIEW ALL BOOKING");
        panel.add(title);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(200,100, 280, 60);
        
        
        
        
       return panel;   
   }
      
     private JPanel viewreciept() {
        JPanel panel = new JPanel(null);
  
        panel.add(new JLabel("SELECT A PACKAGE"));
        
        
        
        
       return panel;   
   }


     class RoundedButton extends JButton {

        public RoundedButton(String text) {
            super(text);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
        }

      
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            if (getModel().isPressed()) {
                g2.setColor(new Color(0, 50, 0));
            } else {
                g2.setColor(getBackground());
            }

            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);

            super.paintComponent(g2);
            g2.dispose();
        }
    }
}