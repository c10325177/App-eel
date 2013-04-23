/**************************************************************** **/
/** Amrouche Lucien ************************************************/
/** D12122738 ******************************************************/
/** this class allows you to add sound, allow only the format .wav */


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.AudioSystem;
import java.io.File;
 
 
public class Sound
{
    public static void readAudioFile(String fileName)
    {
    try
        {
    	//open the file chosen
        AudioInputStream music = AudioSystem.getAudioInputStream(new File(fileName));
        AudioFormat format = music.getFormat();
        Info info = new Info(SourceDataLine.class, format);
        SourceDataLine source = (SourceDataLine)AudioSystem.getLine(info);
        source.open(format);
        source.start();
        int read = 0;
        //specific to the format .wav
        byte[] audioData = new byte[16384];
        //read the file chosen
        while(read > -1)
            {
            read = music.read(audioData, 0 , audioData.length);
            if(read >= 0)
                source.write(audioData, 0, read);
            }
        source.drain();
        source.close();
        }
    catch(Exception e)
        {
        e.printStackTrace();
        }
 
    }
    

}
