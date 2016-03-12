package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Sound {

	
	public void playSound(String soundName) { //cộng đồng C việt
		   try {
			   File f = new File(soundName);
			   AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
			   Clip clip = AudioSystem.getClip( );
			   clip.open(audioInputStream);
			   clip.start( );
		   }
		   catch(Exception ex){
			   System.out.println(ex.getMessage());
			   ex.printStackTrace( );
		   }
	}
	
		
	public void readDigit(char i) throws IOException {
		String path = "C:/Users/NguyenDuc/Dropbox/PROGRAMING/PROJECT/QueueNumber/src/data/sound/" + Character.toString(i) + ".wav";
		playSound(path);
	}
	
	public void readNumber(String S) throws IOException {
		for (int i = 0; i < S.length(); i++) {
			readDigit(S.charAt(i));
		}
		
	}
	
	public void readInvite(int num, int i) throws IOException, InterruptedException {
		playSound("C:/Users/NguyenDuc/Dropbox/PROGRAMING/PROJECT/QueueNumber/src/data/sound/invite.wav");
		Thread.sleep(2000);
		readNumber(Integer.toString(num));
		Thread.sleep(400);
		playSound("C:/Users/NguyenDuc/Dropbox/PROGRAMING/PROJECT/QueueNumber/src/data/sound/goto.wav");
		Thread.sleep(1500);
		readNumber(Integer.toString(i));
		Thread.sleep(400);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
