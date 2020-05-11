package com.pku45a.difference.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.StreamCorruptedException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class Tool {
    public static boolean GotoPay = false;
    public static boolean PayResult = false;
    public static boolean Vip = false;
    public static String User_Id = "";
    public static String User_Name = "";
    public static String Phone = "";
    public static long Vip_Days = 0;
    public static long Vip_Time = 0;

    private static String sID = null;
    private static final String INSTALLATION = "INSTALLATION";
    private static final double EARTH_RADIUS = 6378137.0;
    public static double getDistance(double longitude,double latitue,double longitude2,double latitue2){
        double lat1 = rad(latitue);
        double lat2 = rad(latitue2);
        double a = lat1 - lat2;
        double b = rad(longitude)-rad(longitude2);
        double s = 2*Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(lat1)*Math.cos(lat2)*Math.pow(Math.sin(b/2),2)));
        s=s*EARTH_RADIUS;
        s=Math.round(s*10000)/10000;
        return s;
    }
    private static double rad(double d){
        return d*Math.PI/180.0;
    }

    public synchronized static String getUUID(Context context) {
        if (sID == null) {
            File installation = new File(context.getFilesDir(), INSTALLATION);
            try {
                if (!installation.exists()) {
                    FileOutputStream out = new FileOutputStream(installation);
                    String id = UUID.randomUUID().toString();
                    out.write(id.getBytes());
                    out.close();
                }
                RandomAccessFile f = new RandomAccessFile(installation, "r");
                byte[] bytes = new byte[(int) f.length()];
                f.readFully(bytes);
                f.close();
                sID = new String(bytes);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return sID;
    }
    /**
     * 使用SharedPreference保存序列化对象
     * 用Base64.encode将字节文件转换成Base64编码保存在String中
     *
     * @param context 上下文
     * @param key     储存对象的key
     * @param object  object对象  对象必须实现Serializable序列化，否则会出问题，
     *                out.writeObject 无法写入 Parcelable 序列化的对象
     */
    public static void setObject(Context context, String key, Object object) {
        SharedPreferences sp = context.getSharedPreferences("StarMap", Context.MODE_PRIVATE);
        sp.edit().remove(key).commit();
        //创建字节输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //创建字节对象输出流
        ObjectOutputStream out = null;
        try {
            //然后通过将字对象进行64转码，写入sp中
            out = new ObjectOutputStream(baos);
            out.writeObject(object);
            String objectValue = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(key, objectValue);
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }

                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取SharedPreference保存的对象
     * 使用Base64解密String，返回Object对象
     *
     * @param context 上下文
     * @param key     储存对象的key
     * @param <T>     泛型
     * @return 返回保存的对象
     */
    public static <T> T getObject(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("StarMap", Context.MODE_PRIVATE);
        if (sp.contains(key)) {
            String objectValue = sp.getString(key, null);
            byte[] buffer = Base64.decode(objectValue, Base64.DEFAULT);
            //一样通过读取字节流，创建字节流输入流，写入对象并作强制转换
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(bais);
                T t = (T) ois.readObject();
                return t;
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bais != null) {
                        bais.close();
                    }

                    if (ois != null) {
                        ois.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String getShowTime(String timeString) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = df.parse(timeString);
            Date nowDate = new Date();
            long diff = nowDate.getTime() - date.getTime();
            if(diff < 0) {
                return timeString;
            }

            long days = diff / (1000 * 60 * 60 * 24);
            if(days > 0) {
                String nowTimeString = df.format(nowDate);
                if(!timeString.substring(0, 3).equals(nowTimeString.substring(0, 3))) {
                    return timeString;
                }
                return days + "天前";
            }
            long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
            if(hours > 0) {
                return hours + "小时前";
            }
            long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
            if(minutes > 0) {
                return minutes + "分钟前";
            }
            return "刚刚";
        }
        catch(Exception e) {
            return timeString;
        }
    }
}
