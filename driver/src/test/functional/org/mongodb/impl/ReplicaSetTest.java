/*
 * Copyright (c) 2008 - 2013 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mongodb.impl;

import category.ReplicaSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mongodb.DatabaseTestCase;
import org.mongodb.Document;
import org.mongodb.ReadPreference;
import org.mongodb.connection.MongoTimeoutException;
import org.mongodb.connection.Tags;

@Category(ReplicaSet.class)
public class ReplicaSetTest extends DatabaseTestCase {
    @Test
    public void shouldFindPrimary() {
        collection.insert(new Document("a", 1));

        collection.count();
    }

    @Test(expected = MongoTimeoutException.class)
    public void shouldThrowTimeoutException() {
        collection.readPreference(ReadPreference.nearest(new Tags("fakeTag", "fakeValue"))).count();
    }
}
