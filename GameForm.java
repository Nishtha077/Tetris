package tetris;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class GameForm extends JFrame 
{   
    private GameArea ga;
    public GameForm()
    {
        initComponents();
        this.ga=new GameArea(gameAreaPlaceholder,10);
        this.add(ga);
        initControls();
        startGame();
    }
    private void initControls()
    {
        InputMap im = this.getRootPane().getInputMap();
        ActionMap am = this.getRootPane().getActionMap();
        
        im.put(KeyStroke.getKeyStroke("RIGHT"),"right");
        im.put(KeyStroke.getKeyStroke("LEFT"),"left");
        im.put(KeyStroke.getKeyStroke("UP"),"up");
        im.put(KeyStroke.getKeyStroke("DOWN"),"down");
        
//        class MyClass extends AbstractAction{} instead of this anonymous classes will be used.        
        am.put("right", new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                ga.moveBlockRight();
            }            
        });
        am.put("left", new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                ga.moveBlockLeft();
            }            
        });
        am.put("up", new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                ga.rotateBlock();
            }            
        });
        am.put("down", new AbstractAction() //Anonymous sub-class
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                ga.dropBlock();
            }            
        });
    }
    public void startGame()
    {
        new GameThread(ga,this).start();
    }
    public void updateScore(int score)
    {
        scoreDisplay.setText("Score: " + score);
    }
    public void updateLevel(int level)
    {
        levelDisplay.setText("Level: " + level);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jPanel1 = new javax.swing.JPanel();
        gameAreaPlaceholder = new javax.swing.JPanel();
        scoreDisplay = new javax.swing.JLabel();
        levelDisplay = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setResizable(false);

        gameAreaPlaceholder.setBackground(new java.awt.Color(102, 102, 102));
        gameAreaPlaceholder.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gameAreaPlaceholder.setForeground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout gameAreaPlaceholderLayout = new javax.swing.GroupLayout(gameAreaPlaceholder);
        gameAreaPlaceholder.setLayout(gameAreaPlaceholderLayout);
        gameAreaPlaceholderLayout.setHorizontalGroup(
            gameAreaPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 247, Short.MAX_VALUE)
        );
        gameAreaPlaceholderLayout.setVerticalGroup(
            gameAreaPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );

        scoreDisplay.setBackground(new java.awt.Color(255, 255, 255));
        scoreDisplay.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        scoreDisplay.setText("Score: 0");
        scoreDisplay.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        levelDisplay.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        levelDisplay.setText("Level: 1");
        levelDisplay.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(gameAreaPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scoreDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(levelDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gameAreaPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scoreDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(levelDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() //Runnable interface is being implemented anonymously
        {
            public void run() 
            {
                ImageIcon i1=new ImageIcon("C:\\Users\\MY\\JavaP\\GUI\\L1.png");
                GameForm GameForm_1=new GameForm();
                GameForm_1.setIconImage(i1.getImage());
                GameForm_1.setTitle("Tetris!");
                GameForm_1.setVisible(true);
                GameForm_1.getContentPane().setBackground(new Color(204,204,255));
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel gameAreaPlaceholder;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel levelDisplay;
    private javax.swing.JLabel scoreDisplay;
    // End of variables declaration                   
}
