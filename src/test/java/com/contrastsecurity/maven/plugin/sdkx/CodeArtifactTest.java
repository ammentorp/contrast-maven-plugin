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

import com.contrastsecurity.maven.plugin.Resources;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.junit.jupiter.api.Test;

/** Unit tests for {@link CodeArtifact} */
final class CodeArtifactTest {

  @Test
  void gson_deserialization_configuration() throws IOException {
    // WHEN deserialize code-artifact JSON with GSON
    final Gson gson = GsonFactory.create();
    final CodeArtifact artifact;
    try (InputStream is = Resources.stream("/scan-api/code-artifacts/code-artifact.json")) {
      artifact = gson.fromJson(new InputStreamReader(is), CodeArtifact.class);
    }

    // THEN has expected ID
    final CodeArtifact expected = new CodeArtifact("code-artifact-id");
    assertThat(artifact).isEqualTo(expected);
  }
}
