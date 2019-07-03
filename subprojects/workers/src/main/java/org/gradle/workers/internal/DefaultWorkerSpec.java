/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.workers.internal;

import org.gradle.api.Action;
import org.gradle.process.internal.JavaForkOptionsFactory;
import org.gradle.workers.WorkerParameters;
import org.gradle.workers.WorkerSpec;

public class DefaultWorkerSpec<T extends WorkerParameters> extends DefaultBaseWorkerSpec implements WorkerSpec<T> {
    private final T parameters;

    public DefaultWorkerSpec(JavaForkOptionsFactory forkOptionsFactory, T parameters) {
        super(forkOptionsFactory);
        this.parameters = parameters;
    }

    @Override
    public T getParameters() {
        return parameters;
    }

    @Override
    public void parameters(Action<T> action) {
        action.execute(parameters);
    }
}