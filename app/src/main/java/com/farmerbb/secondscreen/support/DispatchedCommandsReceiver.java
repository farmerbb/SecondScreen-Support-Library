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

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DispatchedCommandsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent serviceIntent = new Intent(context, SupportNotificationService.class);
        context.stopService(serviceIntent);

        if(intent.hasExtra("screen_orientation")) {
            SupportNotificationService.setScreenOrientation(intent.getIntExtra("screen_orientation", -1));
            context.startService(serviceIntent);
        }

        if(intent.hasExtra("commands"))
            NonRootUtils.runCommands(context, intent.getStringArrayExtra("commands"));
    }
}
