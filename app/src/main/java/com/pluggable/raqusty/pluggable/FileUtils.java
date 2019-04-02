package com.pluggable.raqusty.pluggable;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by linzehao on 19-3-25.
 * 将assets文件copy到app/data/cache目录
 */
public class FileUtils {

    public static void copyFiles( File inputFile, File desFile) {
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(inputFile.getAbsolutePath());
            out = new FileOutputStream(desFile.getAbsolutePath());
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = in.read(bytes)) != -1)
                out.write(bytes, 0, len);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}