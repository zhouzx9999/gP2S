<!--
  - Copyright 2018 Genentech Inc.
  -
  - Licensed under the Apache License, Version 2.0 (the "License");
  - you may not use this file except in compliance with the License.
  - You may obtain a copy of the License at
  -
  -     http://www.apache.org/licenses/LICENSE-2.0
  -
  - Unless required by applicable law or agreed to in writing, software
  - distributed under the License is distributed on an "AS IS" BASIS,
  - WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  - See the License for the specific language governing permissions and
  - limitations under the License.
  -->

<template>
  <div class="image-processing-list-view list-view scrollable-container">
    <div class="list-view__header">
      <el-button class="list-view__action-buttons__submit"
                 @click="$router.push({ name: 'admin-software-image_processing-new' })">
        Create new image processing software
      </el-button>
    </div>

    <el-col class="list-view__components scrollable" :xs="15">
      <el-row v-for="(entity, index) in imageProcessingSoftwareCount"
              :key="index">
        <dashboard-list-item :entity="entity" entityType="IMAGE_PROCESSING_SOFTWARE">
          <template slot="left-pane">
            <el-row class="list-view__link-label-wrapper">
              <router-link :to="{ name: 'admin-software-image_processing-view', params: {id: entity.slug}}"
                           class="list-view__link-label" :id="'image_processing-'  + index + '-label-link'">{{
                entity.label }}
              </router-link>
            </el-row>
          </template>

          <el-row>
            <label class="list-view__label">Available version(s)</label>
            <div class="list-view__value">
                  <span v-for="(version, index) in entity.softwareVersions">
                    {{ version }}
                    <span v-if="index < entity.softwareVersions.length - 1">, </span>
                  </span>
            </div>
          </el-row>
        </dashboard-list-item>
      </el-row>
    </el-col>
  </div>
</template>

<script>
  import ImageProcessingSoftwareService from '@/services/ImageProcessingSoftwareService'
  import DashboardListItem from '@/components/App/DashboardListItem'

  export default {
    name: 'image-processing-list-view',

    components: {DashboardListItem},

    data () {
      return {
        imageProcessingSoftwareCount: []
      }
    },

    methods: {
      loadEntities () {
        this._imageProcessingSoftwareService.listEntities()
          .then(result => {
            this.imageProcessingSoftwareCount = result.data
          })
          .catch(error => this.$log.error(error))
      }
    },

    created () {
      this._imageProcessingSoftwareService = new ImageProcessingSoftwareService()
    },

    mounted () {
      this.loadEntities()
    }
  }
</script>
