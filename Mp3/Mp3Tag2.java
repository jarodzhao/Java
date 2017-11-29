import java.io.File;
import java.io.RandomAccessFile;
  
  public class Mp3Tag2 {

  private static final int TAG_SIZE = 128;
  private static final int TITLE_SIZE = 30;
  private static final int ARTIST_SIZE = 30;
  private static final int ALBUM_SIZE = 30;
  private static final int YEAR_SIZE = 4;
  private static final int COMMENT_SIZE = 29;
  private static final int TRACK_LOCATION = 126;
  private static final int GENRE_LOCATION = 127;
  private static final int MAX_GENRE = 255;
  private static final int MAX_TRACK = 255;
  private static final String ENC_TYPE = "Cp437";
  private static final String TAG_START = "TAG";
  
  public static void main(String[] args){
    try {
      File mp3 = new File("D://123.mp3");
      RandomAccessFile raf = new RandomAccessFile( mp3, "r" );
      raf.seek(raf.length() - TAG_SIZE);
      byte[] buf = new byte[TAG_SIZE];
      raf.read(buf, 0, TAG_SIZE);
      String tag = new String(buf, 0, TAG_SIZE, "Cp437");
      int start = TAG_START.length();
      System.out.println("fileName:" + mp3.getName());
      System.out.println("title:" + tag.substring(start, start += TITLE_SIZE).trim());
      System.out.println("article:" + tag.substring(start, start += ARTIST_SIZE).trim());
      raf.close();
      
      System.out.println("====================================");

      File mp32 = new File("D://320.mp3");
      raf = new RandomAccessFile( mp32, "r" );
      raf.seek(raf.length() - 128);
      raf.read(buf, 0, 128);
      tag = new String(buf, 0, 128, "Cp437");
      start = TAG_START.length();
      System.out.println("fileName" + mp32.getName());
      System.out.println("title:" + tag.substring(start, start += 30).trim());
      System.out.println("article:" + tag.substring(start, start += 30).trim());
      raf.close();
    } catch (Exception e) {
    }
  }
}