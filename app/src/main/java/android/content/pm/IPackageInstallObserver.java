// SPDX-FileCopyrightText: 2015-2016 Dominik Schürmann <dominik@dominikschuermann.de>
//
// SPDX-License-Identifier: Apache-2.0

package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * Just a non-working implementation of this Stub to satisfy compiler!
 */
public interface IPackageInstallObserver extends IInterface {

    abstract class Stub extends Binder implements android.content.pm.IPackageInstallObserver {

        public Stub() {
            throw new RuntimeException("Stub!");
        }

        public static android.content.pm.IPackageInstallObserver asInterface(IBinder obj) {
            throw new RuntimeException("Stub!");
        }

        public IBinder asBinder() {
            throw new RuntimeException("Stub!");
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags)
                throws RemoteException {
            throw new RuntimeException("Stub!");
        }
    }

    void packageInstalled(String packageName, int returnCode) throws RemoteException;
}
