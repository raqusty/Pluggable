package com.pluggable.raqusty.pluggable;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        textView3 = findViewById(R.id.text3);


        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isBindService){
                    Intent intent = new Intent(v.getContext(), MainService.class);
                    intent.putExtra("from", "ActivityA");
                    bindService(intent, conn, BIND_AUTO_CREATE);
                    isBindService = true;
                }
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBindService){
                    unbindService( conn);
                    isBindService = false;
                }
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                Log.i("linzehao", "result " + result);
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
}
