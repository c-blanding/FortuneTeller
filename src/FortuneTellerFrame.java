import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class FortuneTellerFrame extends JFrame {



    ArrayList<String> fortunes;
    int currentIndex = -1;
    JFrame frame = new JFrame();

    JPanel mainPnl;
    JPanel topPnl;
    JPanel middlePnl;
    JPanel bottomPnl;

    JButton fortuneBtn;
    JButton quitBtn;

    JTextArea textTa;
    JScrollPane scroller;

    JLabel topLbl;

    ImageIcon icon;

    public FortuneTellerFrame() {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(screenWidth / 4, screenHeight / 4);

        Image img = kit.getImage("src/img.png");



        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTopPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);
        createMiddlePanel();
        mainPnl.add(middlePnl, BorderLayout.CENTER);
        createBottomPanel();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);
        createFortunes();




        frame.setTitle("Fortune Teller");
        frame.setSize(screenWidth / 2, screenHeight / 2);
        frame.setLocation(screenWidth / 4, screenHeight / 4);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setIconImage(img);
        frame.add(mainPnl);
    }

    public void createTopPanel()
    {
        topPnl = new JPanel();
        icon = new ImageIcon("src/img.png");
        Image newIcon = icon.getImage();
        Image newing = newIcon.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newing);
        topLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        topLbl.setFont(new Font("Verdana", Font.PLAIN, 36));
        topPnl.add(topLbl);
    }

    public void createMiddlePanel()
    {
        middlePnl = new JPanel();
        textTa = new JTextArea("Click the button to get a fortune!", 15, 35);
        textTa.setEditable(false);
        scroller = new JScrollPane(textTa);
        middlePnl.add(scroller);



    }

    public void createBottomPanel()
    {
        bottomPnl = new JPanel();
        fortuneBtn = new JButton("Read my Fortune!");
        quitBtn = new JButton("Quit!");

        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        fortuneBtn.addActionListener((ActionEvent ae) -> newFortune());

        bottomPnl.add(fortuneBtn);
        bottomPnl.add(quitBtn);
    }

    public void createFortunes()
    {
        fortunes = new ArrayList<>();
        fortunes.add("There’s a new romance in your future. Remember to floss first.");
        fortunes.add("As long as you don’t do anything new, you’ll be fine.");
        fortunes.add("Success comes before work … only in the dictionary.");
        fortunes.add("Foolish man listen to heart. Wise man listen to the fortune teller.");
        fortunes.add("Error 404: Wisdom not found.");
        fortunes.add("Marriage: annoying one special person for the rest of your life.");
        fortunes.add("If you eat something and nobody sees you eat it, it has no calories.");
        fortunes.add("When working towards the solution of a problem, it always helps \nif you know the answer.");
        fortunes.add("Drive like hell, you will get there.");
        fortunes.add("Hard work pays off in the future. Laziness pays off now.");
        fortunes.add("Never do anything halfway.");
        fortunes.add("If at first you don’t succeed, skydiving is not for you.");
    }

    public String getFortune() {

        int index = (int)(Math.random() * fortunes.size());
        currentIndex = index;
        return fortunes.get(index);

    }

    public String getFortune(int index){

        int newIndex = (int)(Math.random() * fortunes.size());



        while (index == newIndex) {
            newIndex = (int)(Math.random() * fortunes.size());
        }

        currentIndex = newIndex;
        return fortunes.get(newIndex);

    }

    public void newFortune()
    {
        String fortune;

        if (currentIndex == -1)
        {
            fortune = getFortune();
        }
        else {
            fortune = getFortune(currentIndex);
        }

        textTa.setText(fortune);

    }


}
