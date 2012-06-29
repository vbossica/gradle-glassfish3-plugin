/*
 * Copyright 2011-2012 Vladimir Ritz Bossicard
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
package org.vbossica.gradlebox

import org.gradle.api.InvalidUserDataException

/**
 * @author vladimir
 */
class ProjectUtils {

  def static verify(Object obj, String name) {
    if (obj == null) {
      throw new InvalidUserDataException("${name} must be specified")
    }
  }

  def static verifyDirectory(File dir, String name) {
    if (dir == null) {
      throw new InvalidUserDataException("${name} must be specified")
    }
    if (!dir.exists()) {
      throw new InvalidUserDataException("${name} must exist")
    }
  }

}
