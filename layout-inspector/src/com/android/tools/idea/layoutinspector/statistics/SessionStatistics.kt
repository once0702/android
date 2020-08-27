/*
 * Copyright (C) 2020 The Android Open Source Project
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
package com.android.tools.idea.layoutinspector.statistics

import com.google.wireless.android.sdk.stats.DynamicLayoutInspectorSession

/**
 * Accumulators for various actions of interest.
 */
class SessionStatistics {
  val live = LiveModeStatistics()
  val rotation = RotationStatistics()

  fun start(isCapturing: Boolean) {
    live.start(isCapturing)
    rotation.start()
  }

  fun save(data: DynamicLayoutInspectorSession.Builder) {
    live.save(data.liveBuilder)
    rotation.save(data.rotationBuilder)
  }

  fun selectionMadeFromImage() {
    live.selectionMade()
    rotation.selectionMadeFromImage()
  }

  fun selectionMadeFromComponentTree() {
    live.selectionMade()
    rotation.selectionMadeFromComponentTree()
  }
}