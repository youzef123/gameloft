package textGame;
import java.util.*;
import java.util.Random;

public class gameApix extends Exception{
	private static 	Scanner in = new Scanner(System.in);
	private String[] enemies = {"Gallego","Doc Jun","Badang","Lagura"};
	private String[] kanstaw = {"bayot","gago","piste","animal"};
	private int health;
	private int Maxenemyhealth;
	private int HPpotions,potionspts;
	private int attackdamage;
	private int kalabanDamage;
	private int kalabanDroptambal;
	private String dot;
	private String name;
	private String all;
	private Boolean running;
	private Random r = new Random();
		gameApix(){
			running = true;
			name="";
			health=100;
			Maxenemyhealth=100;
			HPpotions = 3;
			attackdamage = 75;
			kalabanDamage = 25;
			potionspts = 5;
			kalabanDroptambal = 50;
			dot=".";	
			all="";
		}
	
	public void run(){
		
		while(running){
		play();			
		}
	
	}
	public void play() {
		System.out.println("---------------------------------");
		String username="";
		String load="loading";
		System.out.print("Enter your name:");
		username=in.nextLine();
		setName(username);
		try{
			System.out.print(load);
			for(int i = 0;i<3;i++){
				dot+=dot;
				System.out.print(dot);		
			Thread.sleep(1000);
			}
			System.out.print("\nSuccessfuly login.");
			System.out.print("\n    Welcome sa dula "+getName()+".\n");
			ongame();		
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
		
	}
	public void ongame() {
		int enemyhp = r.nextInt(Maxenemyhealth);
		String enemy = enemies[r.nextInt(enemies.length)];	
		System.out.print("\n---------------------------------\n");
		System.out.print("Naay kalaban, Si sir "+enemy+"!\n");
		while(enemyhp>0){
			all="";
			all=("\n   Imong kinabuhi: ("+ health+")\n")
			+ ("   Ang kinabuhi ni "+ enemy +":("+enemyhp+")\n")
			+("---------------------------------")
			+("\n\tUnsa man imong buhaton?\n")
			+("  1 - Musukol ug kulatahon\n")
			+("  2 - Dungagan ang kinabuhi\n")
			+("  3 - Mudagan\n")
			+("Imong gipili: ");
			System.out.print(all);
			String option = in.nextLine();
			System.out.print("---------------------------------\n");
			
			all=""; //all outputs
			switch(option){
			
			case "1":
				int imongDamage = r.nextInt(attackdamage);
				int iyangDamage = r.nextInt(kalabanDamage);
				health -= iyangDamage;
				enemyhp -= imongDamage;
				all=("Paksitan si "+enemy+" ug: -> ["+imongDamage
						+"]\nNa paksitan kag --> [" + iyangDamage +"] na kinabuhi\n");
				break;
			case "2":
				if(HPpotions>0){
					  health+=potionspts;
					  HPpotions--;
					  all=("\n\t Nadungaggan imong life "
					  		+ "\n\t Naa nakay "+health+" na kinabuhi"
					  		+"\n\t imong nabilin na tambal kay "+HPpotions+"\n");
				}
				else
					all=("Wala nakay tambal"+
				"\npag patay ug kalaban para makakuha ka");
				break;
			case "3":
				System.out.println("Bayot ka nganong daganan man nimo si "+enemy);
				ongame();
				break;
			default:
				System.out.println("Invalid Command!");
				ongame();
				break;
			
			}
			System.out.print(all);
		}
		System.out.println("---------------------------------");
		String bewm = kanstaw[r.nextInt(kanstaw.length)];
		System.out.print("# Patay si " + enemy + " na "+ bewm +" #\n");
	
		if(r.nextInt(100)<kalabanDroptambal){
			HPpotions++;
			System.out.print(" # Naay natagak na tambal #\n");
			System.out.print(" # imong tambal na nabilin "+HPpotions+" #\n");
		}		
		if(health<1){System.out.print("Namatay ka "+getName()+" "+bewm+"\n");}
		System.out.println("---------------------------------");
		System.out.print("Unsa imong gusto buhaton "+getName()+"?\n");
		System.out.print(" \n1 - Mudula pa");
		System.out.print(" \n2 - Undang na");
		System.out.print("\nImong gipili:");
		String input = in.nextLine();
		while(!input.equals("1")&&!input.equals("2")) {
			System.out.println("Invalid input!");
			
		}
		if(input.equals("1")){		
			ongame();
		}
		else if(input.equals("2")){
			dot=".";
			System.out.print("\nSystem Exiting");
			try{
				for(int i = 0;i<3;i++){
					dot+=dot;
					System.out.print(dot);		
				Thread.sleep(1000);
				
				}
				running = false;
				System.exit(0);
			}
			catch(InterruptedException e){
				System.out.println(e);
			}
			
		
		}
	
		
}//on game terminate
			
	public void setName(String name){
	   this.name=name;
	}
	public String getName(){
		return name;
	}
	
	
}
