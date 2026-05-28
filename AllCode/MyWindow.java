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
        mainPanel.add(userInfo(), "INFORMATION");
        
        
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
        box1.setBounds(40, 140, 380, 80);
        
        JPanel box2 = new JPanel();
        box2.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY, 2),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        box2.setBackground(Color.WHITE);
        box2.setBounds(40, 240, 380, 80);
        
        JPanel box3 = new JPanel();
        box3.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY, 2),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        box3.setBackground(Color.WHITE);
        box3.setBounds(40, 340, 380, 80);
        
        JLabel Package1 = new JLabel("Package 1");
        Package1.setFont(new Font("Arial", Font.BOLD, 14));
        
        box1.add(Package1);
        box1.add(Box.createVerticalStrut(10));
        box1.add(new JLabel("Service: Individual Portrait"));
        box1.add(new JLabel("Price: P500 "));
        box1.add(new JLabel("Time: 60 mins"));
        box1.add(new JLabel("Extension: +300/hr."));
        RoundedButton p1 = new RoundedButton("Select");
        p1.setBounds(440,155, 120, 40);
        p1.setBackground(new Color(0, 80, 0));
        p1.setForeground(Color.WHITE);
        p1.setPreferredSize(new Dimension(120, 40));
        p1.setFont(new Font("Arial", Font.PLAIN, 18));
        p1.setFocusPainted(false);
        p1.addActionListener(e -> {cardLayout.show(mainPanel, "MENU"); } );
        
        
        
        JLabel Package2 = new JLabel("Package 2");
        Package2.setFont(new Font("Arial", Font.BOLD, 14));
        
        box2.add(Package2);
        box2.add(Box.createVerticalStrut(10));
        box2.add(new JLabel("Service: Portrait"));
        box2.add(new JLabel("Price: P1,000 "));
        box2.add(new JLabel("Time: 120 mins"));
        box2.add(new JLabel("Extension: +500/hr."));
        RoundedButton p2 = new RoundedButton("Select");
        p2.setBounds(440,255, 120, 40);
        p2.setBackground(new Color(0, 80, 0));
        p2.setForeground(Color.WHITE);
        p2.setPreferredSize(new Dimension(120, 40));
        p2.setFont(new Font("Arial", Font.PLAIN, 18));
        p2.setFocusPainted(false);
        p2.addActionListener(e -> {cardLayout.show(mainPanel, "MENU"); } );
        
        JLabel Package3 = new JLabel("Package 3");
        Package3.setFont(new Font("Arial", Font.BOLD, 14));
        
        box3.add(Package3);
        box3.add(Box.createVerticalStrut(10));
        box3.add(new JLabel("Service: Portrait"));
        box3.add(new JLabel("Price: P1,000 "));
        box3.add(new JLabel("Time: 120 mins"));
        box3.add(new JLabel("Extension: +500/hr."));
        RoundedButton p3 = new RoundedButton("Select");
        p3.setBounds(440,355, 120, 40);
        p3.setBackground(new Color(0, 80, 0));
        p3.setForeground(Color.WHITE);
        p3.setPreferredSize(new Dimension(120, 40));
        p3.setFont(new Font("Arial", Font.PLAIN, 18));
        p3.setFocusPainted(false);
        p3.addActionListener(e -> {cardLayout.show(mainPanel, "MENU"); } );
        
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
        next.addActionListener(e -> {cardLayout.show(mainPanel, "INFORMATION"); } );
        
        panel.add(box1);
        panel.add(p1);
        panel.add(box2);
        panel.add(p2);
        panel.add(box3);
        panel.add(p3);
        panel.add(back);
        panel.add(next);
        
       return panel;   
   }
   
     private JPanel userInfo() {
        JPanel panel = new JPanel(null);
        
        JLabel title = new JLabel("Deatail Confirmation");
        panel.add(title);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(200,40, 280, 60);
        
        JPanel Mainbox = new JPanel();
        Mainbox.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY, 2),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        Mainbox.setBackground(Color.WHITE);
        Mainbox.setBounds(75, 130, 425, 480);
        Mainbox.setLayout(null);
        
        JLabel Label = new JLabel("Client's Information:");
        Label.setFont(new Font("Arial", Font.BOLD, 15));
        Label.setBounds(125,-5, 180, 60);
        Mainbox.add(Label);

        JPanel Subbox = new JPanel();
        Subbox.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY, 2),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        Subbox.setBackground(Color.WHITE);
        Subbox.setBounds(40, 60, 340, 140 );
        Subbox.setLayout(null);
        Mainbox.add(Subbox);
        
        JLabel clientLabel = new JLabel("Client's Name:");
        clientLabel.setBounds(20, 20, 140, 30);
        Subbox.add(clientLabel);
        
        JLabel dateLabel = new JLabel("Booking Date:");
        dateLabel.setBounds(20, 60, 140, 30);
        Subbox.add(dateLabel);
        
        JLabel ExtraLabel = new JLabel("Extra Hours:");
        ExtraLabel.setBounds(20, 100, 140, 30);
        Subbox.add(ExtraLabel);
                
        JPanel type1 = new JPanel();
        type1.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY, 2),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        type1.setBackground(Color.WHITE);
        type1.setBounds(150, 20, 150, 30);
        Subbox.add(type1); 
        
        JPanel type2 = new JPanel();
        type2.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY, 2),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        type2.setBackground(Color.WHITE);
        type2.setBounds(150, 60, 150, 30);
        Subbox.add(type2); 
        
        JPanel type3 = new JPanel();
        type3.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY, 2),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        type3.setBackground(Color.WHITE);
        type3.setBounds(150, 100, 150, 30);
        Subbox.add(type3);        
        
        JPanel Subbox1 = new JPanel();
        Subbox1.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY, 2),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        Subbox1.setBackground(Color.WHITE);
        Subbox1.setBounds(40, 210, 340, 200);
        Subbox1.setLayout(null);
        Mainbox.add(Subbox1);
        
        JLabel Types = new JLabel("Subtypes:");
        Types.setFont(new Font("Arial", Font.BOLD, 15));
        Types.setBounds(15,-15, 180, 60);
        Subbox1.add(Types);
        
        
        JPanel sub1 = new JPanel();
        sub1.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY, 2),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        sub1.setBackground(Color.WHITE);
        sub1.setBounds(15, 30, 90, 120);
        Subbox1.add(sub1);
        
        JLabel newborn = new JLabel("Newborn");
        newborn.setBounds(15, 30, 140, 30);
        sub1.add(newborn);

        JPanel sub2 = new JPanel();
        sub2.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY, 2),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        sub2.setBackground(Color.WHITE);
        sub2.setBounds(115, 30, 90, 120);
        Subbox1.add(sub2);        
        
        JLabel maternity = new JLabel("Maternity");
        maternity.setBounds(10, 10, 140, 30);
        sub2.add(maternity);
        
        JPanel sub3 = new JPanel();
        sub3.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY, 2),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        sub3.setBackground(Color.WHITE);
        sub3.setBounds(230, 30, 90, 120);
        Subbox1.add(sub3);
        
        JLabel funshoot = new JLabel("Funshoot");
        funshoot.setBounds(10, 10, 140, 30);
        sub3.add(funshoot);
        
        RoundedButton newb = new RoundedButton("Selected");
        newb.setBounds(15,160, 80, 30);
        newb.setBackground(new Color(0, 80, 0));
        newb.setForeground(Color.WHITE);
        newb.setPreferredSize(new Dimension(120, 40));
        newb.setFont(new Font("Arial", Font.PLAIN, 10));
        newb.setFocusPainted(false);
        newb.addActionListener(e -> {cardLayout.show(mainPanel, "MENU"); } );
        Subbox1.add(newb);
        
        RoundedButton mater = new RoundedButton("Selected");
        mater.setBounds(115,160, 80, 30);
        mater.setBackground(new Color(0, 80, 0));
        mater.setForeground(Color.WHITE);
        mater.setPreferredSize(new Dimension(120, 40));
        mater.setFont(new Font("Arial", Font.PLAIN, 10));
        mater.setFocusPainted(false);
        mater.addActionListener(e -> {cardLayout.show(mainPanel, "MENU"); } );
        Subbox1.add(mater);

        RoundedButton fun = new RoundedButton("Selected");
        fun.setBounds(230,160, 80, 30);
        fun.setBackground(new Color(0, 80, 0));
        fun.setForeground(Color.WHITE);
        fun.setPreferredSize(new Dimension(120, 40));
        fun.setFont(new Font("Arial", Font.PLAIN, 10));
        fun.setFocusPainted(false);
        fun.addActionListener(e -> {cardLayout.show(mainPanel, "MENU"); } );
        Subbox1.add(fun);  
        
        RoundedButton back = new RoundedButton("Back");
        back.setBounds(150,430, 70, 35);
        back.setBackground(new Color(0, 80, 0));
        back.setForeground(Color.WHITE);
        back.setPreferredSize(new Dimension(120, 40));
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setFocusPainted(false);
        back.addActionListener(e -> {cardLayout.show(mainPanel, "MENU"); } );
        Mainbox.add(back);
        
        RoundedButton next = new RoundedButton("Next");
        next.setBounds(300,430, 70, 35);
        next.setBackground(new Color(0, 80, 0));
        next.setForeground(Color.WHITE);
        next.setPreferredSize(new Dimension(120, 40));
        next.setFont(new Font("Arial", Font.PLAIN, 15));
        next.setFocusPainted(false);
        next.addActionListener(e -> {cardLayout.show(mainPanel, "INFORMATION"); } );
        Mainbox.add(next);
               
                        
        panel.add(Mainbox);

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