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
class GlassfishDeployTask extends AbstractGlassfishTask {

  File archivePath
  String targetName
  String contextRoot

  protected void process(GlassfishPluginConvention convention) {

    def authArgs = [
      user: convention.userName,
      port: convention.adminPort,
      // passwordfile: convention.passwordFile,
      // host: convention.host,
    ]

    def args = [
      contextroot: contextRoot != null ? contextRoot : project.name,
      name: targetName != null ? targetName : convention.targetName
    ]

    def authArguments = formatArgs(authArgs, ' ')
    def arguments = formatArgs(args, ' ')

    if (archivePath == null && convention.archivePath != null) {
      archivePath = convention.archivePath
    } else if (archivePath != null) {
      def tasks = project.getTasksByName('war', false).toList()
      def warTask = tasks.get(0)

      archivePath = (File) warTask.property('archivePath')
    }

    execute("${convention.asadminExec} ${authArguments} deploy ${arguments} ${archivePath}")
  }

}
