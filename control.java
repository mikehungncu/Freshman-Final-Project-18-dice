package fp;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;



import javafx.scene.input.*;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class control implements Initializable{

	@FXML
    private Button dice;
	public static Button pButton;
    @FXML
    void act(ActionEvent event) {
	     
    	if(M==0) {
//    		try {
//    			player_dice= new MediaPlayer(new Media(FileSystems.getDefault().getPath("src","fp","001.m4a").toUri().toURL().toString()));
//    			player_dice.play();
//    		} catch (MalformedURLException e) {
//    			
//    			e.printStackTrace();
//    		};
    		screen.setText("下注拉");
    		return;
    	}
    	screen.clear();
    	cMoney.setText(String.valueOf(p1.getm()));
  	    yMoney.setText(String.valueOf(p2.getm()));
  	    if(turn==true) {
  	    	cPoint.clear();
  	    	yPoint.clear();
      	    
  	    }
  	    
	    dice(M,p1,p2);
	    
	    if(p1.getm()<=0 || p2.getm()<=0)
        {
	    	new Delay(3000);
        	endpane.setVisible(true);
        	if(p1.getm()<=0)
        	{
        		
        		endtext.setText(p2.getn()+"獲勝!");
        	}
        	else
        	{
        		
        		endtext.setText("電腦獲勝!");
        	}
        	
        }
    }
    @FXML
    private ImageView dice1;
    @FXML
    private ImageView dice2;

    @FXML
    private ImageView dice3;
    @FXML
    private Pane frame;
    

    @FXML
    private TextField yMoney;

    @FXML
    private TextField cMoney;

    @FXML
    private TextField pMoney;

    @FXML
    private TextField cPoint;

    @FXML
    private TextField yPoint;

    @FXML
    private TextArea screen;

    @FXML
    private TextField scan;
    
    @FXML
    private TextField cb;

    @FXML
    private TextField yb;
    
    @FXML
    private Pane endpane;

    @FXML
    private TextField endtext;
    
    @FXML
    private Button againbuttom;

    @FXML
    private Button closebuttom;
    
    @FXML
    private ImageView gg;
    @FXML
    void click(MouseEvent event) {
    	
    }
    Player p1,p2;
    @FXML
    void key(KeyEvent event) {
    	if(event.getCode().equals( KeyCode.ENTER)) {
    		M = Integer.parseInt(scan.getText());
      	   	if(M>p2.getm()) {
      	   		screen.setText("You don't have\nenough money");
      	   		scan.clear();
      	   		M=0;
      	   		return;
      	   	}
      	    
      	    pMoney.setText(scan.getText());
      	   	scan.clear();
      	   	scan.setEditable(false);
      	  screen.clear();
      	cMoney.setText(String.valueOf(p1.getm()));
    	    yMoney.setText(String.valueOf(p2.getm()));
    	    if(turn==true) {
    	    	cPoint.clear();
    	    	yPoint.clear();
        	    
    	    }
    	    
  	    dice(M,p1,p2);
  	  if(p1.getm()<=0 || p2.getm()<=0)
      {
  		new Delay(3000);
      	endpane.setVisible(true);
      	if(p1.getm()<=0)
      	{
      		
      		endtext.setText(p2.getn()+"獲勝!");
      	}
      	else
      	{
      		
      		endtext.setText("電腦獲勝!");
      	}
      	
      }
    	}    	
    }
    @FXML
    void key_name(KeyEvent event) {
    	if(event.getCode().equals( KeyCode.ENTER)) {    		
    		p2.setn(yb.getText());
    		yb.setEditable(false);
    	}
    }
    
    void dice(int m, Player p1,Player p2) {
    	Random rand=new Random();    	    	
    	int r1,r2,r3;
    	
    	while(true) {
    		r1=rand.nextInt(6)+1;
    		r2=rand.nextInt(6)+1;
    		r3=rand.nextInt(6)+1;
    		int[] rr=new int[3];
    		rr[0]=r1;
    		rr[1]=r2;
    		rr[2]=r3;    	
    		showdice(r1,r2,r3);
    		Arrays.sort(rr);
    		
    		if(r1==r2 && r2==r3) {
    			
      	        if(turn==true) {
      	        	cPoint.setText("豹子");
      	        	p1.setm(m);
      	        	p2.setm(m*-1);
      	        	screen.setText("computer win");
      	        }
      	        else {
      	        	yPoint.setText("豹子");
      	        	p1.setm(m*-1);
      	        	p2.setm(m);
      	        	screen.setText("you win");
      	        }
      	        
    	        cMoney.setText(String.valueOf(p1.getm()));
    	        yMoney.setText(String.valueOf(p2.getm()));
    	        M=0;
    	        pMoney.clear();
    	        scan.setEditable(true);
    	        
    	        break;
    		}
    		
    		else if(rr[0]==4 && rr[1]==5 && rr[2]==6) {
    			
      	        if(turn==true) {
    	        	cPoint.setText("骰規");
    	        	p1.setm(m);
    	        	p2.setm(m*-1);
    	        	screen.setText("computer win");
    	        }
    	        else {
    	        	yPoint.setText("骰規");
    	        	p1.setm(m*-1);
    	        	p2.setm(m);
    	        	screen.setText("you win");
    	        }     	          	  
  	            cMoney.setText(String.valueOf(p1.getm()));
  	            yMoney.setText(String.valueOf(p2.getm())); 
  	            M=0;
  	            pMoney.clear();
  	            scan.setEditable(true);
  	          
  	          break;
    		}
    		else if(rr[0]==1 && rr[1]==2 && rr[2]==3) {
    			      	        
      	        if(turn==true) {
  	        	cPoint.setText("逼機!");
  	        	p1.setm(m*-1);
  	        	p2.setm(m);
  	        	screen.setText("you win");
  	            }
      	        else {
  	        	yPoint.setText("逼機!");
  	        	p1.setm(m);
  	        	p2.setm(m*-1);
  	        	screen.setText("computer win");
      	        }     	          	 	  
  	            cMoney.setText(String.valueOf(p1.getm()));
  	            yMoney.setText(String.valueOf(p2.getm()));
  	            M=0;
	            pMoney.clear();
	            scan.setEditable(true);
	            
	            break;
    		}
    		else if(r1!=r2 && r2!=r3 && r1!=r3) {
    			
      	        
      	        if(turn==false) {
      	        	screen.setText("再骰一次");
      	        	break;
      	        }
      	        
      	        continue;
    		}
    		else {
    			if(turn==true) {
	    			                
	                if(r1==r2) {
	                	cdice=r3;
	                }
	                else if(r1==r3) {
	                	cdice=r2;
	                }
	                else {
	                	cdice=r1;
	                }   	    
	                cPoint.setText(String.valueOf(cdice));
	                screen.setText("your turn");
	                turn=false;
    			}
    			else {
    				
    				int ydice;
    				if(r1==r2) {
	                	ydice=r3;
	                }
	                else if(r1==r3) {
	                	ydice=r2;
	                }
	                else {
	                	ydice=r1;
	                }   	    
	                yPoint.setText(String.valueOf(ydice));
	                if(ydice>cdice) {
	                	screen.setText("you win");
	                	p1.setm(m*-1);
	      	        	p2.setm(m);
	      	        	cMoney.setText(String.valueOf(p1.getm()));
	      	            yMoney.setText(String.valueOf(p2.getm()));
	                }
	                else if(ydice<cdice) {
	                	screen.setText("computer win");
	                	p1.setm(m);
	      	        	p2.setm(m*-1);
	      	        	cMoney.setText(String.valueOf(p1.getm()));
	      	            yMoney.setText(String.valueOf(p2.getm()));
	                }
	                else {
	                	screen.setText("平手");
	                }
	                turn=true;
	                M=0;
	                scan.setEditable(true);
	  	            pMoney.clear();
	  	          
    			}
    		}
    		break;
    		}
    }
    void showdice(int s1,int s2,int s3) {
    	switch(s1) {
	        case 1:
	        	Image image1;
			try {
				image1 = new Image(FileSystems.getDefault().getPath("src","fp","dice1.jpg").toUri().toURL().toString());
				dice1.setImage(image1);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
	        	break;
	        case 2:
        	Image image2;
        	try {
				image2 = new Image(FileSystems.getDefault().getPath("src","fp","dice2.jpeg").toUri().toURL().toString());
				dice1.setImage(image2);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
        	break;
	        case 3:
        	Image image3;
        	try {
				image3 = new Image(FileSystems.getDefault().getPath("src","fp","dice3.jpeg").toUri().toURL().toString());
				dice1.setImage(image3);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
        	break;
	        case 4:
        	Image image4;
        	try {
				image4 = new Image(FileSystems.getDefault().getPath("src","fp","dice4.jpeg").toUri().toURL().toString());
				dice1.setImage(image4);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
        	break;
	        case 5:
        	Image image5;
        	try {
				image5 = new Image(FileSystems.getDefault().getPath("src","fp","dice5.jpeg").toUri().toURL().toString());
				dice1.setImage(image5);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
        	break;
	        case 6:
        	Image image6;
        	try {
				image6 = new Image(FileSystems.getDefault().getPath("src","fp","dice6.jpeg").toUri().toURL().toString());
				dice1.setImage(image6);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
        	break;
	        }
    	switch(s2) {
	        case 1:
	        	Image image1;
			try {
				image1 = new Image(FileSystems.getDefault().getPath("src","fp","dice1.jpg").toUri().toURL().toString());
				dice2.setImage(image1);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
	        	break;
	        case 2:
        	Image image2;
        	try {
				image2 = new Image(FileSystems.getDefault().getPath("src","fp","dice2.jpeg").toUri().toURL().toString());
				dice2.setImage(image2);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
        	break;
	        case 3:
        	Image image3;
        	try {
				image3 = new Image(FileSystems.getDefault().getPath("src","fp","dice3.jpeg").toUri().toURL().toString());
				dice2.setImage(image3);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
        	break;
	        case 4:
        	Image image4;
        	try {
				image4 = new Image(FileSystems.getDefault().getPath("src","fp","dice4.jpeg").toUri().toURL().toString());
				dice2.setImage(image4);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
        	break;
	        case 5:
        	Image image5;
        	try {
				image5 = new Image(FileSystems.getDefault().getPath("src","fp","dice5.jpeg").toUri().toURL().toString());
				dice2.setImage(image5);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
        	break;
	        case 6:
        	Image image6;
        	try {
				image6 = new Image(FileSystems.getDefault().getPath("src","fp","dice6.jpeg").toUri().toURL().toString());
				dice2.setImage(image6);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
        	break;
	        }
    	switch(s3) {
	        case 1:
	        	Image image1;
			try {
				image1 = new Image(FileSystems.getDefault().getPath("src","fp","dice1.jpg").toUri().toURL().toString());
				dice3.setImage(image1);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
	        	break;
	        case 2:
        	Image image2;
        	try {
				image2 = new Image(FileSystems.getDefault().getPath("src","fp","dice2.jpeg").toUri().toURL().toString());
				dice3.setImage(image2);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
        	break;
	        case 3:
        	Image image3;
        	try {
				image3 = new Image(FileSystems.getDefault().getPath("src","fp","dice3.jpeg").toUri().toURL().toString());
				dice3.setImage(image3);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
        	break;
	        case 4:
        	Image image4;
        	try {
				image4 = new Image(FileSystems.getDefault().getPath("src","fp","dice4.jpeg").toUri().toURL().toString());
				dice3.setImage(image4);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
        	break;
	        case 5:
        	Image image5;
        	try {
				image5 = new Image(FileSystems.getDefault().getPath("src","fp","dice5.jpeg").toUri().toURL().toString());
				dice3.setImage(image5);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
        	break;
	        case 6:
        	Image image6;
        	try {
				image6 = new Image(FileSystems.getDefault().getPath("src","fp","dice6.jpeg").toUri().toURL().toString());
				dice3.setImage(image6);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	        	
        	break;
	        }
    }

    @FXML
    void againpressed(ActionEvent event) {
    	p1.setM(1000);
    	p2.setM(1000);
    	p2.setn("you");
    	cMoney.setText(String.valueOf(p1.getm()));
	    yMoney.setText(String.valueOf(p2.getm()));
	    turn=true;
	    yb.clear();
	    yb.setEditable(true);
	    endpane.setVisible(false);
	    screen.clear();
	    yPoint.clear();
	    cPoint.clear();
	    pMoney.clear();
    }
    
    @FXML
    void closepressed(ActionEvent event) {
    	gg.setVisible(true);
    	try {
			player_dice= new MediaPlayer(new Media(FileSystems.getDefault().getPath("src","fp","ghost.mp3").toUri().toURL().toString()));
			player_dice.play();
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		};
		new Delay(5000);
    	//FP.currentStage.close();
    }
    public boolean turn;
    public int cdice,M;
    static MediaPlayer player_dice;
    @Override
    public void initialize(URL url,ResourceBundle rb) {
    	 
    	 p1=new Player("computer");
   	     p2=new Player("you");
   	     cb.setText("Boss");
   	     cMoney.setText(String.valueOf(p1.getm()));
	     yMoney.setText(String.valueOf(p2.getm()));
	     turn=true;
	     
	     
//	     try {
//			player_dice= new MediaPlayer(new Media(FileSystems.getDefault().getPath("src","fp","laugth.mp3").toUri().toURL().toString()));
//			player_dice.play();
//		} catch (MalformedURLException e) {
//			
//			e.printStackTrace();
//		};
//		new Delay(5000);
    }
}


