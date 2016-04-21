/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
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
package com.arthas.learningcurve.injection.component;

import com.arthas.learningcurve.activity.AddNewCategoryActivity;
import com.arthas.learningcurve.activity.LoginActivity;
import com.arthas.learningcurve.injection.PerActivity;
import com.arthas.learningcurve.injection.module.ActivityModule;
import com.arthas.learningcurve.injection.module.AddCategoryModule;
import com.arthas.learningcurve.injection.module.UserManageModule;

import dagger.Component;

/**

 * Injects user specific Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, AddCategoryModule.class})
public interface AddCategoryComponent extends ActivityComponent {
  void inject(AddNewCategoryActivity activity);
}
