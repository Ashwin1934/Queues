import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.io.*;

public class WordFile{

	public WordFile(){
		File name = new File("WordFile.txt");
		Queue<Word> WQ = new LinkedList<>();
		try{
			BufferedReader input = new BufferedReader(new FileReader(name));
			String text;
			while((text=input.readLine())!=null){
				String[] words = text.split(" ");
				for(int i = 0;i<words.length;i++)
					WQ.add(new Word(words[i]));

			}
		}catch(IOException io){
			System.err.println("DNE");
		}

		System.out.println("Queue");
		for(Word word : WQ){
			System.out.print(word.toString()+" ");
		}
		System.out.println();

		PriorityQueue<Word> priorityQueue = new PriorityQueue<>();
		for(Word word: WQ){
			priorityQueue.add(word);
		}

		//reverse the order(use neg or poss in class to dictate a-z or z-a)

		System.out.println("PriorityQueue");
		while(!priorityQueue.isEmpty()){
			System.out.print(priorityQueue.poll().toString()+" ");
		}
        System.out.println();


	}

	public static void main(String []args){
		WordFile app = new WordFile();
	}
//	word
	public class Word implements Comparable<Word>{
		private String string;

		public Word(String string){
			this.string = string;
		}
		public String toString(){
			return string;
		}

		public int compareTo(Word word){
			int value = string.compareToIgnoreCase(word.toString());
			if(value<0)
				return 1;//z-a in priorityq, flip for reverse
			else if(value>0)
				return -1;
			else
				return 0;
		}


	}


}