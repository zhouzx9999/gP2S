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

package com.gene.bioinfo.ms.gp2s.web;

import com.gene.bioinfo.ms.gp2s.domain.NegativeStainProtocol;
import com.gene.bioinfo.ms.gp2s.repository.NegativeStainProtocolRepository;
import com.gene.bioinfo.ms.gp2s.web.base.BaseRestITCase;
import javax.annotation.Nullable;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class NegativeStainProtocolRestControllerITCase extends BaseRestITCase<NegativeStainProtocol> {

    @Autowired
    private NegativeStainProtocolRepository repository;

    @Before
    public void setUp() throws Exception {
        initBaseRestTests(repository);
    }

    @Override
    public String getUri() {
        return "/api/v1/negative-stain-protocol/";
    }

    @Override
    public NegativeStainProtocol createEntity(@Nullable Long id, @Nullable String label, @Nullable String slug) {

        return NegativeStainProtocol.builder().id(id).label(label).slug(slug)
                .name("stain name")
                .ph(2.2f)
                .concentration(50f)
                .temperature(-100f)
                .incubationTime(10)
                .description("Lorem Ipsum").build();
    }


    @Override
    protected String createRequestBody(String label) throws IOException {
        return json(NegativeStainProtocol.builder().label(label)
                .name("stain name")
                .ph(2.2f)
                .concentration(50f)
                .temperature(-100f)
                .incubationTime(10)
                .description("Lorem Ipsum").build());
    }
}
