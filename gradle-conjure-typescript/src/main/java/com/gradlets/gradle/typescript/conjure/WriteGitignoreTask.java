/*
 * (c) Copyright 2021 Felipe Orozco, Robert Kruszewski. All rights reserved.
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

package com.gradlets.gradle.typescript.conjure;

import org.gradle.api.DefaultTask;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;
import org.gradle.util.GFileUtils;

public class WriteGitignoreTask extends DefaultTask {
    private final RegularFileProperty outputFile = getProject().getObjects().fileProperty();
    private final Property<String> contents = getProject().getObjects().property(String.class);

    @OutputFile
    public final RegularFileProperty getOutputFile() {
        return outputFile;
    }

    @Input
    public final Property<String> getContents() {
        return contents;
    }

    @TaskAction
    public final void compileFiles() {
        GFileUtils.writeFile(contents.get(), getOutputFile().getAsFile().get());
    }
}
