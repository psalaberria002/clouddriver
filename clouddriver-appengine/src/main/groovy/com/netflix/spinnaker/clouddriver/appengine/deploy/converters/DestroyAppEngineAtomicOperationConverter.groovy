/*
 * Copyright 2016 Google, Inc.
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

package com.netflix.spinnaker.clouddriver.appengine.deploy.converters

import com.netflix.spinnaker.clouddriver.appengine.AppEngineOperation
import com.netflix.spinnaker.clouddriver.appengine.deploy.description.DestroyAppEngineDescription
import com.netflix.spinnaker.clouddriver.appengine.deploy.ops.DestroyAppEngineAtomicOperation
import com.netflix.spinnaker.clouddriver.orchestration.AtomicOperation
import com.netflix.spinnaker.clouddriver.orchestration.AtomicOperations
import com.netflix.spinnaker.clouddriver.security.AbstractAtomicOperationsCredentialsSupport
import org.springframework.stereotype.Component

@AppEngineOperation(AtomicOperations.DESTROY_SERVER_GROUP)
@Component
class DestroyAppEngineAtomicOperationConverter extends AbstractAtomicOperationsCredentialsSupport {
  AtomicOperation convertOperation(Map input) {
    new DestroyAppEngineAtomicOperation(convertDescription(input))
  }

  DestroyAppEngineDescription convertDescription(Map input) {
    AppEngineAtomicOperationConverterHelper.convertDescription(input, this, DestroyAppEngineDescription)
  }
}