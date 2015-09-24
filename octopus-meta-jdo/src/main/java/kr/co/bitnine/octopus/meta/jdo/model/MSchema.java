/*
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

package kr.co.bitnine.octopus.meta.jdo.model;

import kr.co.bitnine.octopus.meta.model.MetaDataSource;
import kr.co.bitnine.octopus.meta.model.MetaSchema;
import kr.co.bitnine.octopus.meta.model.MetaTable;

import javax.jdo.annotations.*;
import java.util.ArrayList;
import java.util.Collection;

@PersistenceCapable
public class MSchema implements MetaSchema
{
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    private long ID;

    @Persistent
    @Column(length = 128)
    private String name;

    private MDataSource dataSource;

    @Persistent
    @Column(length = 1024)
    private String comment;

    @Persistent(mappedBy = "schema")
    private Collection<MTable> tables;

    public MSchema(String name, MDataSource dataSource)
    {
        this.name = name;
        this.dataSource = dataSource;
        comment = "";
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public MetaDataSource getDataSource()
    {
        return dataSource;
    }

    @Override
    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    @Override
    public Collection<MetaTable> getTables()
    {
        return new ArrayList<MetaTable>(tables);
    }
}
