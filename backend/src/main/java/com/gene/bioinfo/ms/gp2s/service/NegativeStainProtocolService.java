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

package com.gene.bioinfo.ms.gp2s.service;

import com.gene.bioinfo.ms.gp2s.domain.NegativeStainProtocol;
import com.gene.bioinfo.ms.gp2s.repository.NegativeStainProtocolRepository;
import com.gene.bioinfo.ms.gp2s.service.base.BaseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NegativeStainProtocolService extends BaseRestService<NegativeStainProtocol> {

    @Autowired
    NegativeStainProtocolService(final NegativeStainProtocolRepository negativeStainProtocolRepository) {
        super(negativeStainProtocolRepository);
    }

}
