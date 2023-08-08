#!/usr/bin/env python3

# SPDX-FileCopyrightText: 2021 Hans-Christoph Steiner <hans@eds.org>
#
# SPDX-License-Identifier: Apache-2.0

import glob
import os

for f in glob.glob('metadata/*/*.txt') +  glob.glob('metadata/*/*/*.txt'):
    if os.path.getsize(f) == 0:
        os.remove(f)
        continue

    with open(f) as fp:
        data = fp.read()
    with open(f, 'w') as fp:
        fp.write(data.rstrip())
        fp.write('\n')
