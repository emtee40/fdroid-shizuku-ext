// SPDX-FileCopyrightText: 2016 The Android Open Source Project
//
// SPDX-License-Identifier: Apache-2.0

package org.fdroid.fdroid.privileged;

import android.annotation.TargetApi;

public final class IoUtils {
    private IoUtils() {
    }

    /**
     * Closes 'closeable', ignoring any checked exceptions. Does nothing if 'closeable' is null.
     */
    @TargetApi(24)
    public static void closeQuietly(AutoCloseable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException rethrown) {
                throw rethrown;
            } catch (Exception ignored) {
            }
        }
    }
}
