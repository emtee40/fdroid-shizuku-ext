// SPDX-FileCopyrightText: 2016 Dominik Schürmann <dominik@dominikschuermann.de>
// SPDX-FileCopyrightText: 2018 Hans-Christoph Steiner <hans@eds.org>
//
// SPDX-License-Identifier: Apache-2.0

package org.fdroid.fdroid.privileged;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Pair;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashSet;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class AccessProtectionHelperTest {

    public static HashSet<Pair<String, String>> testCorrectWhitelist = new HashSet<>(Arrays.asList(
            // Android System Apps:
            new Pair<>("android", "c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8"),
            // Android included Apps:
            new Pair<>("com.android.camera", "a40da80a59d170caa950cf15c18c454d47a39b26989d8b640ecd745ba71bf5dc")
    ));

    public static HashSet<Pair<String, String>> testWrongWhitelist = new HashSet<>(Arrays.asList(
            // wrong package name
            new Pair<>("NOPE", "c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8")
    ));

    Instrumentation instrumentation;

    @Before
    public void setUp() {
        instrumentation = InstrumentationRegistry.getInstrumentation();
    }

    @Test
    public void testAccessAllowed() {
        AccessProtectionHelper accessProtectionHelper =
                new AccessProtectionHelper(instrumentation.getContext(), testCorrectWhitelist);

        // system app:
        assertTrue(accessProtectionHelper.isPackageAllowed("android"));
        // included app:
        assertTrue(accessProtectionHelper.isPackageAllowed("com.android.camera"));
    }

    @Test
    public void testAccessDisallowed() {
        // uses normal whitelist
        AccessProtectionHelper accessProtectionHelper =
                new AccessProtectionHelper(instrumentation.getContext());

        // system app:
        assertFalse(accessProtectionHelper.isPackageAllowed("android"));
        // included app:
        assertFalse(accessProtectionHelper.isPackageAllowed("com.android.camera"));
    }

    @Test
    public void testAccessWrongWhitelist() {
        // uses normal whitelist
        AccessProtectionHelper accessProtectionHelper =
                new AccessProtectionHelper(instrumentation.getContext(), testWrongWhitelist);

        // system app:
        assertFalse(accessProtectionHelper.isPackageAllowed("android"));
        // included app:
        assertFalse(accessProtectionHelper.isPackageAllowed("com.android.camera"));
    }

}
