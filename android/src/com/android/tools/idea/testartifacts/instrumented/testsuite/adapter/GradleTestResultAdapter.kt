/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.tools.idea.testartifacts.instrumented.testsuite.adapter

import com.android.ddmlib.IDevice
import com.android.tools.idea.testartifacts.instrumented.testsuite.api.AndroidTestResultListener

/**
 * An adapter to parse instrumentation test result protobuf messages from AGP and forward them to AndroidTestResultListener
 */
class GradleTestResultAdapter(val deviceList: List<IDevice>, val listener: AndroidTestResultListener) {
  /**
   * Schedule test suite for selected devices when instrumentation tests are executed by AGP
   */
  fun scheduleTestSuite() {
    for (device in deviceList) {
      listener.onTestSuiteScheduled(convertIDeviceToAndroidDevice(device))
    }
  }
}