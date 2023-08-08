// SPDX-FileCopyrightText: 2015-2016 Dominik Schürmann <dominik@dominikschuermann.de>
//
// SPDX-License-Identifier: Apache-2.0

package org.fdroid.fdroid.privileged;

interface IPrivilegedCallback {

    void handleResult(in String packageName, in int returnCode);

}
