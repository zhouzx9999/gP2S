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

package com.gene.bioinfo.ms.gp2s.domain;

import com.gene.bioinfo.ms.gp2s.domain.base.BaseAuditableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
@MappedSuperclass
public abstract class Attachment extends BaseAuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mongo_id")
    private String mongoId;

    @Column(name = "file_name")
    private String fileName;

    public Attachment(Long id, Integer version,
                      Date createdDate, Date modifiedDate, String createdBy,
                      String modifiedBy, String mongoId, String fileName) {
        super(id, version, createdDate, modifiedDate, createdBy, modifiedBy);
        this.mongoId = mongoId;
        this.fileName = fileName;
    }
}
