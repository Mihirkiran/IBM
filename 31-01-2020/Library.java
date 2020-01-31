import java.util.Scanner;

abstract class Item{
	private int Identification;
	private int NumberOfCopies;
	private String Title;
	public int getIdentification(){
		return Identification;
	}
	public int getNumberOfCopies(){
		return NumberOfCopies;
	}
	public String getTitle(){
		return Title;
	}
	public void setIdentification(int a){
		this.Identification = a;
	}
	
	public void setNumberOfCopies(int a){
		this.NumberOfCopies = a;
	}
	
	public void setTitle(String a){
		this.Title = a;
	}
}

abstract class WrittenItem extends Item{
	private String Author;
	public String getAuthor(){
		return Author;
	}
	public void setAuthor(String a){
		this.Author = a;
	}

}

abstract class MediaItem extends Item{
	private int RunTime;
	public int getRunTime(){
		return RunTime;
	}
	public void setRunTime(int a){
		this.RunTime = a;
	}

}

class Book extends WrittenItem{

}

class JournalPaper extends WrittenItem{
	private int YearPublished;
	public int getYearPublished(){
		return YearPublished;
	}
	public void setYearPublished(int a){
		this.YearPublished = a;
	}
}

class Video extends MediaItem{
	private String Director;
	private String Genre;
	private int YearPublished;
	public String getDirector(){
		return Director;
	}
	public String getGenre(){
		return Genre;
	}
	public int getYearPublished(){
		return YearPublished;
	}
	public void setYearPublished(int a){
		this.YearPublished = a;
	}
	public void setDirector(String a){
		this.Director = a;
	}
	public void setGenre(String a){
		this.Genre = a;
	}
}

class CD extends MediaItem{
	private String Genre;
	private String Artist;
	public String getGenre(){
		return Genre;
	}
	public String getArtist(){
		return Artist;
	}
	public void setGenre(String a){
		this.Genre = a;
	}
	public void setArtist(String a){
		this.Artist = a;
	}
}

public class Library{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		Video a = new Video();
		// a[0].setYearPublished(2017);
		// a[0].setDirector("Rahul");
		// a[0].setGenre("Comedy");
		// a[0].setRunTime(172);
		// a[0].setIdentification(1);
		// a[0].setNumberOfCopies(5);
		// a[0].setTitle("ABC");
		// a[1].setYearPublished(2018);
		// a[1].setDirector("Rahul");
		// a[1].setGenre("Horror");
		// a[1].setRunTime(120);
		// a[1].setIdentification(2);
		// a[1].setNumberOfCopies(5);
		// a[1].setTitle("XYZ");
		// System.out.println("Enter the ID of the item:");
		// n = sc.nextInt();
		// for(int i = 0; i < 2; i++){
		// 	if(a[i].getIdentification() == n){
		// 	System.out.println("Identification:" + a[i].getIdentification());
		// 	System.out.println("Title: " + a[i].getTitle());
		// 	System.out.println("Number of copies: " + a[i].getNumberOfCopies());
		// 	System.out.println("Genre: " + a[i].getGenre());
		// 	System.out.println("Director: " + a[i].getDirector());
		// 	if(a[i].getNumberOfCopies() > 0){
		// 		System.out.println("Copies are avaliable");
		// 	}
		// 	else{
		// 		System.out.println("Copies are not avaliable");
		// 	}
		// }
		// }
		a.setYearPublished(2017);
		a.setDirector("Rahul");
		a.setGenre("Comedy");
		a.setRunTime(172);
		a.setIdentification(1);
		a.setNumberOfCopies(5);
		a.setTitle("ABC");
		System.out.println("Identification:" + a.getIdentification());
		System.out.println("Title: " + a.getTitle());
		System.out.println("Number of copies: " + a.getNumberOfCopies());
		System.out.println("Genre: " + a.getGenre());
		System.out.println("Director: " + a.getDirector());
		if(a.getNumberOfCopies() > 0){
			System.out.println("Copies are avaliable");
		}
		else{
			System.out.println("Copies are not avaliable");
		}
	}
}