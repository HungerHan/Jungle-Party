/**
 *  Task3.
 *  This class add click to remove
 *  image function
 *  Copyright: Copyright (c) 2017
 *  @author Zihan Zhang
 *  @version 1.0
 */

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class JungleParty extends JFrame
{
    //place image from "jungle"
    int rand1=10;
/**
 *  Constructor JungleParty
 */
    public JungleParty ()
    {
        JPanel p_animal=new JPanel(new GridLayout(2,5));//image panel
        JPanel p_word1=new JPanel(new FlowLayout(FlowLayout.CENTER));//Words panel 1
        JPanel p_word2=new JPanel(new FlowLayout(FlowLayout.CENTER));//Words panel 2
        JPanel p_text=new JPanel(new FlowLayout());//textfield panel
        JPanel p_check=new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel jp1=new JPanel(new BorderLayout());
        JPanel jp2=new JPanel(new BorderLayout());

        JButton jbtcheck=new JButton("Check!");//create button "check"
        JLabel jlbwelcome=new JLabel("How many animals have come to party?",JLabel.CENTER);  //label "how many"
        JLabel jlbclick=new JLabel("Click on animals you wish to kick out of the party!");   //label "click and remove
        jlbclick.setForeground(Color.RED);

        //radiobutton list 0~10
        ButtonGroup group=new ButtonGroup();
        JRadioButton jrb0=new JRadioButton("0");
        JRadioButton jrb1=new JRadioButton("1");
        JRadioButton jrb2=new JRadioButton("2");
        JRadioButton jrb3=new JRadioButton("3");
        JRadioButton jrb4=new JRadioButton("4");
        JRadioButton jrb5=new JRadioButton("5");
        JRadioButton jrb6=new JRadioButton("6");
        JRadioButton jrb7=new JRadioButton("7");
        JRadioButton jrb8=new JRadioButton("8");
        JRadioButton jrb9=new JRadioButton("9");
        JRadioButton jrb10=new JRadioButton("10");
        group.add(jrb0);
        group.add(jrb1);
        group.add(jrb2);
        group.add(jrb3);
        group.add(jrb4);
        group.add(jrb5);
        group.add(jrb6);
        group.add(jrb7);
        group.add(jrb8);
        group.add(jrb9);
        group.add(jrb10);

        //create array of image JLabel component
        JButton[] janimal=new JButton[10];
        janimal[0]=new JButton(new ImageIcon("jungle/animal1.png"));
        janimal[1]=new JButton(new ImageIcon("jungle/animal2.png"));
        janimal[2]=new JButton(new ImageIcon("jungle/animal3.png"));
        janimal[3]=new JButton(new ImageIcon("jungle/animal4.png"));
        janimal[4]=new JButton(new ImageIcon("jungle/animal5.png"));
        janimal[5]=new JButton(new ImageIcon("jungle/animal6.png"));
        janimal[6]=new JButton(new ImageIcon("jungle/animal7.png"));
        janimal[7]=new JButton(new ImageIcon("jungle/animal8.png"));
        janimal[8]=new JButton(new ImageIcon("jungle/animal9.png"));
        janimal[9]=new JButton(new ImageIcon("jungle/animal10.png"));

//******PANEL******//
        //1st Panel - insert image array
        for(int i=0;i<=9;i++)
        {
            p_animal.add(janimal[i]);
        }

        //2nd Panel
        p_word1.add(jlbwelcome);//insert label
        //3rd Panel
        p_word2.add(jlbclick);

        //4th Panel
        p_text.setSize(0, 10);
        p_text.add(jrb0);//insert textfield to panel
        p_text.add(jrb1);
        p_text.add(jrb2);
        p_text.add(jrb3);
        p_text.add(jrb4);
        p_text.add(jrb5);
        p_text.add(jrb6);
        p_text.add(jrb7);
        p_text.add(jrb8);
        p_text.add(jrb9);
        p_text.add(jrb10);

        //5th Panel
        p_check.setSize(0,10);
        p_check.add(jbtcheck);//insert "check"

        //main jp1
        jp1.add(p_animal,BorderLayout.NORTH);
        jp1.add(p_word1,BorderLayout.CENTER);
        jp1.add(p_word2,BorderLayout.SOUTH);
        //main jp2
        jp2.add(p_text,BorderLayout.NORTH);
        jp2.add(p_check,BorderLayout.SOUTH);
//^^^^^^PANEL END^^^^^^//


//******ActionListener for the "check"******//
        jbtcheck.addActionListener(new ActionListener()
                                   {
                                       @Override
                                       public void actionPerformed(ActionEvent e)
                                        {
                                            //which button has been selected?
                                            String text="";
                                            Enumeration<AbstractButton> radioBtns=group.getElements();
                                            while(radioBtns.hasMoreElements())
                                            {
                                                AbstractButton btn=radioBtns.nextElement();
                                                if(btn.isSelected())
                                                {
                                                    text=btn.getText();
                                                    break;
                                                }
                                            }

                                            //  1.If enter nothing
                                            if(text.equals(""))
                                                {

                                                }
                                            //  2.Normal enter
                                            else
                                            {
                                                int textnum=Integer.parseInt(text);
                                                group.clearSelection();

                                                //2-1.The correct answer
                                                if(textnum==rand1)
                                                {
                                                    p_animal.removeAll();
                                                    rand1=(int)((Math.random()*10)+1);//how many animals remain
                                                    jlbclick.setText("Click on animals you wish to kick out of the party!");

                                                    //method for random image inserted in frame
                                                    for(int i=0;i<rand1;i++)
                                                    {
                                                        p_animal.add(janimal[i]);
                                                        janimal[i].setVisible(true);
                                                    }
                                                    p_text.removeAll();
                                                    p_word1.removeAll();
                                                    JLabel jlbcorrect=new JLabel("Correct!How many animals are in the party now?",JLabel.CENTER);
                                                    p_word1.add(jlbcorrect);
                                                    p_text.add(jrb0);//insert textfield to panel
                                                    p_text.add(jrb1);
                                                    p_text.add(jrb2);
                                                    p_text.add(jrb3);
                                                    p_text.add(jrb4);
                                                    p_text.add(jrb5);
                                                    p_text.add(jrb6);
                                                    p_text.add(jrb7);
                                                    p_text.add(jrb8);
                                                    p_text.add(jrb9);
                                                    p_text.add(jrb10);
                                                    jp1.setVisible(false);
                                                    jp1.setVisible(true);
                                                }

                                                //2-2.The wrong answer
                                                else
                                                {
                                                    p_text.removeAll();
                                                    p_word1.removeAll();
                                                    JLabel jlbwrong=new JLabel("Wrong!Try again!",JLabel.CENTER);
                                                    p_word1.add(jlbwrong);
                                                    p_text.add(jrb0);//insert textfield to panel
                                                    p_text.add(jrb1);
                                                    p_text.add(jrb2);
                                                    p_text.add(jrb3);
                                                    p_text.add(jrb4);
                                                    p_text.add(jrb5);
                                                    p_text.add(jrb6);
                                                    p_text.add(jrb7);
                                                    p_text.add(jrb8);
                                                    p_text.add(jrb9);
                                                    p_text.add(jrb10);
                                                    jp1.setVisible(false);
                                                    jp1.setVisible(true);
                                                }
                                            }
                                        }
                                    }
                                   );
//^^^^^^ActionListener for the "check" END^^^^^^//

//******ActionListener for "click to remove"******//
        janimal[0].addActionListener(new ActionListener()
                                     {
                                         @Override
                                         public void actionPerformed(ActionEvent e)
                                        {
                                            janimal[0].setVisible(false);
                                            rand1--;
                                            jlbclick.setText("Animal gone! How many animals are in the party now?");
                                            }
                                     }
                                    );
        janimal[1].addActionListener(new ActionListener()
                                     {
                                         @Override
                                         public void actionPerformed(ActionEvent e)
                                        {
                                            janimal[1].setVisible(false);
                                            rand1--;
                                            jlbclick.setText("Animal gone! How many animals are in the party now?");
                                        }
                                     }
                                    );
        janimal[2].addActionListener(new ActionListener()
                                     {
                                         @Override
                                         public void actionPerformed(ActionEvent e)
                                        {
                                            janimal[2].setVisible(false);
                                            rand1--;
                                            jlbclick.setText("Animal gone! How many animals are in the party now?");
                                        }
                                     }
                                    );
        janimal[3].addActionListener(new ActionListener()
                                     {
                                         @Override
                                         public void actionPerformed(ActionEvent e)
                                        {
                                            janimal[3].setVisible(false);
                                            rand1--;
                                            jlbclick.setText("Animal gone! How many animals are in the party now?");
                                        }
                                     }
                                    );
        janimal[4].addActionListener(new ActionListener()
                                     {
                                         @Override
                                         public void actionPerformed(ActionEvent e)
                                        {
                                            janimal[4].setVisible(false);
                                            rand1--;
                                            jlbclick.setText("Animal gone! How many animals are in the party now?");
                                        }

                                     }
                                    );
        janimal[5].addActionListener(new ActionListener()
                                     {
                                         @Override
                                         public void actionPerformed(ActionEvent e)
                                        {
                                            janimal[5].setVisible(false);
                                            rand1--;
                                            jlbclick.setText("Animal gone! How many animals are in the party now?");
                                        }
                                     }
                                    );
        janimal[6].addActionListener(new ActionListener()
                                     {
                                         @Override
                                         public void actionPerformed(ActionEvent e)
                                        {
                                            janimal[6].setVisible(false);
                                            rand1--;
                                            jlbclick.setText("Animal gone! How many animals are in the party now?");
                                        }
                                     }
                                    );
        janimal[7].addActionListener(new ActionListener()
                                     {
                                         @Override
                                         public void actionPerformed(ActionEvent e)
                                        {
                                            janimal[7].setVisible(false);
                                            rand1--;
                                            jlbclick.setText("Animal gone! How many animals are in the party now?");
                                        }
                                     }
                                    );
        janimal[8].addActionListener(new ActionListener()
                                     {
                                         @Override
                                         public void actionPerformed(ActionEvent e)
                                        {
                                            janimal[8].setVisible(false);
                                            rand1--;
                                            jlbclick.setText("Animal gone! How many animals are in the party now?");
                                        }
                                     }
                                    );
        janimal[9].addActionListener(new ActionListener()
                                     {
                                         @Override
                                         public void actionPerformed(ActionEvent e)
                                        {
                                            janimal[9].setVisible(false);
                                            rand1--;
                                            jlbclick.setText("Animal gone! How many animals are in the party now?");
                                        }
                                     }
                                    );
//^^^^^^ActionListener for "click to remove" END^^^^^^//


        //set frame layout
        add(jp1,BorderLayout.NORTH);
        add(jp2,BorderLayout.SOUTH);

    }
    //^^^^^^JungleParty Constructor END^^^^^^//

/**
 *  A main method to JungleParty
 *  @param args is not used.
 */
    public static void main(String[] args)
    {
        JFrame frame=new JungleParty();
        //set title to centre
        frame.setFont(new Font("System", Font.PLAIN, 14));
        Font f = frame.getFont();
        FontMetrics fm = frame.getFontMetrics(f);
        int x = fm.stringWidth("Welcome to the Jungle Party!");
        int y = fm.stringWidth(" ");
        int z = frame.getWidth()/2 - (x/2);
        int w = z/y;
        String pad ="";
        pad = String.format("%"+w+"s", pad);
        frame.setTitle(pad+"Welcome to the Jungle Party!");

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}



