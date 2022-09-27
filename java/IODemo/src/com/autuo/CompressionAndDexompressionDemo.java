package com.autuo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class CompressionAndDexompressionDemo {
	
	private static void compression(String zipFileName, File targetFile) {
		System.out.println("正在压缩......");
		try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
			BufferedOutputStream bos = new BufferedOutputStream(out);
			zip(out, targetFile, targetFile.getName(), bos);
			bos.close();
			out.close(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("压缩完成");
	}
	
	private static void zip(ZipOutputStream zOut, File targetFile, String name, BufferedOutputStream bos) throws IOException {
		if (targetFile.isDirectory()) {
			File[] files = targetFile.listFiles();
			if (files.length == 0) {//空文件夹
				zOut.putNextEntry(new ZipEntry(name+"/"));
			}
			for (File f:files) {
				zip(zOut, f, name + "/" + f.getName(), bos);
			}
		} else {
			zOut.putNextEntry(new ZipEntry(name));
			InputStream in = new FileInputStream(targetFile);
			BufferedInputStream bis = new BufferedInputStream(in);
			byte[] bytes = new byte[1024];
			int len = -1;
			while ((len = bis.read(bytes)) != -1) {
				bos.write(bytes, 0, len);
			}
			bis.close();
		}
	}

	private static void deCompression(String targetFileName, String parent) {
		try {
			ZipInputStream zIn = new ZipInputStream(new FileInputStream(targetFileName));
			ZipEntry entry = null;
			File file = null;
			while ((entry = zIn.getNextEntry()) != null && !entry.isDirectory()) {
				file = new File(parent, entry.getName());
				if (!file.exists()) {
					new File(file.getParent()).mkdirs();
				}
				OutputStream out = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				byte[] bytes = new byte[1024];
				int len = -1;
				while((len = zIn.read(bytes)) != -1) {
					bos.write(bytes, 0, len);
				}
				bos.close();
				System.out.println(file.getAbsolutePath() + "解压成功");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		//
		compression("E:/text.zip", new File("E:/text"));
		deCompression("E:/text.zip", "E:/");
	}

}
