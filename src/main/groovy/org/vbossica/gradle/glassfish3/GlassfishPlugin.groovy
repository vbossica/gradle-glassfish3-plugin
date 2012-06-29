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

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author vladimir
 */
class GlassfishPlugin implements Plugin<Project> {

  def void apply(Project project) {
    project.convention.plugins.glassfish3 = new GlassfishPluginConvention()

    GlassfishCreateDomainTask createTask = project.getTasks().add("createDomain", GlassfishCreateDomainTask.class)
    createTask.group = 'Glassfish3'
    createTask.description = 'Creates a Glassfish3 domain.'

    GlassfishDeleteDomainTask deleteTask = project.getTasks().add("deleteDomain", GlassfishDeleteDomainTask.class)
    deleteTask.group = 'Glassfish3'
    deleteTask.description = 'Deletes the Glassfish3 domain.'

    GlassfishStartDomainTask startTask = project.getTasks().add("startDomain", GlassfishStartDomainTask.class)
    startTask.group = 'Glassfish3'
    startTask.description = 'Starts the Glassfish3 domain.'

    GlassfishStopDomainTask stopTask = project.getTasks().add("StopDomain", GlassfishStopDomainTask.class)
    stopTask.group = 'Glassfish3'
    stopTask.description = 'Stops the Glassfish3 domain.'

    GlassfishDeployTask deployTask = project.getTasks().add("deployApp", GlassfishDeployTask.class)
    deployTask.group = 'Glassfish3'
    deployTask.description = 'Deploys the application onto the Glassfish3 domain.'

    GlassfishUndeployTask undeployTask = project.getTasks().add("undeployApp", GlassfishUndeployTask.class)
    undeployTask.group = 'Glassfish3'
    undeployTask.description = 'Undeploys the application from the Glassfish3 domain.'
  }

}