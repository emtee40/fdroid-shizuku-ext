#!/sbin/sh

# SPDX-FileCopyrightText: 2017 Roberto MF <roboe@virgulilla.com>
# SPDX-FileCopyrightText: 2017-2018 Chirayu Desai <chirayudesai1@gmail.com>
#
# SPDX-License-Identifier: Apache-2.0

#
# ADDOND_VERSION=2
#
# /system/addon.d/80-fdroid.sh
# During a system upgrade, this script backs up F-Droid client and privext,
# /system is formatted and reinstalled, then the files are restored.
#

. /tmp/backuptool.functions

list_files() {
cat <<EOF
app/F-Droid.apk
app/F-Droid/F-Droid.apk
etc/permissions/permissions_org.fdroid.fdroid.privileged.xml
priv-app/F-DroidPrivilegedExtension.apk
priv-app/F-DroidPrivilegedExtension/F-DroidPrivilegedExtension.apk
EOF
}

case "$1" in
  backup)
    list_files | while read FILE DUMMY; do
      backup_file $S/"$FILE"
    done
  ;;
  restore)
    list_files | while read FILE REPLACEMENT; do
      R=""
      [ -n "$REPLACEMENT" ] && R="$S/$REPLACEMENT"
      [ -f "$C/$S/$FILE" ] && restore_file $S/"$FILE" "$R"
    done
  ;;
  pre-backup)
    # Stub
  ;;
  post-backup)
    # Stub
  ;;
  pre-restore)
    # Stub
  ;;
  post-restore)
    # Stub
  ;;
esac
