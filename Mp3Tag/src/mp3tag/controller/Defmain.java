package mp3tag.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.*;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;

@SuppressWarnings("unused")
public class Defmain {

	public static void main(String[] args) throws IOException, TagException, Exception {

		File path = new File("D:\\803");

		File[] files = path.listFiles();

		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			System.out.print(i + " | ");
			File newFile = new File(path.getPath() + "\\" + ReadTags(f.getAbsolutePath()) + ".mp3");
			
			System.out.println(newFile);
			 files[i].renameTo(newFile);
		}
	}

	public static String ReadTags(String mp3_file) throws IOException, TagException, Exception {

		MP3File Mp3File = new MP3File(mp3_file);

		AbstractID3v2Tag tag = Mp3File.getID3v2Tag();

		// 歌曲名称
		String title = tag.getFirst(FieldKey.TITLE);
		// 艺术家
		String artist = tag.getFirst(FieldKey.ARTIST);
		// 专辑
		String author = tag.getFirst(FieldKey.ALBUM);

		// System.out.println(title);
		// System.out.println(artist);
		// System.out.println(author);

		return title;
	}
}
