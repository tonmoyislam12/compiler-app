/*
 * Copyright 2018 Mr Duy
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

package com.duy.ccppcompiler.packagemanager;

import android.support.annotation.Nullable;

import java.io.File;

/**
 * Created by Duy on 20-May-18.
 */

public interface DownloadListener {
    void onComplete(File downloadedFile);

    void onFailure(@Nullable Exception e);

    void onProgress(int totalRead, int fileSize);
}