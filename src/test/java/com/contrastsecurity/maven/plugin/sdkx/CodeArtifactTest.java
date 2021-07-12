package com.contrastsecurity.maven.plugin.sdkx;

/*-
 * #%L
 * Contrast Maven Plugin
 * %%
 * Copyright (C) 2021 Contrast Security, Inc.
 * %%
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
 * #L%
 */

import static org.assertj.core.api.Assertions.assertThat;

import com.google.gson.Gson;
import java.io.StringReader;
import org.junit.jupiter.api.Test;

/** Unit tests for {@link CodeArtifact} */
final class CodeArtifactTest {

  @Test
  void gson_deserialization_configuration() {
    // GIVEN some JSON for a Code Artifact
    final String id = "code-artifact-id";
    final String json = "{\"id\": \"" + id + "\"}";

    // WHEN deserialize with GSON
    final CodeArtifact artifact = new Gson().fromJson(new StringReader(json), CodeArtifact.class);

    // THEN has expected ID
    final CodeArtifact expected = new CodeArtifact(id);
    assertThat(artifact).isEqualTo(expected);
  }
}
