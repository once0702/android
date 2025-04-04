// Copyright 2000-2025 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.android.tools.idea.gradle.dsl.model.java;

import com.android.tools.idea.gradle.dsl.api.dependencies.DependenciesModel;
import com.android.tools.idea.gradle.dsl.api.java.JavaDeclarativeModel;
import com.android.tools.idea.gradle.dsl.api.java.JavaTestDeclarativeModel;
import com.android.tools.idea.gradle.dsl.api.java.LanguageLevelPropertyModel;
import com.android.tools.idea.gradle.dsl.model.GradleDslBlockModel;
import com.android.tools.idea.gradle.dsl.model.dependencies.ScriptDependenciesModelImpl;
import com.android.tools.idea.gradle.dsl.parser.dependencies.DependenciesDslElement;
import com.android.tools.idea.gradle.dsl.parser.java.JavaDclElement;
import com.android.tools.idea.gradle.dsl.parser.java.TestingDclElement;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class JavaDeclarativeModelImpl extends GradleDslBlockModel implements JavaDeclarativeModel {
  @NonNls public static final String JAVA_VERSION = "mJavaVersion";
  @NonNls public static final String MAIN_CLASS = "mMainClass";

  public JavaDeclarativeModelImpl(@NotNull JavaDclElement dslElement) {
    super(dslElement);
  }

  @NotNull
  @Override
  public LanguageLevelPropertyModel javaVersion() {
    return getLanguageModelForProperty(JAVA_VERSION);
  }

  @NotNull
  @Override
  public String mainClass() {
    //TODO temporary
    return getModelForProperty(MAIN_CLASS).toString()
      .replace("mainClass = ", "").replace("\"", "");
  }

  @NotNull
  @Override
  public DependenciesModel dependencies() {
    DependenciesDslElement dependenciesDslElement = myDslElement.ensurePropertyElement(DependenciesDslElement.DEPENDENCIES);
    return new ScriptDependenciesModelImpl(dependenciesDslElement);
  }

  @Override
  public @NotNull JavaTestDeclarativeModel testing() {
    TestingDclElement testingDclElement = myDslElement.ensurePropertyElement(TestingDclElement.TESTING);
    return new JavaTestDeclarativeModelImpl(testingDclElement);
  }
}
