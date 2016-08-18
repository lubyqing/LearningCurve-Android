/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.arthas.learningcurve.injection.module;

import com.arthas.learningcurve.executor.PostExecutionThread;
import com.arthas.learningcurve.executor.ThreadExecutor;
import com.arthas.learningcurve.interactor.BaseInteractor;
import com.arthas.learningcurve.interactor.impl.AddCategoryInteractorImpl;
import com.arthas.learningcurve.interactor.impl.LoginInteractorImpl;
import com.arthas.learningcurve.interactor.impl.SmsInteractorImpl;
import com.arthas.learningcurve.repository.CategoryRepository;
import com.arthas.learningcurve.repository.SmsRepository;
import com.arthas.learningcurve.repository.UserManageRepository;
import com.arthas.learningcurve.repository.impl.CategoryRepositoryImpl;
import com.arthas.learningcurve.repository.impl.SmsRepositoryImpl;
import com.arthas.learningcurve.repository.impl.UserManageRepositoryImpl;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides user related collaborators.
 */
@Module
public class AddCategoryModule {

    @Provides
    @Named("addCategoryInteractor")
    BaseInteractor provideAddCategoryInteractor(
            CategoryRepository categoryRepository, ThreadExecutor threadExecutor,
            PostExecutionThread postExecutionThread) {
        return new AddCategoryInteractorImpl(categoryRepository,
                threadExecutor,
                postExecutionThread
        );
    }

    @Provides
    CategoryRepository provideCategoryRepository(CategoryRepositoryImpl categoryRepository){
        return categoryRepository;
    }

}
