/*
 *
 *  * Copyright (C) 2006 The Android Open Source Project
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.duy.ide.editor.core.view;

import android.os.Build;
import android.view.MotionEvent;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class MotionEventCompat {
    /**
     * Checks if a mouse or stylus button (or combination of buttons) is pressed.
     *
     * @param button Button (or combination of buttons).
     * @return True if specified buttons are pressed.
     * <p>
     * BUTTON_PRIMARY
     * BUTTON_SECONDARY
     * BUTTON_TERTIARY
     * BUTTON_FORWARD
     * BUTTON_BACK
     */
    public static boolean isButtonPressed(MotionEvent event, int button) {
        if (Build.VERSION.SDK_INT >= 21) {
            return event.isButtonPressed(button);
        }
        if (button == 0) {
            return false;
        }
        return (event.getButtonState() & button) == button;
    }
}