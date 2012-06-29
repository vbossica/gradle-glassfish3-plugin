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

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author vladimir
 */
abstract class AbstractGlassfishTask extends DefaultTask {

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  @TaskAction
  public final void process() {
    GlassfishPluginConvention convention = project.convention.plugins.glassfish3 as GlassfishPluginConvention

    /* sets default values */
    if (convention.domainName == null)
      convention.domainName = project.name
    if (convention.targetName == null)
      convention.targetName = project.name

    process(convention)
  }

  protected abstract void process(GlassfishPluginConvention convention)

  def String formatArgs(Map args, String delimiter) {
    def arguments = ''
    args.each { key, value ->
      if (value != null) {
        arguments += "--${key}${delimiter}${value} "
      }
    }
    return arguments.trim()
  }

  def void execute(String command) {
    def initialSize = 4096
    def outStream = new ByteArrayOutputStream(initialSize)
    def errStream = new ByteArrayOutputStream(initialSize)

    println "executing '${command}'"

    def process = command.execute()
    process.consumeProcessOutput(outStream, errStream)
    def exitVal = process.waitFor()
    if (exitVal != 0) {
      println 'out:\n' + outStream
      println 'err:\n' + errStream
    }
  }

}
