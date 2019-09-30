import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.io.*;

public class CarFormat{

	Stack<Car> CarS;
	Queue<Car> CarQ;
	PriorityQueue<Car> CarPQ;

	public CarFormat(){
		CarS = new Stack<Car>();
		CarQ = new LinkedList<>();
		CarPQ = new PriorityQueue<>();
		set("CarData.txt");
		output();

	}

	public void set(String name){
		File file  = new File(name);

		try{
			BufferedReader input = new BufferedReader(new FileReader(file));
			String text;
			int first,last;
			input.readLine();
			while((text=input.readLine())!=null){
				first = 0;
				last = text.indexOf("	");
				int ID = Integer.parseInt(text.substring(first,last));

				first = last+1;
				last = text.indexOf("	",first);
				int MPG = Integer.parseInt(text.substring(first,last));

				first = last+1;
				last = text.indexOf("	",first);
				int engineSize = Integer.parseInt(text.substring(first,last));

				first = last+1;
				last = text.indexOf("	",first);
				int horsePower = Integer.parseInt(text.substring(first,last));

				first = last+1;
				last = text.indexOf("	",first);
				int weight = Integer.parseInt(text.substring(first,last));

				first = last+1;
				last = text.indexOf("	",first);
				int accel = Integer.parseInt(text.substring(first,last));

				first = last+1;
				last = text.indexOf("	",first);
				String country = (text.substring(first,last));
				first  = last+1;
				last = first+1;
				int cylinders = Integer.parseInt(text.substring(first,last));

				Car car = new Car(accel,MPG,horsePower,engineSize,weight,cylinders,ID,country);

				CarS.add(car);
				CarQ.add(car);
				CarPQ.add(car);
			}
		}catch(IOException io){
			System.err.println("File does not exist");
		}
	}

	public void output(){
		System.out.println("Stack");
		while(!CarS.isEmpty()){
			System.out.println(CarS.pop().toString());
		}

		System.out.println("\n\n\nQueue");
		while(!CarQ.isEmpty()){
			System.out.println(CarQ.poll().toString());
		}

		System.out.println("\n\n\nPriorityQueue");
		while(!CarPQ.isEmpty()){
			System.out.println(CarPQ.poll().toString());
        }
	}


	public static void main(String [] args){
		CarFormat app = new CarFormat();
	}

	public class Car implements Comparable<Car>{

		private int acceleration;
		private int mpg;
		private int horsePower;
		private int engineSize;
		private int weight;
		private int cylinders;
		private int ID;
		private String country;

		public Car(int acc,int mpg,int hp,int es,int w,int cyl,int ID,String country){
			acceleration = acc;
			this.mpg = mpg;
			horsePower = hp;
			engineSize = es;
			weight = w;
			cylinders = cyl;
			this.ID = ID;
			this.country = country;
		}

		public int getAccel(){
			return acceleration;
		}
		public int getMPG(){
			return mpg;
		}
		public int getHP(){
			return horsePower;
		}
		public int getES(){
			return engineSize;
		}
		public int getW(){
			return weight;
		}
		public int getCyl(){
			return cylinders;
		}
		public int getID(){
			return ID;
		}
		public String getCountry(){
			return country;
		}

		public int compareTo(Car car){
			if(getAccel()>car.getAccel()){
				return -1;
			}else if(getAccel()<car.getAccel()){
				return 1;
			}

			if(getMPG()>car.getMPG()){
				return -1;
			}else if(getMPG()<car.getMPG()){
				return 1;
			}

			if(getHP()>car.getHP()){
				return -1;
			}else if(getHP()<car.getHP()){
				return 1;
			}

			if(getES()>car.getES()){
				return -1;
			}else if(getES()<car.getES()){
				return 1;
			}

			if(getW()>car.getW()){
				return -1;
			}else if(getW()<car.getW()){
				return 1;
			}

			if(getCyl()>car.getCyl()){
				return -1;
			}else if(getCyl()<car.getCyl()){
				return 1;
			}

			if(getID()>car.getID()){
				return -1;
			}else if(getID()<car.getID()){
				return 1;
			}

		return 0;
		}

		public String toString(){
			return "ID: "+ID+" MPG: "+mpg+" engineSize: "+engineSize+" horsePower: "+horsePower+" weight: "+weight+" acceleration: "+acceleration+ " country: "+country;
		}



	}

}
