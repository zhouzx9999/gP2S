/*
 * Copyright 2018 Genentech Inc.
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

/**
 * Created by Przemyslaw Stankowski on 17.10.2017.
 */

import { HTTP } from '@/utils/http-common'

const URI = 'vitrification-machine/'

export default class VitrificationMachineService {

  getEntityBySlugOrId (slugOrId) {
    return HTTP.get(URI + slugOrId)
  }

  listEntities () {
    return HTTP.get(URI)
  }

  createEntity (entity) {
    const body = JSON.stringify(entity)
    return HTTP.post(URI, body)
  }

  saveEntity (entity) {
    return HTTP.put(URI, entity)
  }
}
