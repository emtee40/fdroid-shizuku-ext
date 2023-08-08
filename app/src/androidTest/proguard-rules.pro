# SPDX-FileCopyrightText: 2016 Dominik Schürmann <dominik@dominikschuermann.de>
#
# SPDX-License-Identifier: Apache-2.0

-dontwarn android.test.**
-dontwarn android.support.test.**
-dontnote junit.framework.**
-dontnote junit.runner.**

# Uncomment this if you use Mockito
#-dontwarn org.mockito.**

-keep class org.hamcrest.** { *; }
-dontwarn org.hamcrest.**

-keep class org.junit.** { *; }
-dontwarn org.junit.**

-keep class junit.** { *; }
-dontwarn junit.**
