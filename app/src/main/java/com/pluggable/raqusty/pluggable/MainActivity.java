package com.pluggable.raqusty.pluggable;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import dalvik.system.DexClassLoader;

public class MainActivity extends AppCompatActivity {

    TextView textView1, textView2, textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        textView3 = findViewById(R.id.text3);
        textView4 = findViewById(R.id.text4);//asdf


        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isBindService) {
                    Intent intent = new Intent(v.getContext(), MainService.class);
                    intent.putExtra("" +
                            "" +
                            "" +
                            "" +
                            "" +
                            "" +
                            "from", "ActivityA");
                    bindService(intent, conn, BIND_AUTO_CREATE);
                    isBindService = true;
                }
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBindService) {
                    unbindService(conn);
                    isBindService = false;
                }
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "这是一个bug", Toast.LENGTH_LONG).show();
//                Toast.makeText(MainActivity.this, "我来自另一个dex文件", Toast.LENGTH_LONG).show();
            }
        });

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDexClass();
            }
        });

    }

    boolean isBindService = false;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binderProxy) {
            try {
                // 将Service传过来的IBinder转化成IPlusService
                IPlusService plusServiceProxy = IPlusService.Stub.asInterface(binderProxy);
                // 调用add()并同步得到结果
                int result = plusServiceProxy.add(1, 2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

        @Override
        public void onBindingDied(ComponentName name) {

        }

    };

    private void loadDexClass() {
        String dexName = "classes.dex";
        File cacheFile = getDir("dex", 0);
        String sdcardPath = Environment.getExternalStoragePublicDirectory("").getAbsolutePath() + "/pluggable/" + dexName;
        File newDexFile = new File(sdcardPath);

        String internalPath = cacheFile.getAbsolutePath() + File.separator + dexName;
        File desFile = new File(internalPath);
        if (!newDexFile.exists())
            return;

        try {
            if (!desFile.exists() || !desFile.equals(newDexFile)) {
                if (desFile.exists())
                    desFile.delete();
                desFile.createNewFile();
                FileUtils.copyFiles(newDexFile, desFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //下面开始加载dex class
        //1.待加载的dex文件路径，如果是外存路径，一定要加上读外存文件的权限,
        //2.解压后的dex存放位置，此位置一定要是可读写且仅该应用可读写
        //3.指向包含本地库(so)的文件夹路径，可以设为null
        //4.父级类加载器，一般可以通过Context.getClassLoader获取到，也可以通过ClassLoader.getSystemClassLoader()取到。
        DexClassLoader dexClassLoader = new DexClassLoader(internalPath, desFile.getAbsolutePath(), null, getClassLoader());
        try {
            //该name就是internalPath路径下的dex文件里面的ShowToastImpl这个类的包名+类名
            Class<?> clz = dexClassLoader.loadClass("com.pluggable.raqusty.pluggable.DexTest");
            DexTest impl = (DexTest) clz.newInstance();//通过该方法得到IShowToast类
            if (impl != null) {
                Toast.makeText(MainActivity.this, impl.getText(), Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
