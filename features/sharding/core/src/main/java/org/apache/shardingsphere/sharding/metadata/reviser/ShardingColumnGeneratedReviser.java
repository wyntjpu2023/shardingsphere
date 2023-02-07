/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.sharding.metadata.reviser;

import org.apache.shardingsphere.infra.metadata.database.schema.decorator.reviser.column.ColumnGeneratedReviser;
import org.apache.shardingsphere.infra.metadata.database.schema.loader.model.ColumnMetaData;
import org.apache.shardingsphere.sharding.rule.ShardingRule;

/**
 * Sharding column generated reviser.
 */
public final class ShardingColumnGeneratedReviser implements ColumnGeneratedReviser<ShardingRule> {
    
    @Override
    public boolean revise(final ColumnMetaData originalMetaData, final ShardingRule rule) {
        return rule.findTableRuleByActualTable(originalMetaData.getName())
                .map(optional -> originalMetaData.getName().equalsIgnoreCase(optional.getGenerateKeyColumn().orElse(null))).orElseGet(originalMetaData::isGenerated);
    }
    
    @Override
    public String getType() {
        return ShardingRule.class.getSimpleName();
    }
}