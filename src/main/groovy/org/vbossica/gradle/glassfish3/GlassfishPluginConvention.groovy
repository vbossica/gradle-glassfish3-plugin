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
package org.vbossica.gradle.glassfish3

/**
 * @author vladimir
 */
class GlassfishPluginConvention {

  File asadminExec
  String userName = 'admin'

  File domainDir
  int adminPort = 4848
  int instancePort = 8080

  String domainProperties
  String domainName

  File archivePath
  String targetName

  // for remote deployment
  String host
  File passwordFile

  def glassfish3(Closure closure) {
    closure.delegate = this
    closure()
  }

}
