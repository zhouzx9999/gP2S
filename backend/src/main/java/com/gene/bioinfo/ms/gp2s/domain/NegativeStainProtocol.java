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

import com.gene.bioinfo.ms.gp2s.domain.base.BaseSlugAndLabelEntity;
import com.gene.bioinfo.ms.gp2s.infrastructure.constants.DomainConstants;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of= {}, callSuper = true)
@Table(name="negative_stain_protocol")
@Entity
public class NegativeStainProtocol extends BaseSlugAndLabelEntity{

	@Column(length = DomainConstants.SHORT_STRING_LENGTH)
	private String name;
	
	private Float ph;
	
	private Float concentration;
	
	private Float temperature;
	/**
	 * Time in seconds
	 */
	@Column(name="incubation_time")
	private Integer incubationTime;
	
	private String description;
	
	@Builder
	public NegativeStainProtocol(Long id, String label, String slug, Integer version,
            Date createdDate, Date modifiedDate, String createdBy,
            String modifiedBy, String name, Float ph, Float concentration, Float temperature,
            Integer incubationTime, String description) {
		super(id, label, slug, version, createdDate, modifiedDate, createdBy, modifiedBy);
		this.name = name;
		this.ph = ph;
		this.concentration = concentration;
		this.temperature = temperature;
		this.incubationTime = incubationTime;
		this.description = description;
	}
}
