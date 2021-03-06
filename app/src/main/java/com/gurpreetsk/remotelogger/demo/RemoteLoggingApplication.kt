/*
 * Copyright (C) 2018 Gurpreet Singh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gurpreetsk.remotelogger.demo

import android.app.Application
import com.facebook.stetho.Stetho
import com.gurpreetsk.remotelogger.Duration
import com.gurpreetsk.remotelogger.RemoteLogger
import java.util.concurrent.TimeUnit

class RemoteLoggingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

        setupRemoteLogging()
    }

    private fun setupRemoteLogging() {
      RemoteLogger.initialize(
              this,
              "https://something.ngrok.io", // See https://ngrok.com
              "Gurpreet",
              jobInterval = Duration(20, TimeUnit.SECONDS)
      )
    }
}
