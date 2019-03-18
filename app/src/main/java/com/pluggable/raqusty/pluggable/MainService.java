package com.pluggable.raqusty.pluggable;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * Created by linzehao on 19-3-14.
 * INFO:
 */

public class MainService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return new PlusServiceImpl();
    }
    public class PlusServiceImpl extends IPlusService.Stub {
        @Override
        public int add(int a, int b) throws RemoteException {
            return a + b;
        }
    }
}