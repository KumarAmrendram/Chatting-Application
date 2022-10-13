package ;
import java.util.*;

import javax.swing.*; //importing swing class from extended java for frontend
// import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
// import javax.swing.event.MouseInputAdapter;
// import javax.swing.plaf.FontUIResource;

import java.awt.*; //color class
import java.awt.event.*; //adding action listeners(event listeners)
import java.text.SimpleDateFormat;

public class Server extends JFrame implements ActionListener {

    JTextField textField;
    JPanel textArea;
    Box vertical = Box.createVerticalBox();

    Server() {
        // all of these are inbuilt methods of swing

        setLayout(null); // to set layout (images,grids,border etc)

        // panel(header)
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70); // setting panel dimension (start,end,width,height)
        p1.setLayout(null);
        add(p1);

        // setting back button
        {
            // back image icon
            ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("3.png"));
            Image img2 = img1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT); // to scale image
            ImageIcon img3 = new ImageIcon(img2); // converting image to ImageIcon
            JLabel back = new JLabel(img3); // to add images on panel
            back.setBounds(5, 20, 25, 25);
            p1.add(back);

            // listening action
            back.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent ae) {
                    System.exit(0);
                }
            });
        }

        // profile image
        {
            ImageIcon img4 = new ImageIcon(ClassLoader.getSystemResource("1.png"));
            Image img5 = img4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT); // to scale image
            ImageIcon img6 = new ImageIcon(img5); // converting image to ImageIcon
            JLabel profile = new JLabel(img6); // to add images on panel
            profile.setBounds(40, 10, 50, 50);
            p1.add(profile);
        }

        // video call button
        {
            ImageIcon img7 = new ImageIcon(ClassLoader.getSystemResource("video.png"));
            Image img8 = img7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT); // to scale image
            ImageIcon img9 = new ImageIcon(img8); // converting image to ImageIcon
            JLabel video = new JLabel(img9); // to add images on panel
            video.setBounds(300, 15, 30, 30);
            p1.add(video);
        }

        // call button
        {
            ImageIcon img10 = new ImageIcon(ClassLoader.getSystemResource("phone.png"));
            Image img11 = img10.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT); // to scale image
            ImageIcon img12 = new ImageIcon(img11); // converting image to ImageIcon
            JLabel phone = new JLabel(img12); // to add images on panel
            phone.setBounds(360, 15, 30, 30);
            p1.add(phone);
        }

        // menu button
        {
            ImageIcon img13 = new ImageIcon(ClassLoader.getSystemResource("3icon.png"));
            Image img14 = img13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT); // to scale image
            ImageIcon img15 = new ImageIcon(img14); // converting image to ImageIcon
            JLabel menu = new JLabel(img15); // to add images on panel
            menu.setBounds(420, 15, 10, 25);
            p1.add(menu);
        }

        // set name
        {
            JLabel name = new JLabel("Jon Snow");
            name.setBounds(110, 15, 100, 18);
            name.setForeground(Color.WHITE);
            name.setFont(new Font("Montserrat", Font.BOLD, 18)); // Font(font family,font style,size);
            p1.add(name);
        }

        // set active status
        {
            JLabel status = new JLabel("Active Now");
            status.setBounds(110, 35, 100, 18);
            status.setForeground(Color.WHITE);
            status.setFont(new Font("Montserrat", Font.BOLD, 12)); // Font(font family,font style,size);
            p1.add(status);
        }

        // set text panel
        {
            textArea = new JPanel();
            textArea.setBounds(0, 70, 450, 570);
            add(textArea);
        }

        // set text filed
        {
            textField = new JTextField();
            textField.setBounds(5, 645, 345, 50);
            textField.setFont(new Font("Montserrat", Font.BOLD, 15)); // Font(font family,font style,size);
            add(textField);
        }

        // send button
        {
            JButton sendButton = new JButton("send");
            sendButton.setBounds(350, 645, 99, 50);
            sendButton.setBackground(new Color(7, 94, 84));
            sendButton.setForeground(Color.WHITE);
            sendButton.addActionListener(this); // adds action to send button
            sendButton.setFont(new Font("Montserrat", Font.BOLD, 16)); // Font(font family,font style,size);
            add(sendButton);
        }

        setSize(450, 700); // to set the size of frame
        setLocation(100, 50); // set location of frame from origin(top left) setLocation(fromLeft, fromTop)
        setUndecorated(true); // to remove navigation buttons
        getContentPane().setBackground(Color.WHITE);
        setVisible(true); // to make visible default is false

    }

    public void actionPerformed(ActionEvent ae) {
        // actionPerformed in an abstract class in ActionListener so
        // we have to override it.

        String out = textField.getText();
        System.out.println(out);

        JPanel p2 = formatLabel(out);

        textArea.setLayout(new BorderLayout());
        JPanel right = new JPanel(new BorderLayout());
        right.add(p2, BorderLayout.LINE_END);
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(10));
        textArea.add(vertical, BorderLayout.PAGE_START);

        textField.setText("");

        repaint();
        invalidate();
        validate();
    }

    public static JPanel formatLabel(String out){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS ));

        JLabel output = new JLabel("<html><pstyle=\"width: 150px\">"  + out + "</pstyle=></html>");
        output.setFont(new Font("Montserrat", Font.BOLD, 16));
        output.setBackground(new Color(200,219,190));
        output.setOpaque(true);
        output.setBorder((new EmptyBorder(15,15,15,50)));
        
        panel.add(output);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm") ;
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);
        return panel;
    }

    public static void main(String args[]) {
        new Server();
    }
}