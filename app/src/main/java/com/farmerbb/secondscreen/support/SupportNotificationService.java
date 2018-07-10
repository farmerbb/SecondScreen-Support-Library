/* Copyright 2018 Braden Farmer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.farmerbb.secondscreen.support;

import android.app.Notification;

public class SupportNotificationService extends RotationLockService {

    private static int screenOrientation;

    public static void setScreenOrientation(int newScreenOrientation) {
        screenOrientation = newScreenOrientation;
    }

    @Override
    protected void startService() {
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_screen_lock_rotation)
                .setContentText(getString(R.string.locking_screen_orientation))
                .setPriority(Notification.PRIORITY_MIN);

        startForeground(1, builder.build());
    }

    @Override
    protected int getScreenOrientation() {
        return screenOrientation;
    }
}
