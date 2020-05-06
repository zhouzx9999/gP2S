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

package com.gene.bioinfo.ms.gp2s.repository;

import com.gene.bioinfo.ms.gp2s.service.attachment.File;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.gridfs.GridFSDBFile;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
@Profile("!integration-test")
public class GridFSFileRepository implements FileRepository {

    private static final String MONGODB_ID = "_id";
    private final GridFsTemplate gridFsOperations;

    private GridFSBucket gridFSBucket;

    @Autowired
    public GridFSFileRepository(@NonNull final GridFsTemplate gridFsOperations) {
        this.gridFsOperations = gridFsOperations;
    }

    @Override
    @NonNull
    public String store(@NonNull final File file) {
        return gridFsOperations.store(file.getContentStream(), file.getFileName(), file.getContentType(), file.getFileMetadata())
                .get()
                .toString();
    }

    @Override
    public File findOne(@NonNull final String fileId) {
        final GridFSFile fSDBFile = gridFsOperations.findOne(new Query().addCriteria(where(MONGODB_ID).is(fileId)));
        if (fSDBFile == null) {
            return null;
        }
        GridFSDownloadStream in = gridFSBucket.openDownloadStream(fSDBFile.getObjectId());

        GridFsResource resource = new GridFsResource(fSDBFile,in);
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return File.builder()
                .fileName(fSDBFile.getFilename())
                .contentType
                        (fSDBFile.getContentType())
                .length(fSDBFile.getLength())
                .contentStream(inputStream)
                .fileMetadata(fSDBFile.getMetadata())
                .build();
    }

    @Override
    public void delete(@NonNull final String mongoId) {
        gridFsOperations.delete(new Query(where(MONGODB_ID).is(mongoId)));
    }
}
